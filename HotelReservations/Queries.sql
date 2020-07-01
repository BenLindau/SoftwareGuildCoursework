/*Queries*/

/*GET RESERVATION DATA*/
USE HotelReservations;

SELECT c.CustomerID, LastName, r.CustomerReservationCode, a.AmenityName, r.CheckInDate, r.CheckOutDate
FROM Customer c
INNER JOIN Reservations r ON c.CustomerID = r.CustomerID
INNER JOIN Amenities a ON r.AmenityID = a.AmenityID
WHERE CustomerReservationCode = 'JonesFamilyVacation';

/*GET LIST OF AMENITIES AND PRICES*/
USE HotelReservations;

SELECT a.AmenityID, a.AmenityName, a.AmenityCatagory, p.Price
FROM Amenities a
INNER JOIN Pricing p ON a.AmenityID = p.AmenityID; 

/*GET CUSTOMER DETAILS*/
USE HotelReservations;
SELECT c.CustomerID, c.LastName, r.CustomerReservationCode, r.RoomID, r.CheckInDate, r.CheckOutDate
FROM Customer c
INNER JOIN Reservations r ON c.CustomerID = r.CustomerID;

/*GET PRICE RANGE OF ROOM*/
USE HotelReservations;

SELECT p.RoomID, r.RoomType, Price
FROM  Pricing p
INNER JOIN Rooms r ON p.RoomID = r.RoomID;

/*DISPLAY DISCOUNTS*/
USE HotelReservations;
Select * 
FROM Discounts;

/*GET CHECK-OUT BILL*/
USE HotelReservations;

SELECT ReservationID, COUNT(*) RoomsOnRes, d.DiscountRate, t.TaxRate, 
SUM(Price * (1 - d.DiscountRate)) TotalCost, 
SUM((Price * (1 - d.DiscountRate)) * (1 + t.TaxRate)) WithTax
FROM Billing b
INNER JOIN Pricing p ON b.PriceID = p.PriceID
INNER JOIN Rooms r ON b.RoomID = r.RoomID
INNER JOIN Amenities a ON b.AmenityID = a.AmenityID
INNER JOIN Discounts d ON b.DiscountID = d.DiscountID
INNER JOIN Tax t ON b.TaxID = t.TaxID
WHERE CustomerID = 1;

/*Drop Database*/
drop database hotelreservations;
