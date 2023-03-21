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
