CREATE DATABASE Supers;

USE Supers;

CREATE TABLE Heros (
	HeroId INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL,
    Description VARCHAR(200) NOT NULL,
    Powers VARCHAR(100) NOT NULL,
    LocationId INT NOT NULL,
    OrganizationId INT NULL,
    PRIMARY KEY (HeroId)
    ) ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
    
CREATE TABLE Locations (
	LocationId INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL,
    Street VARCHAR(100) NOT NULL,
    City VARCHAR(50) NOT NULL,
    State VARCHAR(50) NOT NULL,
    ZipCode VARCHAR(10) NOT NULL,
    Latitude DOUBLE NOT NULL,
    Longitude DOUBLE NOT NULL,
    PRIMARY KEY (LocationId)
    ) ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
    
    CREATE TABLE Organizations (
	OrgId INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL,
    LocationId INT NOT NULL,
    Phone VARCHAR(10) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    PRIMARY KEY (OrgId)
    )ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
    
    CREATE TABLE Sightings (
		SightingId INT NOT NULL AUTO_INCREMENT,
		HeroId INT NOT NULL,
        LocationId INT NOT NULL,
        Date VARCHAR(10) NOT NULL,
        PRIMARY KEY (SightingId)
        )ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
        
	CREATE TABLE HerosOrgs (
		HeroOrgId INT NOT NULL AUTO_INCREMENT,
		HeroId INT NOT NULL,
        OrgId INT NOT NULL,
        PRIMARY KEY (HeroOrgId)
        )ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
        
	ALTER TABLE HerosOrgs 
		ADD FOREIGN KEY (HeroId) REFERENCES Heros(HeroId),
        ADD FOREIGN KEY (OrgId) REFERENCES Organizations(OrgId); 
        
	INSERT INTO Heros (heroId, Name, Description, powers, locationId, organizationId) values (1, "SuperStan", "the most average man alive", "golfing", 1, 1), (2, "Superman", "alien", "strength", 2, 2); 
	INSERT INTO Locations (locationId, name, street, city, state, zipcode, latitude, longitude) values (1, "Secret Hide Out Number 1", "123 Wall Street", "New York", "New York", "12345", 33.33, 33.33), (2, "fortress of solitude", "1 antartic ave", "metropolis", "New Jersey", "66666", 1.11, 1.22);
	INSERT INTO Organizations (orgId, name, locationId, phone, email) values (1, "regular heros", 1, "1234567890", "regularheros@gmail.com"), (2, "super heros", 2, "0987654321", "superheros@gmail.com");
    INSERT INTO SIGHTINGS (sightingId, heroId, locationId, date) values (1, 1, 1, "01/01/2019"), (2, 2, 1, "01/01/2019");
    INSERT INTO HerosOrgs (HeroId, OrgId) values (1, 1), (2, 2);
    
CREATE TABLE IF NOT EXISTS `users` (
 `user_id` int(11) NOT NULL AUTO_INCREMENT,
 `username` varchar(20) NOT NULL,
 `password` varchar(100) NOT NULL,
 `enabled` tinyint(1) NOT NULL,
 PRIMARY KEY (`user_id`),
 KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;
--
-- Dumping data for table `users`
--
INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`) VALUES
(1, 'batman', 'password', 1),
(2, 'robin', 'password', 1);
--
-- Table structure for table `authorities`
--
CREATE TABLE IF NOT EXISTS `authorities` (
 `username` varchar(20) NOT NULL,
 `authority` varchar(20) NOT NULL,
 KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Dumping data for table `authorities`
--
INSERT INTO `authorities` (`username`, `authority`) VALUES
('batman', 'ROLE_ADMIN'),
('batman', 'ROLE_USER'),
('robin', 'ROLE_USER');
--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
 ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
 
 
 
CREATE DATABASE Supers_Test;

USE Supers_Test;

CREATE TABLE Heros (
	HeroId INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL,
    Description VARCHAR(200) NOT NULL,
    Powers VARCHAR(100) NOT NULL,
    LocationId INT NOT NULL,
    OrganizationId INT NULL,
    PRIMARY KEY (HeroId)
    ) ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
    
CREATE TABLE Locations (
	LocationId INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL,
    Street VARCHAR(100) NOT NULL,
    City VARCHAR(50) NOT NULL,
    State VARCHAR(50) NOT NULL,
    ZipCode VARCHAR(10) NOT NULL,
    Latitude DOUBLE NOT NULL,
    Longitude DOUBLE NOT NULL,
    PRIMARY KEY (LocationId)
    ) ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
    
    CREATE TABLE Organizations (
	OrgId INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL,
    LocationId INT NOT NULL,
    Phone VARCHAR(10) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    PRIMARY KEY (OrgId)
    )ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
    
    CREATE TABLE Sightings (
		SightingId INT NOT NULL AUTO_INCREMENT,
		HeroId INT NOT NULL,
        LocationId INT NOT NULL,
        Date VARCHAR(10) NULL,
        PRIMARY KEY (SightingId)
        )ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
        
	CREATE TABLE HerosOrgs (
		HeroId INT NOT NULL,
        OrgId INT NOT NULL
        )ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;
        
	ALTER TABLE HerosOrgs 
		ADD FOREIGN KEY (HeroId) REFERENCES Heros(HeroId),
        ADD FOREIGN KEY (OrgId) REFERENCES Organizations(OrgId); 
        
