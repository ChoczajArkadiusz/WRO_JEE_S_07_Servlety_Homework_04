CREATE TABLE Newsletter_Users(
  id    INT AUTO_INCREMENT,
  email VARCHAR(255) UNIQUE,
  name  VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE Guest_Book(
  id INT AUTO_INCREMENT,
  timestamp TIMESTAMP,
  name VARCHAR(255),
  message VARCHAR(1000),
  PRIMARY KEY (id)
);