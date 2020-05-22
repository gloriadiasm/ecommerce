CREATE TABLE IF NOT EXISTS ecommerce.address
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

CREATE TABLE IF NOT EXISTS ecommerce.category
 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(70) NULL,
  description VARCHAR(300),
  PRIMARY KEY (id)
 );

 CREATE TABLE IF NOT EXISTS ecommerce.supplier
 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  address INT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (address) REFERENCES ecommerce.address(id)
 );

CREATE TABLE IF NOT EXISTS ecommerce.product
 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  price decimal(13,4) NULL,
  size VARCHAR(45) NULL,
  category INT NULL,
  supplier INT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category) REFERENCES category(id),
  FOREIGN KEY (supplier) REFERENCES supplier(id)
  );

CREATE TABLE IF NOT EXISTS ecommerce.cart
 (
  id INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY(id)
 );

CREATE TABLE IF NOT EXISTS ecommerce.cartitems
 (
    id INT NOT NULL AUTO_INCREMENT,
    cart int,
    product int,
    total_price decimal(13,4),
    quantity int,
    PRIMARY KEY (id),
    FOREIGN KEY (cart) REFERENCES cart(id),
    FOREIGN KEY (product) REFERENCES product(id)
 );

CREATE TABLE IF NOT EXISTS ecommerce.client
(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  phone_number VARCHAR(11) NULL,
  email VARCHAR(50) NULL,
  address INT NULL,
  shipping DECIMAL(13,4) NULL,
  cart INT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (address) REFERENCES address(id),
  FOREIGN KEY (cart) REFERENCES cart(id)
  );

CREATE TABLE IF NOT EXISTS ecommerce.order
 (
  id INT NOT NULL AUTO_INCREMENT,
  client int,
  status VARCHAR (300),
  PRIMARY KEY (id),
  FOREIGN KEY (client) REFERENCES client(id)
 );

CREATE TABLE IF NOT EXISTS ecommerce.orderitems
 (
  id INT NOT NULL AUTO_INCREMENT,
  client_order int,
  product int,
  price decimal(13,4),
  quantity int,
  PRIMARY KEY (id),
  FOREIGN KEY (client_order) REFERENCES ecommerce.order(id),
  FOREIGN KEY (product) REFERENCES product(id)
 );

CREATE TABLE IF NOT EXISTS ecommerce.sold
 (
  id INT NOT NULL AUTO_INCREMENT,
  product int,
  quantity int,
  PRIMARY KEY (id),
  FOREIGN KEY (product) references product(id)
 );

CREATE TABLE IF NOT EXISTS ecommerce.stock
 (
  id INT NOT NULL AUTO_INCREMENT,
  product int,
  quantity int,
  PRIMARY KEY (id),
  FOREIGN KEY (product) references product(id)
 );

CREATE TABLE IF NOT EXISTS ecommerce.store
 (

    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR (150),
    cnpj int,
    address int,
    PRIMARY KEY (id),
    FOREIGN KEY (address) REFERENCES address(id)
 );


