USE master
GO

DROP DATABASE IF EXISTS DICTIONARY
CREATE DATABASE DICTIONARY
GO

USE DICTIONARY
GO

-- CREATE TABLES USER AND RELATIVES 
DROP TABLE IF EXISTS [USER]
CREATE TABLE [USER]
(
    ID INT PRIMARY KEY IDENTITY,
    EMAIL NVARCHAR(200) UNIQUE NOT NULL,
	[PASSWORD] NVARCHAR(200) NOT NULL,
    [LEVEL] INT NOT NULL,

	FULLNAME NVARCHAR(200),
	BIRTHDAY DATE,
	PHONE_NUMBER NVARCHAR(11),

	CREATED_AT DATETIME,
	UPDATED_AT DATETIME,
)
GO

DROP TABLE IF EXISTS BOOKMARK
CREATE TABLE BOOKMARK
( 
	ID INT PRIMARY KEY IDENTITY,
	VOCABULARY_ID INT NOT NULL, 
	[USER_ID] INT NOT NULL,
)
GO

DROP TABLE IF EXISTS HISTORY
CREATE TABLE HISTORY
(
	ID INT PRIMARY KEY IDENTITY,
	VOCABULARY_ID INT NOT NULL, 
	[USER_ID] INT NOT NULL,
)
GO


-- CREATE TABLE VOCABULARY AND RELATIVES 
DROP TABLE IF EXISTS VOCABULARY
CREATE TABLE VOCABULARY
(
	ID INT PRIMARY KEY IDENTITY,
	WORD NVARCHAR(200) NOT NULL,
	-- MEDIA FILES -- source file from datalayer
	[IMAGE] NVARCHAR(200), 
	PRONUNCIATION NVARCHAR(200),


	-- RELATE TO OTHERS
	CATEGORY_ID INT,
	WORD_TYPE_ID INT NOT NULL,
)
GO

DROP TABLE IF EXISTS RELATIVES
CREATE TABLE RELATIVES
(
	ID INT PRIMARY KEY IDENTITY,
	WORD NVARCHAR(100) NOT NULL,
	VOCABULARY_ID INT NOT NULL,
)
GO

DROP TABLE IF EXISTS CATEGORY
CREATE TABLE CATEGORY
(
	ID INT PRIMARY KEY IDENTITY,
	[NAME] NVARCHAR(50) NOT NULL,
	IMAGE_ICON NVARCHAR(50),
)
GO

DROP TABLE IF EXISTS WORD_TYPE
CREATE TABLE WORD_TYPE
(
	ID INT PRIMARY KEY IDENTITY,
	[TYPE] NVARCHAR(20) NOT NULL,
)
GO


 -- EXAMPLE SENTENTES OF WORDS 
DROP TABLE IF EXISTS EXAMPLE
CREATE TABLE EXAMPLE 
(
	ID INT PRIMARY KEY  IDENTITY,
	CONTENT NVARCHAR(200) NOT NULL, 
	MEANING NVARCHAR(200) NOT NULL, --meaning of examples
	MEANING_ID INT NOT NULL -- meaning of words
)
GO


  
DROP TABLE IF EXISTS MEANING -- MEANINGS OF WORD (A WORDS CAN HAVE MULTIPLE MEANING IN VIETNAMESE)
CREATE TABLE MEANING 
(
	ID INT PRIMARY KEY IDENTITY,
	CONTENT NVARCHAR(50) NOT NULL,
	VOCABULARY_ID INT NOT NULL
)
GO



-- FOREIGN KEY 
-- relate to USER
ALTER TABLE BOOKMARK
ADD CONSTRAINT fk_BOOKMARK_USER
FOREIGN KEY ([USER_ID])
REFERENCES [USER] (ID)
GO

ALTER TABLE HISTORY
ADD CONSTRAINT fk_HISTORY_USER
FOREIGN KEY ([USER_ID])
REFERENCES [USER] (ID)
GO


-- relate to vocabulary
ALTER TABLE BOOKMARK
ADD CONSTRAINT fk_BOOKMARK_VOCABULARY
FOREIGN KEY (VOCABULARY_ID)
REFERENCES VOCABULARY (ID)
GO

ALTER TABLE HISTORY
ADD CONSTRAINT fk_HISTORY_VOCABULARY
FOREIGN KEY (VOCABULARY_ID)
REFERENCES VOCABULARY (ID)
GO

ALTER TABLE VOCABULARY
ADD CONSTRAINT fk_VOCABULARY_WORD_TYPE
FOREIGN KEY (WORD_TYPE_ID)
REFERENCES WORD_TYPE (ID)
GO

ALTER TABLE RELATIVES 
ADD CONSTRAINT fk_RELATIVES_VOCABULARY
FOREIGN KEY (VOCABULARY_ID)
REFERENCES VOCABULARY (ID)
GO

ALTER TABLE MEANING 
ADD CONSTRAINT fk_MEANING_VOCABULARY
FOREIGN KEY (VOCABULARY_ID)
REFERENCES VOCABULARY (ID)
GO

ALTER TABLE EXAMPLE 
ADD CONSTRAINT fk_EXAMPLE_MEANING
FOREIGN KEY (MEANING_ID)
REFERENCES MEANING (ID)
GO




---- relatives to CATEGORY
ALTER TABLE VOCABULARY
ADD CONSTRAINT fk_VOCABULARY_CATEGORY
FOREIGN KEY (CATEGORY_ID)
REFERENCES CATEGORY(ID)
GO