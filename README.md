# LibraryManagementSystem

Advanced Java Programming group task for lab

- Install MySQL on port `3306` and give username as `root` (default)

- give password for `root` user as `root`

- create a database with name 'bookdb' using following command.
```sql
create database bookdb;
```

- select bookdb database.
```sql
use bookdb;
```

- copy-paste following lines in your database to create tables.

```sql
create table book
(
	book_isbn varchar(20) primary key,
	book_title varchar(50),
	category varchar(20),
	no_of_books int
);
```

```sql
create table author
(
	author_name varchar(30),
	author_mail_id varchar(50),
	book_isbn varchar(20),
	foreign key(book_isbn) references book(book_isbn)
);
```

```sql
create table student
(
	usn varchar(20) primary key,
	name varchar(30) not null
);
```

```sql
create table book_issue
(
	issue_id int primary key auto_increment,
	usn varchar(20) not null,
	issue_date date,
	return_date date,
	book_isbn varchar(20),
	foreign key(usn) references student(usn),
	foreign key(book_isbn) references book(book_isbn)
);
```

```sql
create table admin
(
	admin_id varchar(20) primary key,
	password varchar(20)
);
```

```sql
insert into admin values('admin','admin');
```
