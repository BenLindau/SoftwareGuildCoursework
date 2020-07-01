CREATE DATABASE Books;

USE Books;

CREATE TABLE IF NOT EXISTS Authors (
	AuthorId INT(11) NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    Street VARCHAR(20) NOT NULL,
    City VARCHAR(20) NOT NULL,
    State VARCHAR(20) NOT NULL,
    Zip VARCHAR(20) NOT NULL,
    Phone VARCHAR(20) NOT NULL,
    PRIMARY KEY (AuthorId)
    ) ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
    
CREATE TABLE IF NOT EXISTS Books (
	BookId INT(11) NOT NULL AUTO_INCREMENT,
    ISBN VARCHAR(20) NOT NULL,
    Title VARCHAR(20) NOT NULL,
    PublisherId INT(11) NOT NULL,
    Price DECIMAL(5,2) NOT NULL,
    PublishDate DATETIME NOT NULL,
    PRIMARY KEY (BookId),
    KEY PublisherId (PublisherId)
    ) ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
    
CREATE TABLE IF NOT EXISTS Books_Authors (
	BookId INT(11) NOT NULL,
    AuthorId INT(11) NOT NULL,
    KEY BookId (BookId),
    KEY AuthorId (AuthorId)
    ) ENGINE = InnoDB DEFAULT CHARSET=latin1;
    
 CREATE TABLE IF NOT EXISTS Publishers (
	PublisherId INT(11) NOT NULL AUTO_INCREMENT,
    PubName VARCHAR(20) NOT NULL,
    Street  VARCHAR(20) NOT NULL,
    City VARCHAR(20) NOT NULL,
    State VARCHAR(20) NOT NULL,
    Zip VARCHAR(20) NOT NULL,
    Phone VARCHAR(20) NOT NULL,
    PRIMARY KEY (PublisherId)
    ) ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
        
ALTER TABLE Books
ADD CONSTRAINT books_ibfk_1 FOREIGN KEY (PublisherId) REFERENCES Publishers
(PublisherId) ON DELETE NO ACTION;        

ALTER TABLE Books_Authors
	ADD CONSTRAINT books_authors_ibfk_1	FOREIGN KEY (BookId) REFERENCES Books
	(BookId) ON DELETE NO ACTION,
	ADD CONSTRAINT books_authors_ibfk_2 FOREIGN KEY (AuthorId) REFERENCES Authors
	(AuthorId) ON DELETE NO ACTION;
        
