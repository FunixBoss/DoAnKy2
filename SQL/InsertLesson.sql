/*
INSERT INTO LESSON VALUES (N'', N'')
	INSERT INTO THEORY VALUES (1 ,(SELECT IDENT_CURRENT('LESSON')))
	INSERT INTO THEORY VALUES (1 ,(SELECT IDENT_CURRENT('LESSON')))	
	INSERT INTO THEORY VALUES (1 ,(SELECT IDENT_CURRENT('LESSON')))	
	INSERT INTO THEORY VALUES (1 ,(SELECT IDENT_CURRENT('LESSON')))	
	INSERT INTO THEORY VALUES (1 ,(SELECT IDENT_CURRENT('LESSON')))	
	INSERT INTO QUESTION VALUES(N'', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
	INSERT INTO QUESTION VALUES(N'', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
	INSERT INTO QUESTION VALUES(N'', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
	INSERT INTO QUESTION VALUES(N'', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
	INSERT INTO QUESTION VALUES(N'', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'', 0, (SELECT IDENT_CURRENT('QUESTION')))
*/ 

INSERT INTO LESSON VALUES (N'Lesson06', N'lesson01.png')
	INSERT INTO THEORY VALUES (1 ,(SELECT IDENT_CURRENT('LESSON')))
	INSERT INTO THEORY VALUES (2 ,(SELECT IDENT_CURRENT('LESSON')))	
	INSERT INTO THEORY VALUES (3 ,(SELECT IDENT_CURRENT('LESSON')))	
	INSERT INTO THEORY VALUES (4 ,(SELECT IDENT_CURRENT('LESSON')))	
	INSERT INTO THEORY VALUES (5 ,(SELECT IDENT_CURRENT('LESSON')))	
	INSERT INTO QUESTION VALUES(N'Question01 - Lesson06', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'A', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'B', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'C', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'D', 0, (SELECT IDENT_CURRENT('QUESTION')))
	INSERT INTO QUESTION VALUES(N'Question02 - Lesson06', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'A', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'B', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'C', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'D', 0, (SELECT IDENT_CURRENT('QUESTION')))
	INSERT INTO QUESTION VALUES(N'Question03 - Lesson06', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'A', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'B', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'C', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'D', 0, (SELECT IDENT_CURRENT('QUESTION')))
	INSERT INTO QUESTION VALUES(N'Question04 - Lesson06', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'A', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'B', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'C', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'D', 0, (SELECT IDENT_CURRENT('QUESTION')))
	INSERT INTO QUESTION VALUES(N'Question05 - Lesson06', (SELECT IDENT_CURRENT('LESSON')))
		INSERT INTO ANSWER VALUES(N'A', 1, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'B', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'C', 0, (SELECT IDENT_CURRENT('QUESTION')))
		INSERT INTO ANSWER VALUES(N'D', 0, (SELECT IDENT_CURRENT('QUESTION')))