DROP TABLE Room CASCADE CONSTRAINTS;
DROP TABLE Guest CASCADE CONSTRAINTS;
DROP TABLE Booking CASCADE CONSTRAINTS;

CREATE TABLE Room (id INT NOT NULL PRIMARY KEY, room_number INT NOT NULL, room_type VARCHAR(50) NOT NULL, room_price DECIMAL(10, 2) NOT NULL);

CREATE TABLE Guest (id INT NOT NULL PRIMARY KEY, guest_name VARCHAR(50) NOT NULL, guest_phone VARCHAR(15) NOT NULL, guest_email VARCHAR(50) NOT NULL);

CREATE TABLE Booking (id INT NOT NULL PRIMARY KEY, room_id INT NOT NULL, guest_id INT NOT NULL, check_in DATE NOT NULL, check_out DATE NOT NULL, CONSTRAINT fk_booking_room FOREIGN KEY (room_id) REFERENCES Room (id) ON DELETE CASCADE, CONSTRAINT fk_booking_guest FOREIGN KEY (guest_id) REFERENCES Guest (id) ON DELETE CASCADE, CONSTRAINT chk_booking_dates CHECK (check_out >= check_in));


-- insert data into Room table
INSERT INTO Room VALUES (1, 101, 'Standard', 100);
INSERT INTO Room VALUES (2, 102, 'Standard', 100);
INSERT INTO Room VALUES (3, 201, 'Deluxe', 150);
INSERT INTO Room VALUES (4, 202, 'Deluxe', 150);
INSERT INTO Room VALUES (5, 301, 'Suite', 250);
INSERT INTO Room VALUES (6, 302, 'Suite', 250);

-- insert data into Guest table
INSERT INTO Guest VALUES (1, 'John Doe', '123-456-7890', 'john.doe@example.com');
INSERT INTO Guest VALUES (2, 'Jane Smith', '456-789-0123', 'jane.smith@example.com');
INSERT INTO Guest VALUES (3, 'Bob Johnson', '789-012-3456', 'bob.johnson@example.com');
INSERT INTO Guest VALUES (4, 'Alice Brown', '012-345-6789', 'alice.brown@example.com');

-- insert data into Booking table
INSERT INTO Booking VALUES (1, 1, 1, '2023-05-01', '2023-05-03');
INSERT INTO Booking VALUES (2, 2, 2, '2023-05-02', '2023-05-04');
INSERT INTO Booking VALUES (3, 3, 3, '2023-05-05', '2023-05-07');
INSERT INTO Booking VALUES (4, 4, 4, '2023-05-08', '2023-05-10');
INSERT INTO Booking VALUES (5, 5, 1, '2023-05-15', '2023-05-20');
INSERT INTO Booking VALUES (6, 6, 2, '2023-06-01', '2023-06-03');



