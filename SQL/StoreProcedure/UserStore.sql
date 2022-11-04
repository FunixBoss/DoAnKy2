﻿DROP PROC IF EXISTS selUser
GO
CREATE PROC selUser
@id INT
AS
BEGIN
	SELECT [USER].ID, [USER].EMAIL, [USER].FULLNAME, [USER].PHONE_NUMBER, [USER].BIRTHDAY, [USER].[LEVEL],[USER].CREATED_AT, [USER].UPDATED_AT 
	FROM [USER]
	WHERE [USER].ID = @id
END
GO
-- EXEC selUser @id = 1


DROP PROC IF EXISTS selUserByLevel
GO
CREATE PROC selUserByLevel
@level INT
AS
BEGIN
	SELECT [USER].ID, [USER].EMAIL, [USER].FULLNAME, [USER].PHONE_NUMBER, [USER].BIRTHDAY, [USER].[LEVEL],[USER].CREATED_AT, [USER].UPDATED_AT  
	FROM [USER]
	WHERE [USER].[LEVEL] = @level
END
GO

-- EXEC selUserByLevel 1


DROP PROC IF EXISTS selAllUser
GO 
CREATE PROC selAllUser
AS
BEGIN
	SELECT [USER].ID, [USER].EMAIL, [USER].FULLNAME, [USER].PHONE_NUMBER, [USER].BIRTHDAY, [USER].[LEVEL],[USER].CREATED_AT, [USER].UPDATED_AT 
	FROM [USER]
END
GO
--EXEC selAllUser 




DROP PROC IF EXISTS insertUser
GO
CREATE PROC insertUser
@email NVARCHAR(200),
@password NVARCHAR(200),
@level INT, 
@fullname NVARCHAR(200),
@birthday DATE,
@phone_number NVARCHAR(11)
AS
BEGIN
	INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
	VALUES (@email, @password, @level, @fullname, @birthday, @phone_number, GETDATE(), GETDATE()) 
END
GO



DROP PROC IF EXISTS updatePrivateInfoUser
GO
CREATE PROC updatePrivateInfoUser
@id INT,
@fullname NVARCHAR(200),
@birthday DATE,
@phone_number NVARCHAR(11)
AS
BEGIN
	UPDATE [USER]
	SET FULLNAME = @fullname, BIRTHDAY = @birthday, PHONE_NUMBER = @phone_number
	WHERE ID = @id
END
GO
--EXEC updatePrivateInfoUser @id = 1, @fullname = N'Tín', @birthday = '2003-12-16', @phone_number = '0123457899'



DROP PROC IF EXISTS updatePasswordInfoUser
GO
CREATE PROC updatePasswordInfoUser
@id INT ,
@password NVARCHAR(50)
AS 
BEGIN 
	UPDATE [USER] 
	SET [PASSWORD] = @password
	WHERE ID = @id
END
GO
--EXEC updatePasswordInfoUser @id = 1, @password = N'123'



DROP PROC IF EXISTS deleteUser
GO
CREATE PROC deleteUser
@id INT
AS
BEGIN
	DELETE FROM [USER] 
	WHERE ID = @id 
END
GO
--EXEC deleteUser @id = 1





DROP PROC IF EXISTS selHistoryByUserId 
GO
CREATE PROC selHistoryByUserId
@user_Id INT
AS
BEGIN
	SELECT * FROM HISTORY
	WHERE [USER_ID] = @user_Id
END
GO




DROP PROC IF EXISTS selLevelByUserEmail
GO
CREATE PROC selLevelByUserEmail
@email NVARCHAR(200)
AS
BEGIN
	SELECT LEVEL FROM [USER]
	WHERE [EMAIL] = @email
END
GO


DROP PROC IF EXISTS selUserIfExist
GO
CREATE PROC selUserIfExist
@email NVARCHAR(200)
AS
BEGIN
	SELECT	[EMAIL] FROM [USER]
	WHERE [EMAIL] = @email
END
GO



DROP PROC IF EXISTS countUser
GO
CREATE PROC countUser
AS
BEGIN
	SELECT COUNT(ID) total FROM (SELECT * FROM [USER] WHERE LEVEL = 2) AS MEMBER
END
GO
 EXEC countUser

-- phan trang lay bao nhieu dong tiep theo

DROP PROC IF EXISTS selUserByPages
GO
CREATE PROC selUserByPages
@PageNumber AS INT, @RowsOfPage AS INT
AS
BEGIN
	SELECT MEMBER.ID, MEMBER.EMAIL, MEMBER.FULLNAME, MEMBER.PHONE_NUMBER, MEMBER.BIRTHDAY, MEMBER.[LEVEL],MEMBER.CREATED_AT, MEMBER.UPDATED_AT  
	FROM (SELECT [USER].ID, [USER].EMAIL, [USER].FULLNAME, [USER].PHONE_NUMBER, [USER].BIRTHDAY, [USER].[LEVEL],[USER].CREATED_AT, [USER].UPDATED_AT  FROM [USER] WHERE LEVEL = 2) AS MEMBER
	ORDER BY ID
	OFFSET (@pageNumber - 1) * @RowsOfPage ROWS
	FETCH NEXT @RowsOfPage ROWS ONLY
END
GO 

--- EXEC selUserByPages 2, 10


DROP PROC IF EXISTS countAdmin
GO
CREATE PROC countAdmin
AS
BEGIN
	SELECT COUNT(ID) total FROM (SELECT * FROM [USER] WHERE LEVEL = 1) AS [ADMIN]
END
GO
 EXEC countAdmin

-- phan trang lay bao nhieu dong tiep theo

DROP PROC IF EXISTS selAdminByPages
GO
CREATE PROC selAdminByPages
@PageNumber AS INT, @RowsOfPage AS INT
AS
BEGIN
	SELECT [ADMIN].ID, [ADMIN].EMAIL, [ADMIN].FULLNAME, [ADMIN].PHONE_NUMBER, [ADMIN].BIRTHDAY, [ADMIN].[LEVEL],[ADMIN].CREATED_AT, [ADMIN].UPDATED_AT  
	FROM (SELECT [USER].ID, [USER].EMAIL, [USER].FULLNAME, [USER].PHONE_NUMBER, [USER].BIRTHDAY, [USER].[LEVEL],[USER].CREATED_AT, [USER].UPDATED_AT  FROM [USER] WHERE LEVEL = 1) AS [ADMIN]
	ORDER BY ID
	OFFSET (@pageNumber - 1) * @RowsOfPage ROWS
	FETCH NEXT @RowsOfPage ROWS ONLY
END
GO

--- EXEC selAdminByPages 1, 10
