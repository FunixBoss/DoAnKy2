-- CATEGORY PROC
DROP PROC IF EXISTS selCate
GO
CREATE PROC selCate
@id INT
AS
BEGIN
	SELECT * FROM CATEGORY
	WHERE ID = @id 
END
GO
--EXEC selCate @id = 11




DROP PROC IF EXISTS selAllCate
GO
CREATE PROC selAllCate
AS
BEGIN
	SELECT * FROM CATEGORY 
END
GO
--EXEC selAllCate




DROP PROC IF EXISTS insertCate
GO
CREATE PROC insertCate
@name NVARCHAR(50),
@image_icon NVARCHAR(50)
AS
BEGIN
	INSERT INTO CATEGORY 
	VALUES (@name, @image_icon)
END
GO
--EXEC insertCate N'Shit', '/image/shit.jpg', null



DROP PROC IF EXISTS updateCate
GO
CREATE PROC updateCate
@id INT,
@name NVARCHAR(50),
@image_icon NVARCHAR(50)
AS
BEGIN
	UPDATE CATEGORY
	SET [NAME] = @name, IMAGE_ICON = @image_icon
	WHERE ID = @id
END
GO
--EXEC updateCate 1, N'updated', N'updated', null



DROP PROC IF EXISTS deleteCate
GO
CREATE PROC deleteCate
@id INT
AS
BEGIN
	DELETE FROM CATEGORY
	WHERE ID = @id
END
GO
--EXEC deleteCate 3



DROP PROC IF EXISTS selAllVocabInCateById 
GO
CREATE PROC selAllVocabInCateById
@cate_id INT
AS
BEGIN
	SELECT * FROM VOCABULARY
	WHERE VOCABULARY.CATEGORY_ID = @cate_id
END
GO	