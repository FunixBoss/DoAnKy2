﻿DROP PROC IF EXISTS selUser
GO
CREATE PROC selUser
@id INT
AS
BEGIN
	SELECT [USER].ID, [USER].EMAIL, [USER].[ROLE_ID],[USER].CREATED_AT, [USER].UPDATED_AT 
	FROM [USER]
	WHERE [USER].ID = @id
END
GO
-- EXEC selUser @id = 1


DROP PROC IF EXISTS selUserByLevel
GO
CREATE PROC selUserByLevel
@role_id INT
AS
BEGIN
	SELECT [USER].ID, [USER].EMAIL, [USER].[ROLE_ID],[USER].CREATED_AT, [USER].UPDATED_AT  
	FROM [USER]
	WHERE [USER].[ROLE_ID] = @role_id
END
GO

-- EXEC selUserByLevel 1


DROP PROC IF EXISTS selAllUser
GO 
CREATE PROC selAllUser
AS
BEGIN
	SELECT [USER].ID, [USER].EMAIL, [USER].[ROLE_ID],[USER].CREATED_AT, [USER].UPDATED_AT 
	FROM [USER]
END
GO
--EXEC selAllUser 




DROP PROC IF EXISTS insertUser
GO
CREATE PROC insertUser
@email NVARCHAR(200),
@password NVARCHAR(200),
@role_id INT
AS
BEGIN
	INSERT INTO [USER] (EMAIL, [PASSWORD], [ROLE_ID], CREATED_AT, UPDATED_AT)
	VALUES (@email, @password, @role_id, GETDATE(), GETDATE()) 
END
GO



DROP PROC IF EXISTS updatePasswordInfoUser
GO
CREATE PROC updatePasswordInfoUser
@id INT ,
@password NVARCHAR(200)
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
	SELECT [ROLE_ID] FROM [USER]
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

DROP PROC IF EXISTS selIdByUserEmail
GO
CREATE PROC selIdByUserEmail
@email NVARCHAR(200)
AS
BEGIN
	SELECT	[ID] FROM [USER]
	WHERE [EMAIL] = @email
END
GO


DROP PROC IF EXISTS countUser
GO
CREATE PROC countUser
AS
BEGIN
	SELECT COUNT(ID) total FROM (SELECT * FROM [USER] WHERE [ROLE_ID] = 2) AS MEMBER
END
GO
 --EXEC countUser

-- phan trang lay bao nhieu dong tiep theo

DROP PROC IF EXISTS selUserByPages
GO
CREATE PROC selUserByPages
@PageNumber AS INT, @RowsOfPage AS INT
AS
BEGIN
	SELECT MEMBER.ID, MEMBER.EMAIL, MEMBER.[ROLE_ID],MEMBER.CREATED_AT, MEMBER.UPDATED_AT  
	FROM (SELECT [USER].ID, [USER].EMAIL, [USER].[ROLE_ID],[USER].CREATED_AT, [USER].UPDATED_AT  
	FROM [USER] WHERE [ROLE_ID] = 2) AS MEMBER
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
	SELECT COUNT(ID) total FROM (SELECT * FROM [USER] WHERE [ROLE_ID] = 1) AS [ADMIN]
END
GO
-- EXEC countAdmin

-- phan trang lay bao nhieu dong tiep theo

DROP PROC IF EXISTS selAdminByPages
GO
CREATE PROC selAdminByPages
@PageNumber AS INT, @RowsOfPage AS INT
AS
BEGIN
	SELECT [ADMIN].ID, [ADMIN].EMAIL, [ADMIN].[ROLE_ID],[ADMIN].CREATED_AT, [ADMIN].UPDATED_AT  
	FROM (SELECT [USER].ID, [USER].EMAIL, [USER].[ROLE_ID],[USER].CREATED_AT, [USER].UPDATED_AT  FROM [USER] WHERE [ROLE_ID] = 1) AS [ADMIN]
	ORDER BY ID
	OFFSET (@pageNumber - 1) * @RowsOfPage ROWS
	FETCH NEXT @RowsOfPage ROWS ONLY
END
GO

--- EXEC selAdminByPages 1, 10
DROP PROC IF EXISTS selIdByUserEmail
GO
CREATE PROC selIdByUserEmail
@email NVARCHAR(200)
AS
BEGIN
	SELECT	[ID] FROM [USER]
	WHERE [EMAIL] = @email
END
GO

