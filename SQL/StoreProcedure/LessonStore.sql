DROP PROC IF EXISTS selLesson
GO
CREATE PROC selLesson
@id INT
AS
BEGIN
	SELECT * FROM LESSON
	WHERE ID = @id 
END
GO


DROP PROC IF EXISTS selAllLesson
GO
CREATE PROC selAllLesson
AS
BEGIN
	SELECT * FROM LESSON 
END
GO
--EXEC selAllBookmark

DROP PROC IF EXISTS selTop3Lesson
GO
CREATE PROC selTop3Lesson
AS
BEGIN
	SELECT TOP 3 * FROM LESSON ORDER BY ID DESC
END
GO

DROP PROC IF EXISTS insertLesson
GO
CREATE PROC insertLesson
@title NVARCHAR(100),
@image NVARCHAR(200)
AS
BEGIN
	INSERT INTO LESSON 
	VALUES (@title, @image)
END
GO



DROP PROC IF EXISTS updateLesson
GO
CREATE PROC updateLesson
@id INT,
@title NVARCHAR(100),
@image NVARCHAR(200)
AS
BEGIN
	UPDATE LESSON
	SET TITLE = @title, [IMAGE] = @image
	WHERE ID = @id
END
GO



DROP PROC IF EXISTS deleteLesson
GO
CREATE PROC deleteLesson
@id INT
AS
BEGIN
	DELETE FROM LESSON
	WHERE ID = @id
END
GO


DROP PROC IF EXISTS countLesson
GO
CREATE PROC countLesson
AS
BEGIN
	SELECT COUNT(ID) total FROM LESSON
END
GO

DROP PROC IF EXISTS selLessonByPages
GO
CREATE PROC selLessonByPages
@PageNumber AS INT, @RowsOfPage AS INT
AS
BEGIN
	SELECT * FROM LESSON
	ORDER BY ID DESC
	OFFSET (@pageNumber - 1) * @RowsOfPage ROWS
	FETCH NEXT @RowsOfPage ROWS ONLY
END
GO 

DROP PROC IF EXISTS searchAllLesson
GO
CREATE PROC searchAllLesson
@data NVARCHAR(200)
AS 
BEGIN
	SELECT * FROM LESSON
	WHERE TITLE like @data+'%'  OR [ID] like @data+'%'
END
GO