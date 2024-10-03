-- Insert 1
INSERT INTO user_details (ID, BIRTH_DATE, NAME)
VALUES (10001, '1990-01-01', 'John Doe');

-- Insert 2
INSERT INTO user_details (ID, BIRTH_DATE, NAME)
VALUES (10002, '1985-06-15', 'Jane Smith');

-- Insert 3
INSERT INTO user_details (ID, BIRTH_DATE, NAME)
VALUES (10003, NULL, 'Michael Johnson');  -- NULL for birth_date

-- Insert 4
INSERT INTO user_details (ID, BIRTH_DATE, NAME)
VALUES (10004, '2000-12-31', 'Emily Davis');

-- Insert 5
INSERT INTO user_details (ID, BIRTH_DATE, NAME)
VALUES (10005, '1995-03-20', 'Chris Lee');


-- Insert 1
INSERT INTO post (ID, USER_ID, DESCRIPTION)
VALUES (20001, 10001, 'John Doe''s first post.');

-- Insert 2
INSERT INTO post (ID, USER_ID, DESCRIPTION)
VALUES (20002, 10001, 'John Doe''s second post.');

-- Insert 3
INSERT INTO post (ID, USER_ID, DESCRIPTION)
VALUES (20003, 10002, 'Jane Smith''s first post.');

-- Insert 4
INSERT INTO post (ID, USER_ID, DESCRIPTION)
VALUES (20004, 10003, 'Michael Johnson''s first post.');

-- Insert 5
INSERT INTO post (ID, USER_ID, DESCRIPTION)
VALUES (20005, 10003, 'Michael Johnson''s second post.');

