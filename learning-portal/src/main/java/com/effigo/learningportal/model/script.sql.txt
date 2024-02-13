CREATE table IF NOT EXISTS roles (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS course_category (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL PRIMARY KEY,
    role_id INT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number BIGINT NOT NULL,
    status BOOLEAN NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE IF NOT EXISTS courses (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT,
    publisher_id INT,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
  status BOOLEAN NOT NULL,
    FOREIGN KEY (category_id) REFERENCES course_category (id),
    FOREIGN KEY (publisher_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS favourites (
    user_id INT,
    course_id INT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (course_id) REFERENCES courses (id),
    PRIMARY KEY (user_id, course_id)
);

CREATE TABLE IF NOT exists enrollment(
	user_id INT  ,
	course_id INT ,
	FOREIGN KEY(user_id) REFERENCES users(id),
	FOREIGN KEY(course_id) REFERENCES courses(id),
	PRIMARY KEY (user_id, course_id)
);