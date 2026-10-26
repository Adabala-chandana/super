USE VolumeLab;
GO


CREATE NONCLUSTERED INDEX IX_EventLog_SourceSystem_CreatedAt_Id
ON dbo.EventLog (
    SourceSystem ASC,
    CreatedAt DESC,
    Id DESC
)
INCLUDE (
    Status,
    Payload
);
GO