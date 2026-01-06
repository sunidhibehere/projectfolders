CREATE TABLE IF NOT EXISTS students(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	enrollment_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS courses(
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	description TEXT,
	credits int NOT NULL
);

CREATE TABLE IF NOT EXISTS student_courses(
	student_id INT NOT NULL,
	course_id INT NOT NULL,
	PRIMARY KEY(student_id,course_id),
	CONSTRAINT student_courses_key
	FOREIGN KEY (student_id) REFERENCES students(id)
	ON DELETE CASCADE,
	CONSTRAINT student_courses_key2
	FOREIGN KEY (course_id) REFERENCES courses(id)
	ON DELETE CASCADE
);
