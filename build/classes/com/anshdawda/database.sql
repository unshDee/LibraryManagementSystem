USE library;
SHOW TABLES;
CREATE TABLE book (
  book_id INT AUTO_INCREMENT NOT NULL,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  publisher VARCHAR(255) NOT NULL,
  isbn VARCHAR(20) NOT NULL,
  price FLOAT(5, 2) NOT NULL,
  cover BLOB NOT NULL,
  PRIMARY KEY (book_id)
);
CREATE TABLE user (
  user_id INT AUTO_INCREMENT NOT NULL,
  privilege INT NOT NULL,
  username VARCHAR(25) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  gender VARCHAR(1) NOT NULL,
  marital_status VARCHAR(1) NOT NULL,
  address TEXT NOT NULL,
  password BINARY(60) NOT NULL,
  avatar BLOB NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE (username)
);
CREATE TABLE borrow (
  book_id INT NOT NULL,
  user_id INT NOT NULL,
  issue_date DATE NOT NULL,
  due_date DATE NOT NULL,
  FOREIGN KEY (book_id) REFERENCES book(book_id),
  FOREIGN KEY (user_id) REFERENCES user(user_id),
  PRIMARY KEY (book_id)
);
SELECT
  *
FROM
  book;
SELECT
  *
FROM
  user;
SELECT
  *
FROM
  borrow;
INSERT INTO
  user(
    privilege,
    username,
    first_name,
    last_name,
    gender,
    marital_status,
    address,
    password,
    avatar
  )
VALUES
  (
    2,
    'administrator',
    'Discord',
    'Admin',
    'M',
    'U',
    'Smash Karts server, Tall Team Ltd.',
    'SamplePassword!@#',
    LOAD_FILE(
      'C:\\Users\\anshd\\OneDrive\\Documents\\University\\Semester VI\\Advanced Java Programming\\Lab\\LibraryManagementSystem\\src\\com\\anshdawda\\resources\\defaultAvatar.png'
    )
  ),
  (
    1,
    'moderator',
    'Discord',
    'Mod',
    'M',
    'U',
    'Smash Karts server, Tall Team Ltd.',
    'SamplePassword!@#',
    LOAD_FILE(
      'C:\\Users\\anshd\\OneDrive\\Documents\\University\\Semester VI\\Advanced Java Programming\\Lab\\LibraryManagementSystem\\src\\com\\anshdawda\\resources\\defaultAvatar.png'
    )
  ),
  (
    0,
    'player',
    'Discord',
    'User',
    'M',
    'U',
    'Smash Karts server, Tall Team Ltd.',
    'SamplePassword!@#',
    LOAD_FILE(
      'C:\\Users\\anshd\\OneDrive\\Documents\\University\\Semester VI\\Advanced Java Programming\\Lab\\LibraryManagementSystem\\src\\com\\anshdawda\\resources\\defaultAvatar.png'
    )
  );
SHOW VARIABLES LIKE 'secure_file_priv';
SELECT
  LOAD_FILE(
    'C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\defaultAvatar.png'
  );