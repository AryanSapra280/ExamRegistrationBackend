# **EXAM Registration Backend**

This is a robust, scalable solution written in Java using Spring Boot. We have followed the Spring MVC architecture and implemented GlobalException. The database used is MySQL, and we have used Hibernate to communicate with the database.

We have implemented CRUD APIs and have attached a Postman collection. You can clone and quickly run it by setting the DB connection at port 3306.

**GET /surprise/{number}:**

Fetches a surprise fact based on the provided number from an external API.

Example: GET /surprise/42 might return a fact about the number 42.

**GET /exam/exams:**

Retrieves a list of all exams.

**POST /exam/createExam/{subjectName}:**

Creates a new exam for a specified subject.

Example: POST /exam/createExam/Math might create a new exam for the subject "Math".

**DELETE /exam/remove/{id}:**

Deletes an exam by its ID.

**GET /student/:**

Retrieves a list of all students.

**POST /student/createStudent:**

Creates a new student.

**PUT /student/enrollSubject/{subjectName}/{rollNo}:**

Enrolls a student in a specific subject based on roll number.

**PUT /student/enrollExam/{examId}/{rollNo}:**

Enrolls a student in a specific exam based on exam ID and roll number.

**GET /subject/:**

Retrieves a list of all subjects.

**POST /subject/:**

Adds a new subject.

**DELETE /subject/remove/{name}:**

Deletes a subject by name.
