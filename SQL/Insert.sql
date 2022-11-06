﻿-- Insert Statement
USE DICTIONARY
GO


-- insert user
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'nguyenphu1147123@gmail.com', N'123123', 1, N'Nguyễn Mạnh Phú', '2015-12-17', N'0783562372', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'nguyenphu114a@gmail.com', N'123123', 1, N'Nguyễn Mạnh Phú', '2015-12-17', N'0783562372', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'nguyenphuhung@gmail.com', N'1355445', 1, N'Nguyễn Phú Hùng', '2015-02-17', N'0783542372', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'nguyenvana@gmail.com', N'12546123', 1, N'Nguyễn Văn A', '2001-12-17', N'0983562372', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'nguyenvanb@gmail.com', N'12363', 1, N'Nguyễn Văn B', '2002-12-17', N'0983559052', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'nguyenvanc@gmail.com', N'123323', 1, N'Nguyễn Văn C', '2015-12-15', N'0785672372', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'phamphuhung@gmail.com', N'123323', 2, N'Phạm Phú Hùng', '2015-12-15', N'0698472372', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'phamphu1578@gmail.com', N'124523', 2, N'Nguyễn Phú', '2005-12-15', N'0651372372', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'nguyenhuucanh@gmail.com', N'126423', 2, N'Nguyễn Hữu Cảnh', '2005-12-15', N'0289672372', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'user3@gmail.com', N'126423', 2, N'Nguyễn Hữu Cảnh', '2005-12-15', N'0289672372', GETDATE(), GETDATE())
INSERT INTO [USER] (EMAIL, [PASSWORD], [LEVEL], FULLNAME, BIRTHDAY, PHONE_NUMBER, CREATED_AT, UPDATED_AT)
VALUES (N'user5@gmail.com', N'126423', 2, null, null, null, GETDATE(), GETDATE())
GO


-- WORD TYPE
INSERT INTO WORD_TYPE VALUES (N'NOUN') -- danh từ
INSERT INTO WORD_TYPE VALUES (N'PRONOUN') -- đại từ
INSERT INTO WORD_TYPE VALUES (N'ADJECTIVE') -- tính từ
INSERT INTO WORD_TYPE VALUES (N'VERB') -- động từ
INSERT INTO WORD_TYPE VALUES (N'ADVERB') -- trạng từ
INSERT INTO WORD_TYPE VALUES (N'DETERMINER') -- từ hạn định
INSERT INTO WORD_TYPE VALUES (N'PREPOSITION') -- giới từ
INSERT INTO WORD_TYPE VALUES (N'CONJUNTION') -- liên từ
INSERT INTO WORD_TYPE VALUES (N'INTERJECTION') -- thán từ
GO



-- cate
INSERT INTO CATEGORY VALUES (N'sport', N'sport.jpg')
INSERT INTO CATEGORY VALUES (N'fruit', N'fruit.jpg')
INSERT INTO CATEGORY VALUES (N'food', N'food.jpg')
INSERT INTO CATEGORY VALUES (N'furniture', N'furniture.jpg')
INSERT INTO CATEGORY VALUES (N'subject', N'subject.jpg')
INSERT INTO CATEGORY VALUES (N'drink', N'drink.jpg')
INSERT INTO CATEGORY VALUES (N'cloths', N'cloths.jpg')
INSERT INTO CATEGORY VALUES (N'family', N'family.jpg')
INSERT INTO CATEGORY VALUES (N'body', N'body.jpg')
INSERT INTO CATEGORY VALUES (N'school', N'school.jpg')
INSERT INTO CATEGORY VALUES (N'job', N'job.jpg')
GO 

INSERT INTO VOCABULARY VALUES (N'football', N'football.png', N'football.mp3', 1, 1) -- sport
INSERT INTO VOCABULARY VALUES (N'ski', N'ski.png', N'ski.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'dive', N'dive.png', N'dive.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'skate', N'skate.png', N'skate.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'ride bike', N'ride_bike.png', N'ride_bike.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'skip', N'skip.png', N'skip.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'sail', N'sail.png', N'sail.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'surf', N'surf.png', N'surf.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'climb', N'climb.png', N'climb.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'swim', N'swim.png', N'swim.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'tennis', N'tennis.png', N'tennis.mp3', 1, 1) 
INSERT INTO VOCABULARY VALUES (N'aerobics', N'aerobics.png', N'aerobics.mp3', 1, 1)
INSERT INTO VOCABULARY VALUES (N'archery', N'archery.png', N'archery.mp3', 1, 1)
INSERT INTO VOCABULARY VALUES (N'badminton', N'badminton.png', N'badminton.mp3', 1, 1)

INSERT INTO VOCABULARY VALUES (N'apple', N'apple.png', N'apple.mp3', 2, 1) -- fruit
INSERT INTO VOCABULARY VALUES (N'banana', N'banana.png', N'banana.mp3', 2, 1)
INSERT INTO VOCABULARY VALUES (N'pear', N'pear.png', N'pear.mp3', 2, 1)
INSERT INTO VOCABULARY VALUES (N'orange', N'orange.png', N'orange.mp3', 2, 1)
INSERT INTO VOCABULARY VALUES (N'grapes', N'grapes.png', N'grapes.mp3', 2, 1)
INSERT INTO VOCABULARY VALUES (N'avocado', N'avocado.png', N'avocado.mp3', 2, 1)
INSERT INTO VOCABULARY VALUES (N'peach', N'peach.png', N'peach.mp3', 2, 1)
INSERT INTO VOCABULARY VALUES (N'cherries', N'cherries.png', N'cherries.mp3', 2, 1)
INSERT INTO VOCABULARY VALUES (N'watermelon', N'watermelon.png', N'watermelon.mp3', 2, 1)
INSERT INTO VOCABULARY VALUES (N'melon', N'melon.png', N'melon.mp3', 2, 1)



INSERT INTO VOCABULARY VALUES (N'pork', N'pork.png', N'pork.mp3', 3, 1) -- food
INSERT INTO VOCABULARY VALUES (N'meat', N'meat.png', N'meat.mp3', 3, 1)
INSERT INTO VOCABULARY VALUES (N'steamed sticky rice', N'steamed_sticky_rice.png', N'steamed_sticky_rice.mp3', 3, 1)
INSERT INTO VOCABULARY VALUES (N'rice noodles', N'rice_noodles.png', N'rice_noodles.mp3', 3, 1)
INSERT INTO VOCABULARY VALUES (N'egg', N'egg.png', N'egg.mp3', 3, 1)
INSERT INTO VOCABULARY VALUES (N'bacon', N'bacon.png', N'bacon.mp3', 3, 1)
INSERT INTO VOCABULARY VALUES (N'hamburger', N'hamburger.png', N'hamburger.mp3', 3, 1)
INSERT INTO VOCABULARY VALUES (N'sausage', N'sausage.png', N'sausage.mp3', 3, 1)
INSERT INTO VOCABULARY VALUES (N'cheese', N'cheese.png', N'cheese.mp3', 3, 1)
INSERT INTO VOCABULARY VALUES (N'sandwich', N'sandwich.png', N'sandwich.mp3', 3, 1)

INSERT INTO VOCABULARY VALUES (N'desk', N'desk.png', N'desk.mp3', 4, 1) -- furniture
INSERT INTO VOCABULARY VALUES (N'chair', N'chair.png', N'chair.mp3', 4, 1)
INSERT INTO VOCABULARY VALUES (N'bed', N'bed.png', N'bed.mp3', 4, 1)
INSERT INTO VOCABULARY VALUES (N'chest', N'chest.png', N'chest.mp3', 4, 1)

INSERT INTO VOCABULARY VALUES (N'biology', N'biology.png', N'biology.mp3', 5, 1) -- subject
INSERT INTO VOCABULARY VALUES (N'maths', N'maths.png', N'maths.mp3', 5, 1)
INSERT INTO VOCABULARY VALUES (N'medicine', N'medicine.png', N'medicine.mp3', 5, 1)
INSERT INTO VOCABULARY VALUES (N'chemistry', N'chemistry.png', N'chemistry.mp3', 5, 1)
GO 


INSERT INTO RELATIVES VALUES (N'soccer', 1)
INSERT INTO RELATIVES VALUES (N'the pigskin sport', 1)

INSERT INTO RELATIVES VALUES (N'dance workout', 2)
INSERT INTO RELATIVES VALUES (N'aquarobics', 2)

INSERT INTO RELATIVES VALUES (N'bowhungting', 3)
INSERT INTO RELATIVES VALUES (N'gunner', 3)

INSERT INTO RELATIVES VALUES (N'shuttlecock', 4)
INSERT INTO RELATIVES VALUES (N'court game', 4)

INSERT INTO RELATIVES VALUES (N'orb', 5)
INSERT INTO RELATIVES VALUES (N'balloon', 5)

INSERT INTO RELATIVES VALUES (N'babble', 6)
INSERT INTO RELATIVES VALUES (N'battly', 6)

INSERT INTO RELATIVES VALUES (N'beef', 10)
INSERT INTO RELATIVES VALUES (N'flesh', 10)

INSERT INTO RELATIVES VALUES (N'apricot', 8)
INSERT INTO RELATIVES VALUES (N'cantaloutpe', 8)

INSERT INTO RELATIVES VALUES (N'gammon', 9)
INSERT INTO RELATIVES VALUES (N'rasher', 9)

INSERT INTO RELATIVES VALUES (N'seat', 14)
INSERT INTO RELATIVES VALUES (N'chairman', 14)
GO


-- MEANING OF WORDS
INSERT INTO MEANING VALUES (N'môn bóng đá', 1)
INSERT INTO MEANING VALUES (N'trái bóng đá', 1)
INSERT INTO MEANING VALUES (N'thể dục thẩm mỹ', 2)
INSERT INTO MEANING VALUES (N'môn bắn cung', 3)
INSERT INTO MEANING VALUES (N'cầu lông', 4)

INSERT INTO MEANING VALUES (N'táo', 5)
INSERT INTO MEANING VALUES (N'chuối', 6)
INSERT INTO MEANING VALUES (N'lê', 7)
INSERT INTO MEANING VALUES (N'cam', 8)

INSERT INTO MEANING VALUES (N'thịt heo', 9)
INSERT INTO MEANING VALUES (N'thịt bò', 10)
INSERT INTO MEANING VALUES (N'xôi', 11)
INSERT INTO MEANING VALUES (N'bún', 12)

INSERT INTO MEANING VALUES (N'cái bàn', 13)
INSERT INTO MEANING VALUES (N'ghế thông thường', 14)
INSERT INTO MEANING VALUES (N'giường thông thường', 15)
INSERT INTO MEANING VALUES (N'cái tủ, cái két', 16)

INSERT INTO MEANING VALUES (N'sinh học', 17)
INSERT INTO MEANING VALUES (N'toán học', 18)
INSERT INTO MEANING VALUES (N'y học', 19)
INSERT INTO MEANING VALUES (N'hóa học', 20)
GO



-- EXAMPLES
INSERT INTO EXAMPLE VALUES (N'', N'', 1)
INSERT INTO EXAMPLE VALUES (N'', N'', 2)
INSERT INTO EXAMPLE VALUES (N'', N'', 3)
INSERT INTO EXAMPLE VALUES (N'', N'', 4)

INSERT INTO EXAMPLE VALUES (N'', N'', 5)
INSERT INTO EXAMPLE VALUES (N'', N'', 6)
INSERT INTO EXAMPLE VALUES (N'', N'', 7)
INSERT INTO EXAMPLE VALUES (N'', N'', 8)

INSERT INTO EXAMPLE VALUES (N'', N'', 9)
INSERT INTO EXAMPLE VALUES (N'', N'', 10)
INSERT INTO EXAMPLE VALUES (N'', N'', 11)
INSERT INTO EXAMPLE VALUES (N'', N'', 12)

INSERT INTO EXAMPLE VALUES (N'', N'', 13)
INSERT INTO EXAMPLE VALUES (N'', N'', 14)
INSERT INTO EXAMPLE VALUES (N'', N'', 15)
INSERT INTO EXAMPLE VALUES (N'', N'', 16)

INSERT INTO EXAMPLE VALUES (N'', N'', 17)
INSERT INTO EXAMPLE VALUES (N'', N'', 18)
INSERT INTO EXAMPLE VALUES (N'', N'', 19)
INSERT INTO EXAMPLE VALUES (N'', N'', 20)
GO



INSERT INTO BOOKMARK VALUES (3, 1) 
INSERT INTO BOOKMARK VALUES (2, 1) 
INSERT INTO BOOKMARK VALUES (3, 1) 
INSERT INTO BOOKMARK VALUES (4, 1) 


INSERT INTO BOOKMARK VALUES (3, 1) 
INSERT INTO BOOKMARK VALUES (5, 2)
INSERT INTO BOOKMARK VALUES (6, 2)
INSERT INTO BOOKMARK VALUES (7, 2)
INSERT INTO BOOKMARK VALUES (8, 2)
INSERT INTO BOOKMARK VALUES (9, 3)

INSERT INTO BOOKMARK VALUES (10, 3)
INSERT INTO BOOKMARK VALUES (11, 3)
INSERT INTO BOOKMARK VALUES (12, 3)

INSERT INTO BOOKMARK VALUES (13, 4)
INSERT INTO BOOKMARK VALUES (14, 4)
INSERT INTO BOOKMARK VALUES (15, 4)
INSERT INTO BOOKMARK VALUES (16, 4)

INSERT INTO BOOKMARK VALUES (17, 5)
INSERT INTO BOOKMARK VALUES (18, 5)
INSERT INTO BOOKMARK VALUES (19, 5)
INSERT INTO BOOKMARK VALUES (20, 5)
GO

INSERT INTO HISTORY VALUES (1, 1) 
INSERT INTO HISTORY VALUES (2, 1) 
INSERT INTO HISTORY VALUES (3, 1) 
INSERT INTO HISTORY VALUES (4, 1) 

INSERT INTO HISTORY VALUES (5, 2)
INSERT INTO HISTORY VALUES (6, 2)
INSERT INTO HISTORY VALUES (7, 2)
INSERT INTO HISTORY VALUES (8, 2)

INSERT INTO HISTORY VALUES (9, 3)
INSERT INTO HISTORY VALUES (10, 3)
INSERT INTO HISTORY VALUES (11, 3)
INSERT INTO HISTORY VALUES (12, 3)

INSERT INTO HISTORY VALUES (13, 3)
INSERT INTO HISTORY VALUES (14, 3)
INSERT INTO HISTORY VALUES (15, 3)
INSERT INTO HISTORY VALUES (16, 3)

INSERT INTO HISTORY VALUES (17, 3)
INSERT INTO HISTORY VALUES (18, 3)
INSERT INTO HISTORY VALUES (19, 3)
INSERT INTO HISTORY VALUES (20, 3)
GO