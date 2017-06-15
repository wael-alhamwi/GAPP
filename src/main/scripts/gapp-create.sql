
    create table application (
        id int4 not null,
        status varchar(255),
        submitDate timestamp,
        term varchar(255),
        deptAppOwner_id int4,
        progAppOwner_id int4,
        stdAppOwner_id int4,
        primary key (id)
    );

    create table applicationstatus (
        id int4 not null,
        comment varchar(255),
        status varchar(255),
        timeOfChange timestamp,
        appOwner_id int4,
        primary key (id)
    );

    create table departments (
        id int4 not null,
        name varchar(255),
        primary key (id)
    );

    create table files (
        id int4 not null,
        date timestamp,
        fileName varchar(255),
        size int8,
        type varchar(255),
        fileAppOwner_id int4,
        fileUserOwner_id int4,
        primary key (id)
    );

    create table programs (
        id int4 not null,
        description varchar(255),
        title varchar(255),
        programOwner_id int4,
        primary key (id)
    );

    create table requirements (
        id int4 not null,
        isRequired varchar(255),
        nameOfField varchar(255),
        typeOfField varchar(255),
        additionalReqOwner_id int4,
        primary key (id)
    );

    create table students (
        id int4 not null,
        citizenship varchar(255),
        dateOfBirth timestamp,
        firstName varchar(255),
        gender varchar(255),
        lastName varchar(255),
        phoneNumber varchar(255),
        stdUser_id int4,
        primary key (id)
    );

    create table studentsedu (
        id int4 not null,
        GPA float8 not null,
        GRE float8 not null,
        TOEFL float8 not null,
        degree varchar(255),
        major varchar(255),
        periodOfAttendence varchar(255),
        university varchar(255),
        owner_id int4,
        infoOwner_id int4,
        primary key (id)
    );

    create table users (
        id int4 not null,
        enabled boolean not null,
        firstName varchar(255),
        lastName varchar(255),
        password varchar(255),
        role varchar(255),
        username varchar(255),
        primary key (id)
    );

    alter table application 
        add constraint FK_g5s17lcstdjeagtvhavy3kngu 
        foreign key (deptAppOwner_id) 
        references departments;

    alter table application 
        add constraint FK_d4wgtxy25s6tqdnah3h4rc5c1 
        foreign key (progAppOwner_id) 
        references programs;

    alter table application 
        add constraint FK_1oshvkdyivl8odu9wqvgbljb3 
        foreign key (stdAppOwner_id) 
        references students;

    alter table applicationstatus 
        add constraint FK_7jwujewncukhec7in0brbysn4 
        foreign key (appOwner_id) 
        references application;

    alter table files 
        add constraint FK_ncghh9puu45tevoc5a0n63sjb 
        foreign key (fileAppOwner_id) 
        references application;

    alter table files 
        add constraint FK_na5t7lbl1ygw4v5m31ncrx8k5 
        foreign key (fileUserOwner_id) 
        references users;

    alter table programs 
        add constraint FK_7uqveppgk7t923t3bl20dgyql 
        foreign key (programOwner_id) 
        references departments;

    alter table requirements 
        add constraint FK_ow8k0yxr4mtk0mm40135n7t9k 
        foreign key (additionalReqOwner_id) 
        references departments;

    alter table students 
        add constraint FK_fsbgwl8grwq8ebm12ig0ow2j4 
        foreign key (stdUser_id) 
        references users;

    alter table studentsedu 
        add constraint FK_61x7ieabbpe1r3ywvl6gwlm2t 
        foreign key (owner_id) 
        references studentsedu;

    alter table studentsedu 
        add constraint FK_eg4b8kp4g2gg67ya9i2xe3pxb 
        foreign key (infoOwner_id) 
        references application;

    create sequence hibernate_sequence;
    
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
