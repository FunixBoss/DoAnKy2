DROP PROC IF EXISTS selVocabContri
GO
CREATE PROC selVocabContri
@id INT
AS
BEGIN
	SELECT * FROM VOCABULARY_CONTRIBUTION
	WHERE ID = @id 
END
GO


DROP PROC IF EXISTS selAllVocabContri
GO
CREATE PROC selAllVocabContri
AS
BEGIN
	SELECT * FROM VOCABULARY_CONTRIBUTION 
END
GO
--EXEC selAllBookmark



DROP PROC IF EXISTS insertVocabContri
GO
CREATE PROC insertVocabContri
@word NVARCHAR(200),
@meaning NVARCHAR(200),
@user_id INT
AS
BEGIN
	INSERT INTO VOCABULARY_CONTRIBUTION 
	VALUES (@word, @meaning, @user_id)
END
GO



DROP PROC IF EXISTS updateVocabContri
GO
CREATE PROC updateVocabContri
@id INT,
@word NVARCHAR(200),
@meaning NVARCHAR(200),
@user_id INT
AS
BEGIN
	UPDATE VOCABULARY_CONTRIBUTION
	SET WORD = @word, MEANING = @meaning, [USER_ID] = @user_id
	WHERE ID = @id
END
GO



DROP PROC IF EXISTS deleteVocabContri
GO
CREATE PROC deleteVocabContri
@id INT
AS
BEGIN
	DELETE FROM VOCABULARY_CONTRIBUTION
	WHERE ID = @id
END
GO