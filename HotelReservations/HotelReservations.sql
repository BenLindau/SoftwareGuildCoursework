CREATE DATABASE HotelReservations;

USE HotelReservations;

CREATE TABLE Customer
(
	CustomerID INT NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(30) NULL,
    LastName VARCHAR(30) NULL,
    Phone VARCHAR(20) NOT NULL,
    Email VARCHAR(50) NULL,
    PRIMARY KEY (CustomerID)
    );
    
    CREATE TABLE Rooms
    (
		RoomID INT NOT NULL AUTO_INCREMENT,
        RoomType VARCHAR(20) NOT NULL,
        Floor INT NOT NULL,
        Amenities VARCHAR(50) NULL,
        PRIMARY KEY (RoomID)
    );
    
            
        CREATE TABLE Amenities
        (
			AmenityID INT NOT NULL AUTO_INCREMENT,
            AmenityName VARCHAR(30) NOT NULL,
            AmenityCatagory VARCHAR(20) NOT NULL,
            PRIMARY KEY (AmenityID)
		);
        
        CREATE TABLE Discounts
        (
			DiscountID INT NOT NULL AUTO_INCREMENT,
            DiscountName VARCHAR(30) NULL,
            DiscountRate DOUBLE NOT NULL,
            PRIMARY KEY (DiscountID)
		);
        
        CREATE TABLE Tax
        (
			TaxID INT NOT NULL AUTO_INCREMENT,
            State VARCHAR(50) NULL,
            TaxRate DOUBLE NOT NULL,
            PRIMARY KEY (TaxID)
		);
        
	CREATE TABLE Pricing
    (
		PriceID INT NOT NULL AUTO_INCREMENT,
        Item VARCHAR(30) NOT NULL,
        RoomID INT NULL,
        AmenityID INT NULL,
        Price DOUBLE NOT NULL,
        TaxID INT,
        PRIMARY KEY (PriceID),
        FOREIGN KEY (RoomID) REFERENCES Rooms(RoomID),
        FOREIGN KEY (AmenityID) REFERENCES Amenities(AmenityID),
        FOREIGN KEY (TaxID) REFERENCES Tax(TaxID)
        );
        
        CREATE TABLE Reservations
        (
			ReservationID INT NOT NULL AUTO_INCREMENT,
            CustomerID INT NULL,
            CustomerReservationCode VARCHAR(30) NOT NULL,
            FamilyMembers VARCHAR(100) NULL,
            CheckInDate DATETIME NOT NULL,
            CheckOutDate DATETIME NULL,
            PriceID INT NULL,
            RoomID INT NULL,
			AmenityID INT NULL,
            DiscountID INT NULL,
            PRIMARY KEY (ReservationID)
		);
        
        CREATE TABLE Billing
        (
			BillID INT NOT NULL AUTO_INCREMENT,
            ReservationID INT NOT NULL,
           	CustomerID INT NULL,
            PriceID INT NULL,
			RoomID INT NULL,
			AmenityID INT NULL,
            DiscountID INT NULL,
            TotalBill DOUBLE NOT NULL,
			PRIMARY KEY (BillID)
		);
    
	ALTER TABLE Reservations 
    ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    ADD FOREIGN KEY (PriceID) REFERENCES Pricing(PriceID),
    ADD FOREIGN KEY (RoomID) REFERENCES Rooms(RoomID),
    ADD FOREIGN KEY (AmenityID) REFERENCES Amenities(AmenityID),
	ADD FOREIGN KEY (DiscountID) REFERENCES Discounts(DiscountID)
    ;
    
    ALTER TABLE Billing
    ADD FOREIGN KEY (ReservationID) REFERENCES Reservations(ReservationID),
	ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    ADD FOREIGN KEY (PriceID) REFERENCES Pricing(PriceID),
    ADD FOREIGN KEY (RoomID) REFERENCES Rooms(RoomID),
    ADD FOREIGN KEY (AmenityID) REFERENCES Amenities(AmenityID),
    ADD FOREIGN KEY (DiscountID) REFERENCES Discounts(DiscountID)
    ;