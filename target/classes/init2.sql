
/*
    Database initialization script that runs on every web-application redeployment.
*/
DROP TABLE IF EXISTS coupons_shops;
DROP TABLE IF EXISTS coupons;
DROP TABLE IF EXISTS shops;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
	CONSTRAINT email_not_empty CHECK (email <> ''),
	CONSTRAINT password_not_empty CHECK (password <> '')
);

CREATE TABLE shops (
    id SERIAL PRIMARY KEY,
    companyName TEXT NOT NULL,
	CONSTRAINT name_not_empty CHECK (companyName <> '')
);

CREATE TABLE coupons (
    id SERIAL PRIMARY KEY,
    user_id INTEGER,
    companyName TEXT NOT NULL,
    percentage INTEGER NOT NULL,
    CONSTRAINT name_not_empty CHECK (companyName <> ''),
	CONSTRAINT percentage_between_bounds CHECK (percentage >= 0 AND percentage <= 100),
	FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE coupons_shops (
    coupon_id INTEGER,
    shop_id INTEGER,
    PRIMARY KEY (coupon_id, shop_id),
    FOREIGN KEY (coupon_id) REFERENCES coupons(id),
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);

INSERT INTO users (email, password) VALUES
	('user1@user1', 'user1'), -- 1
	('user2@user2', 'user2'), -- 2
	('user2@user3', 'user3'); -- 3

INSERT INTO shops (companyName) VALUES
	('SPAR'),   -- 1
	('Tesco'),  -- 2
	('Auchan'), -- 3
	('LIDL'),   -- 4
	('ALDI');   -- 5

INSERT INTO coupons (companyName, user_id, percentage) VALUES
	('Sausage discount', 1, 10),           -- 1
	('Bread super-sale', 1, 50),           -- 2
	('Bread super-sale', 2, 40),           -- 3
	('20% off from EVERYTHING!', 3, 20),   -- 4
	('1 product for FREE!', 3, 100),       -- 5
	('Mega Discount!', 1, 60),             -- 6
	('Ultra Discount!', 2, 40);            -- 7

INSERT INTO coupons_shops (coupon_id, shop_id) VALUES
    (1, 1), -- 1
    (1, 2),
    (1, 3),
    (2, 1), -- 2
    (2, 2),
    (2, 3),
    (2, 5),
    (3, 1), -- 3
    (3, 2),
    (3, 5),
    (4, 3), -- 4
    (5, 2), -- 5
    (5, 5),
    (6, 5),
    (7, 5);


