INSERT INTO users(
		id, enabled, firstname, lastname, password, role, username)
VALUES (1, true, 'wael', 'alhamwi', 'abcd', 'administrator', 'admin@localhost.localdomain');

INSERT INTO users(
		id, enabled, firstname, lastname, password, role, username)
VALUES (2, true, 'jack', 'moses', 'abcd', 'staff', 'staff1@localhost.localdomain');

INSERT INTO users(
		id, enabled, firstname, lastname, password, role, username)
VALUES (3, true, 'laura', 'jackson', 'abcd', 'staff', 'staff2@localhost.localdomain');

INSERT INTO users(
		id, enabled, firstname, lastname, password, role, username)
VALUES (4, true, 'micheal', 'blah', 'abcd', 'student', 'student1@localhost.localdomain');

INSERT INTO users(
		id, enabled, firstname, lastname, password, role, username)
VALUES (5, true, 'tony', 'watson', 'abcd', 'student', 'student2@localhost.localdomain');

INSERT INTO students(
		id, citizenship, dateofbirth, firstname, gender, lastname, phonenumber, 
		stduser_id)
VALUES (1, 'American', '2-10-2016', 'micheal', 'Female', 'blah', '6266262333', 4);

INSERT INTO students(
		id, citizenship, dateofbirth, firstname, gender, lastname, phonenumber, 
		stduser_id)
VALUES (2, 'Syrian', '2-12-2016', 'tony', 'Male', 'watson', '6266262222', 5);

INSERT INTO departments(
            id, name)
    VALUES (1, 'Accounting Department');

INSERT INTO departments(
            id, name)
    VALUES (2, 'Computer Science Department');

INSERT INTO requirements(
            id, additionalreqowner_id, isrequired, nameoffield, typeoffield)
    VALUES (1, 1, 'Required', 'GMAT', 'number');

INSERT INTO programs(
            id, description, programowner_id, title)
    VALUES (1, '45 units to earn Masters in Accounting', 1, 'MS in Accounting');

INSERT INTO programs(
            id, description, programowner_id, title)
    VALUES (2, '12 units + 45 units to earn Masters in Computer Science', 2, 'MS in Computer Science');
    
INSERT INTO programs(
            id, description, programowner_id, title)
    VALUES (3, '120 units to earn Bachelor in Software Systems', 2, 'Bsc in Software Systems');
    
    INSERT INTO application(
            id, progappowner_id, deptappowner_id, status, submitdate, term, stdappowner_id)
    VALUES (1, 1, 1, 'Submitted', '01-01-2016' , 'Fall 2016', 1);

INSERT INTO application(
            id, progappowner_id, deptappowner_id, status, submitdate, term, stdappowner_id)
    VALUES (2, 1, 1, 'Submitted', '12-12-2015' , 'Summer 2015', 2);

    
INSERT INTO application(
            id, progappowner_id, deptappowner_id, status, submitdate, term, stdappowner_id)
    VALUES (3, 2, 2, 'Not Submitted', '01-01-2016' , 'Spring 2016', 2);

INSERT INTO application(
            id, progappowner_id, deptappowner_id, status, submitdate, term, stdappowner_id)
    VALUES (4, 1, 1, 'Submitted', '10-12-2015' , 'Winter 2015', 1);
    
INSERT INTO studentsedu(
            id, gpa, gre, toefl, degree, major, periodofattendence, university, 
            owner_id, infoowner_id)
    VALUES (1, 3.4, 2.0, 89.7, 'Deploma', 'Software Engineering', '1 years', 'California State university', 
            1, 2);

INSERT INTO studentsedu(
            id, gpa, gre, toefl, degree, major, periodofattendence, university, 
            owner_id, infoowner_id)
    VALUES (2, 3, 6, 99.9, 'Bachelor', 'Computer Science', '4 years', 'California Institute of Technology', 
            2, 2);

INSERT INTO studentsedu(
            id, gpa, gre, toefl, degree, major, periodofattendence, university, 
            owner_id, infoowner_id)
    VALUES (3, 2.7, 2.0, 500, 'Certificate', 'Management', '1 years', 'California Institute of Business', 
            3, 1);

INSERT INTO studentsedu(
            id, gpa, gre, toefl, degree, major, periodofattendence, university, 
            owner_id, infoowner_id)
    VALUES (4, 3, 2.0, 500, 'Certificate', 'CCNA', '6 months', 'CISCO', 
            4, 3);