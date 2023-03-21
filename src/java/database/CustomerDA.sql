drop table Customer;
CREATE TABLE Customer (
    customerID INT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    phoneNum BIGINT,
    UserID VARCHAR(255),
    Password VARCHAR(255),
    PRIMARY KEY (customerID)
);

INSERT INTO Customer (customerID, firstName, lastName, phoneNum, UserID, Password)
VALUES
  (1001, 'XIANGJIE', 'QU', 5551312, 'Cust1', 'cust1'),
  (1002, 'JACK', 'QU', 6661312, 'Cust2', 'cust2'),
  (1003, 'Anthony', 'Tang', 7771312, 'Cust3', 'cust3');
