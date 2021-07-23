# Sparta Global Course Organization App

## The Problem:

Currently within Sparta global the training courses are organized using a spread sheet which is cumbersome to use. The spreadsheet contains a lot of information including the course Name, discipline, course type, trainer, start date, duration, end date and bond. From this data a visual representation of the courses is produced which is colour coded to the trainer that is leading the courses. The application that is being produced to replace it must match the functionality of the preexisting spreadsheet while being more user friendly.

## The Requirements:

Below are the client’s requirements for the project:
- Must produce a visual representation the courses and their position on the timeline (like a Gantt chart)

- The visual representation must be colour coded to the trainers leading the courses.

- The application should allow for the addition of new trainees, trainers, disciplines, course types, Location, and courses.

- It should also allow the user to edit/delete pre-existing entries of any information listed in the point above

- The User should have to login to protect the functionality of the application from people who do not have authorisation to use it.

- The application should be intuitive and easy to use.

## Tools Used:

Below are the tools that were used throughout this project:
- Jira: Used to create user stories and manage sprints through KANBAN boards.
- Planit Poker: Used to estimate the difficulty of user stories
- Lucid Chart: producing the ERD for the database
- Uizard: producing a mock-up of the front end and creation of wire frames.
- Teams: Used for communication throughout the project
- GitHub: Used for version control.
- IntelliJ: The selected IDE for use by all team members
- Maven: to manage the dependencies throughout the project
- Spring Boot: Used to simplify the creation of a web application
- MySQL: creation and storage of data to allow for persistence of data between application sessions.
- Junit: Used to perform unit testing on the application.
- Bootstrap: A selection of prebuilt components that can be used to produce a professional looking website
- Thymeleaf: Templating engine that allows to produce variable HTML without JSFs or JSPs
- Mockito: used to test the controllers on the application.

## User Guide:

Upon accessing the website, the user will be taken to the login page. If the credentials that have been inputted are incorrect then the user will stay on the login page with the message invalid credentials.
Once successfully logged in the user will be redirected to the scheduler page, this is the page that contains the visual representation of the courses being run on a timeline. The user will be presented with a table that contains the visualisation as well as the basic information about the course (course name, trainer, and location). If the user wants to know more information about a specific course, then clicking on the row in a table will provide more details about the course in a collapse that opens below the row. Clicking on the row again will close the collapse. At the bottom of the table there is a scroll bar which allows the user to scroll side to side to allow for the viewing of the whole data visualisation. The course name column in the table stays frozen so the user can easily see what each row of the visualisation represents.
Within the collapse there is also a see trainee link. Upon clicking the link, the user is directed to a page that lists all the trainees on a course and their most recent quality gate result. If the user wants to see the quality gate history of a trainee, then clicking on the trainee in the table will show their quality gate history in a collapse that opens below the row. From here the user may edit/delete any trainees that are on that course using the edit and delete buttons in the row that corresponds to the trainee that they wish to edit/delete.
There also pages that show all the courses, course types, disciplines, trainers, trainees, and locations currently in the database. These pages are all easily accessible via the navigation bar at the top of every page and allow the user to add/edit/remove the respective data on the page.
There is also an account information page that is accessible via the navigation bar that allows the user to change the password of their account.

## Testing:

Junit and Mockito was used to test the web application. Test coverage has reached 58%.
For all the entities classes, JUnit was used to test the functionality of the getters and setters. The use of Assertions.assertEquals() methods tests to see if they are returning the expected value. All the get() methods in the entities classes have passed the test and return the expected value.
