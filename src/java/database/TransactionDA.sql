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
