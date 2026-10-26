USE VolumeLab;
GO

CREATE OR ALTER PROCEDURE dbo.PromoteEventLog
    @BatchSize INT = 50000
AS
BEGIN
    SET NOCOUNT ON;
    SET XACT_ABORT ON;

    DECLARE @StartTime      DATETIME2      = SYSDATETIME();
    DECLARE @RowsProcessed  INT            = 1;
    DECLARE @TotalRowsMoved INT            = 0;

    TRUNCATE TABLE dbo.EventLog;

    WHILE @RowsProcessed > 0     
    BEGIN
        BEGIN TRY
            BEGIN TRANSACTION;

                DELETE TOP (@BatchSize)
                FROM   dbo.EventLog_Staging
                OUTPUT deleted.CreatedAt,
                       deleted.Status,
                       deleted.SourceSystem,
                       deleted.Payload
                INTO   dbo.EventLog (CreatedAt, Status, SourceSystem, Payload);

                SET @RowsProcessed  = @@ROWCOUNT;
                SET @TotalRowsMoved = @TotalRowsMoved + @RowsProcessed;

            COMMIT TRANSACTION;

            PRINT CONCAT('  Moved so far: ', @TotalRowsMoved);

        END TRY
        BEGIN CATCH
            IF @@TRANCOUNT > 0
                ROLLBACK TRANSACTION;

            DECLARE @ErrorMessage  NVARCHAR(4000) = ERROR_MESSAGE();
            DECLARE @ErrorSeverity INT            = ERROR_SEVERITY();
            DECLARE @ErrorState    INT            = ERROR_STATE();

            RAISERROR(@ErrorMessage, @ErrorSeverity, @ErrorState);
            RETURN; 
        END CATCH;
    END 
    DECLARE @ElapsedSeconds DECIMAL(10, 3) =
        DATEDIFF(MILLISECOND, @StartTime, SYSDATETIME()) / 1000.0;

    PRINT '==============================';
    PRINT 'Total Rows Promoted: ' + CAST(@TotalRowsMoved AS VARCHAR(20));
    PRINT 'Elapsed Seconds:     ' + CAST(@ElapsedSeconds AS VARCHAR(20));
    PRINT '==============================';

    SELECT COUNT(*) AS EventLog_Count         FROM dbo.EventLog;
    SELECT COUNT(*) AS EventLog_Staging_Count FROM dbo.EventLog_Staging;
END;
GO

EXEC dbo.PromoteEventLog @BatchSize = 50000;
GO