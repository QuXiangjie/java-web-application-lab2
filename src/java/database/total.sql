DROP TABLE Account;

-- Table to store the common attributes of Account
CREATE TABLE Account (
    accountNumber INT,
    customerID INT,
    accountName VARCHAR(255),
    dateOpened VARCHAR(255),
    accountType VARCHAR(20), -- A column to distinguish between LiabilityAccount and AssetAccount
    PRIMARY KEY (accountNumber)
);

-- Table to store the attributes specific to LiabilityAccount
CREATE TABLE LiabilityAccount (
    accountNumber INT,
    interestRate DOUBLE,
    monthlyPayment DOUBLE,
    paymentDate VARCHAR(255),
    FOREIGN KEY (accountNumber) REFERENCES Account(accountNumber)
);

-- Table to store the attributes specific to AssetAccount
CREATE TABLE AssetAccount (
    accountNumber INT,
    interestRate DOUBLE,
    transactionFee DOUBLE,
    FOREIGN KEY (accountNumber) REFERENCES Account(accountNumber)
);
-- for assetaccount
INSERT INTO Account (accountNumber, customerID, accountName, dateOpened, accountType)
VALUES (10001, 1001, '1-1-ac', '1-31-23', 'AssetAccount');

INSERT INTO AssetAccount (accountNumber, interestRate, transactionFee)
VALUES (10001, 0.5, 0.5);

INSERT INTO Account (accountNumber, customerID, accountName, dateOpened, accountType)
VALUES (10002, 1002, '1-2-ac', '1-31-23', 'AssetAccount');

INSERT INTO AssetAccount (accountNumber, interestRate, transactionFee)
VALUES (10002, 0.5, 0.5);
-- for LiabilityAccounts
INSERT INTO Account (accountNumber, customerID, accountName, dateOpened, accountType)
VALUES (20001, 1001, '2-1-ac', '1-31-23', 'LiabilityAccount');

INSERT INTO LiabilityAccount (accountNumber, interestRate, monthlyPayment, paymentDate)
VALUES (20001, 0.5, 0.5, '2-4-23');

INSERT INTO Account (accountNumber, customerID, accountName, dateOpened, accountType)
VALUES (20002, 1002, '2-2-ac', '1-31-23', 'LiabilityAccount');

INSERT INTO LiabilityAccount (accountNumber, interestRate, monthlyPayment, paymentDate)
VALUES (20002, 0.5, 0.5, '2-4-23');


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


DROP table Transactions;
CREATE TABLE Transactions (
    transactionID INT,
    transactionDate VARCHAR(255),
    accountNumber INT,
    description VARCHAR(255),
    transactionAmount INT,
    PRIMARY KEY (transactionID),
    FOREIGN KEY (accountNumber) REFERENCES Account(accountNumber)
);
INSERT INTO Transactions (transactionID, transactionDate, accountNumber, description, transactionAmount) VALUES
(1, '2-4-23', 10001, '1001 assetaccount transaction', 10),
(2, '2-3-23', 10001, '1001 assetaccount transaction', 11),
(3, '2-2-23', 10001, '1001 assetaccount transaction', 12),
(4, '2-1-23', 10002, '1002 assetaccount transaction', 13),
(5, '1-31-23', 10002, '1002 assetaccount transaction', 14),
(6, '1-31-23', 10002, '1002 assetaccount transaction', 15),
(7, '2-3-23', 20001, '2001 liabilityaccount transaction', 16),
(8, '2-2-23', 20001, '2001 liabilityaccount transaction', 17),
(9, '2-1-23', 20001, '2001 liabilityaccount transaction', 18),
(10, '1-31-23', 20002, '2002 liabilityaccount transaction', 19),
(11, '1-31-23', 20002, '2002 liabilityaccount transaction', 20),
(12, '2-4-23', 20002, '2002 liabilityaccount transaction', 21);


