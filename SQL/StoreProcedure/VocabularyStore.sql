-- VOCABULARY STORE
DROP PROC IF EXISTS selVocab
GO
CREATE PROC selVocab
@id INT

AS
BEGIN
	SELECT * FROM VOCABULARY
	WHERE ID = @id
END
GO
--EXEC selVocab @id = 1 



DROP PROC IF EXISTS selAllVocab
GO
CREATE PROC selAllVocab
AS
BEGIN
	SELECT * FROM VOCABULARY
END
GO
--EXEC selAllVocab




DROP PROC IF EXISTS insertVocab
GO
CREATE PROC insertVocab
@word NVARCHAR(200),
@image NVARCHAR(200),
@pronunciation NVARCHAR(200),
@category_id INT,
@word_type_id INT
AS
BEGIN
	INSERT INTO VOCABULARY
	VALUES (@word, @image, @pronunciation, @category_id, @word_type_id)
END
GO
--EXEC insertVocab @word = N'tomorrow', @image = N'/image/abc.jpg', @pronunciation = null, @word_meaning_id = null, @example_id = null, @category_id = null, @word_type_id = 1



DROP PROC IF EXISTS updateVocab
GO
CREATE PROC updateVocab
@id INT,
@word NVARCHAR(200),
@image NVARCHAR(200),
@pronuncation NVARCHAR(200),
@category_id INT,
@word_type_id INT
AS
BEGIN
	UPDATE VOCABULARY
	SET WORD = @word, [IMAGE] = @image, PRONUNCIATION = @pronuncation,
		CATEGORY_ID =@category_id, WORD_TYPE_ID = @word_type_id
	WHERE ID = @id
END
GO
--EXEC updateVocab 1, N'abc', N'abc.jpg', N'abc.mp3', null, null, null, 1



DROP PROC IF EXISTS deleteVocab
GO
CREATE PROC deleteVocab
@id INT
AS
BEGIN
	DELETE FROM VOCABULARY
	WHERE ID = @id
END
GO
--EXEC deleteVocab @id = 1



DROP PROC IF EXISTS selVocabByCateId
GO
CREATE PROC selVocabByCateId
@cate_id INT
AS 
BEGIN
	SELECT * FROM VOCABULARY
	WHERE CATEGORY_ID = @cate_id
END
GO
  


DROP PROC IF EXISTS countVocab
GO
CREATE PROC countVocab
AS
BEGIN
	SELECT COUNT(ID) total FROM VOCABULARY
END
GO
 --EXEC countVocab

-- phan trang lay bao nhieu dong tiep theo

DROP PROC IF EXISTS selVocabByPages
GO
CREATE PROC selVocabByPages
@PageNumber AS INT, @RowsOfPage AS INT
AS
BEGIN
	SELECT * FROM VOCABULARY
	ORDER BY ID
	OFFSET (@pageNumber - 1) * @RowsOfPage ROWS
	FETCH NEXT @RowsOfPage ROWS ONLY
END
GO 

--- EXEC selVocabByPages 2, 10