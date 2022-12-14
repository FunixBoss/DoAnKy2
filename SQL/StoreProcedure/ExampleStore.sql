-- PROC SENTENCE EXAMPLES
DROP PROC IF EXISTS selEx
GO
CREATE PROC selEx
@id INT
AS
BEGIN
	SELECT * FROM EXAMPLE
	WHERE ID = @id 
END
GO
--EXEC selEx @id = 3



DROP PROC IF EXISTS selAllEx
GO
CREATE PROC selAllEx
AS
BEGIN
	SELECT * FROM EXAMPLE 
END
GO
--EXEC selAllEx



DROP PROC IF EXISTS insertEx
GO
CREATE PROC insertEx
@content NVARCHAR(200),
@meaning NVARCHAR(200),
@meaning_id INT
AS
BEGIN
	INSERT INTO EXAMPLE 
	VALUES (@content, @meaning, @meaning_id)
END
GO
--EXEC insertEx N'LoL'




DROP PROC IF EXISTS updateEx
GO
CREATE PROC updateEx
@id INT,
@content NVARCHAR(200),
@meaning NVARCHAR(200),
@meaning_id INT
AS
BEGIN
	UPDATE EXAMPLE
	SET CONTENT = @content, MEANING = @meaning, MEANING_ID = @meaning_id
	WHERE ID = @id
END
GO
--EXEC updateEx 1, N'updated'




DROP PROC IF EXISTS deleteEx
GO
CREATE PROC deleteEx
@id INT
AS
BEGIN
	DELETE FROM EXAMPLE
	WHERE ID = @id
END
GO
--EXEC deleteEx 3



DROP PROC IF EXISTS selExamplesByMeaningId
GO
CREATE PROC selExamplesByMeaningId
@meaning_id INT
AS
BEGIN
	SELECT * FROM EXAMPLE
	WHERE MEANING_ID = @meaning_id
END
GO
