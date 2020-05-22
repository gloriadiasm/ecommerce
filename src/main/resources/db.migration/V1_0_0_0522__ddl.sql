CREATE TABLE IF NOT EXISTS address
 (
  id INT NOT NULL AUTO_INCREMENT,
  street VARCHAR(45) NULL,
  district VARCHAR(45) NULL,
  state VARCHAR(45) NULL,
  city VARCHAR(45) NULL,
  number INT NULL,
  zip_code VARCHAR(45) NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS category
 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(70) NULL,
  description VARCHAR(300),
  PRIMARY KEY (id)
 );

 CREATE TABLE IF NOT EXISTS supplier
 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  address INT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (address) REFERENCES address
 );

CREATE TABLE IF NOT EXISTS product
 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  price decimal(13,4) NULL,
  size VARCHAR(45) NULL,
  category INT NULL,
  supplier INT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category) REFERENCES category,
  FOREIGN KEY (supplier) REFERENCES supplier
  );

CREATE TABLE IF NOT EXISTS cart
 (
  id INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY(id)
 );

CREATE TABLE IF NOT EXISTS cartitems
 (
    id INT NOT NULL AUTO_INCRIMENT,
    cart int,
    product int,
    total_price decimal(13,4),
    quantity int,
    PRIMARY KEY (id),
    FOREIGN KEY (cart) REFERENCES cart,
    FOREIGN KEY (product) REFERENCES product
 );

CREATE TABLE IF NOT EXISTS client
(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  phone_number VARCHAR(11) NULL,
  email VARCHAR(50) NULL,
  address INT NULL,
  shipping DECIMAL(13,4) NULL,
  cart INT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (address) REFERENCES address,
  FOREIGN KEY (cart) REFERENCES cart
  );

CREATE TABLE IF NOT EXISTS ecommerce.order
 (
  id INT NOT NULL AUTO_INCREMENT,
  client int,
  status VARCHAR (300),
  PRIMARY KEY (id),
  FOREIGN KEY (client) REFERENCES client
 );

CREATE TABLE IF NOT EXISTS orderitems
 (
  id INT NOT NULL AUTO_INCRIMENT,
  client_order int,
  product int,
  price decimal(13,4),
  quantity int,
  PRIMARY KEY (id),
  FOREIGN KEY (client_order) ecommerce.order,
  FOREIGN KEY (product) product
 );

CREATE TABLE IF NOT EXISTS sold
 (
  id INT NOT NULL AUTO_INCREMENT,
  product int,
  quantity int,
  PRIMARY KEY (id),
  FOREIGN KEY (product) references product
 );

CREATE TABLE IF NOT EXISTS stock
 (
  id INT NOT NULL AUTO_INCREMENT,
  product int,
  quantity int,
  PRIMARY KEY (id),
  FOREIGN KEY (product) references product
 );

CREATE TABLE IF NOT EXISTS store
 (

    id INT NOT NULL AUTO_INCROMENT,
    name VARCHAR (150),
    cnpj int
    address int,
    PRIMARY KEY (id),
    FOREIGN KEY (address) REFERENCES address
 )


