DROP PROC IF EXISTS selUser
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



