Instructions for using my GAPP.

** NOTE 0: EXECUTE gapp-create.sql TO HAVE A FULLY READY DB, IT CONTAINS (SCHEMA + INSERT COMMANDS).
** NOTE 1: DO NOT (EDIT OR DELETE) ANY OF THE ALREADY IMPLEMENTED DATA.
** NOTE 2: TO CHECK ALL FUNCTIONS PLEASE DO ALL OPERATIONS ON NEW ENTERED DATA (RECOMMENDED NOT TO LEAVE ANY BLANK TEXTFIELDS ON CREATION).
** NOTE 3: DATE FORMAT IS "YYYY-MM-DD" FOUR DIGITS FOR YEAR AND TWO FOR MONTH AND DAY EXAMPLE (FEBUARY 3RD 2016 == "2016-02-03")
** NOTE 4: YOU WILL ONLY SEE FUNCTIONALITY OF UPLOAD, DOWNLOAD AND REMOVE OF A FILE, IN THE SECOND APPLICATION DETAILS OF THE STUDENT ACCOUNT MENTIONED BELOW, BECAUSE I WAS SHORT ON TIME TO IMPLEMENT THE OPTION FOR ENTERING STUDENT EDUCATION INFO WHILE CREATING AN APPLICATION.
** NOTE 5: UPLOADED FILES ARE CREATED IN /WEB-INF/files FOLDER AND ONLY FILE'S INFO ARE STORED IN THE DATABASE.
** NOTE 6: IN CASE YOU WANT TO CHECK INSERT SQL COMMANDS IT'S IN A SEPERATE FILE IN SCRIPTS FOLDER CALLED Insert-Commands.sql.


Login Page URL: http://localhost:8080/gapp/home.html
Registration Page URL: http://localhost:8080/gapp/user/register.html
Users to use for Login:
For Admin please use:
username: admin@localhost.localdomain
password: abcd
For Student pleas use:
username: student2@localhost.localdomain
password: abcd
For Staff please use:
username: staff1@localhost.localdomain
password: abcd

Guide lines:
-From Login you can access any of the above accounts or Create a new user "default Student type" account throught regitration page.

-Login using staff account to find Options to:
	1) Blank page with logout button to go to home page.

-Login using admin account to find Options to:
	1) List departments where you can (check all departments, No. of programs offered and operations). 
	*you can Add new department or Edit + Remove + Add additional requirements for each existing department.
	*In Department detail you can check all programs and additional	requirements related to that department and operations of (Edit, Remove) on it can apply.
	2) Add department where you can add a department.
	3) List users where you can see all users with operations of (Details, edit, delete)
	4) Add user type of user should be (student or administrator or staff)
	5) logout to go back to home page

-Login using student account to find Options to:
	1) Show applications where you can see all applications related to the student.
	*See details of each application and edit it "ONLY IF NOT SUBMITTED"
	*In the application detail Three lists are shown (Application details, 	student personal and education info)
	*In the application's detail table you can edit the application "ONLY IF NOT SUBMITTED"
	*In the student education table you can (Upload, download, and remove files related to the student's education)
	2) Create application where you can submit or save application by selecting department another dropdown list (AJAX) to show programs offered by that department's.

**FINAL NOTE: FOR ANY QUESTION OR DOUBTS PLEASE CONTACT ME THROUGH MY EMAIL:
NAME: WAEL ALHAMWI
EMAIL: eng.waelalhamwi@gmail.com

Thank you