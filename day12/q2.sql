CREATE  INDEX IX_EventLog_Source_CreatedAt
ON dbo.EventLog (SourceSystem ASC, CreatedAt DESC, Id DESC)
INCLUDE (Status, Payload);