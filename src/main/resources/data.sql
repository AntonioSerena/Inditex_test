DROP TABLE IF EXISTS PRICES;

CREATE TABLE PRICES (ID INTEGER NOT NULL, BRAND_ID INTEGER, START_DATE TIMESTAMP, END_DATE TIMESTAMP,
    PRICE_LIST INTEGER, PRODUCT_ID VARCHAR, PRIORITY INTEGER, PRICE FLOAT , CURR VARCHAR);

INSERT INTO PRICES (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
    VALUES
    (1, 1, parsedatetime('2020-06-14-00.00.00','yyyy-MM-dd-HH.mm.ss'), parsedatetime('2020-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 1, 35455, 0, 35.50, 'EUR'),
    (2, 1, parsedatetime('2020-06-14-15.00.00','yyyy-MM-dd-HH.mm.ss'), parsedatetime('2020-06-14-18.30.00','yyyy-MM-dd-HH.mm.ss'), 2, 35455, 1, 25.45, 'EUR'),
    (3, 1, parsedatetime('2020-06-15-00.00.00','yyyy-MM-dd-HH.mm.ss'), parsedatetime('2020-06-15-11.00.00','yyyy-MM-dd-HH.mm.ss'), 3, 35455, 1, 30.50, 'EUR'),
    (4, 1, parsedatetime('2020-06-15-16.00.00','yyyy-MM-dd-HH.mm.ss'), parsedatetime('2020-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 4, 35455, 1, 38.95, 'EUR');
