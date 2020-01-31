# springboot-angular-mysql-autocomplete
This app is a demo to show how autocomplete works with Angular 8 and SpringBoot 2.X => MySql.

- [x] First you must persist some MYSQL data (as shown below).
- [x] Then run the springboot app on port 8080.
- [x] Run the Angular 8 app.


-----------------------------------------------------------------------------------------------------------



 **2. Table structure for table `product`**

```
 CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `price` decimal(10,1) NOT NULL,
  `quantity` int(11) NOT NULL,
  `description` text NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```


 **3. after set id as index**


ALTER TABLE `product` ADD INDEX(`id`);

 **4. after set id as auto_increment**


ALTER TABLE `product` CHANGE `id` `id` INT(11) NOT NULL AUTO_INCREMENT;

 **5. Add some data for table `product`**

```
INSERT INTO product (name, price, quantity, description, status) VALUES('Samsung Galaxy S9', '295.00', 5, '4GB Unlocked GSM 4G LTE Phone w/ 12MP Camera - Midnight Black', 1);
INSERT INTO product (name, price, quantity, description, status) VALUES('Samsung Galaxy S8', '195.00', 5, '4GB Unlocked GSM 4G LTE Phone w/ 10MP Camera - Midnight Blue', 1);
INSERT INTO product (name, price, quantity, description, status) VALUES('HUAWEI P20 Lite', '229.00', 2, '4G LTE Dual SIM GSM Factory Unlocked Smartphone', 1);
INSERT INTO product (name, price, quantity, description, status) VALUES('HUAWEI V40 Lite', '1229.00', 2, '14G BTE trial SIM GSM Factory Unlocked Smartphone', 1);
INSERT INTO product (name, price, quantity, description, status) VALUES('Apple iPhone XR', '499.99', 9, ' 64GB, Black - Fully Unlocked', 1);
INSERT INTO product (name, price, quantity, description, status) VALUES('Samsung Galaxy Note 10 ', '749.99', 15, 'Cell Phone with 256GB', 1);
INSERT INTO product (name, price, quantity, description, status) VALUES('Nokia 6.2', '249.00', 8, 'Android 9.0 Pie - 64 GB - Triple Camera - Unlocked Smartphone', 0);
INSERT INTO product (name, price, quantity, description, status) VALUES('Nokia 26.2', '349.00', 8, 'Android 9.0 Pie - 164 GB - Triple Camera - Unlocked Smartphone', 0);
INSERT INTO product (name, price, quantity, description, status) VALUES('Apple iPhone 6S', '136.30', 8, '64GB, Space Gray - Fully Unlocked', 0); 
INSERT INTO product (name, price, quantity, description, status) VALUES('Nokia 3', '79', 11, 'Android 9.0 Pie - 16 GB - Unlocked', 0);
INSERT INTO product (name, price, quantity, description, status) VALUES('Apple iPhone ZR', '699.99', 9, ' 64GB, Grey - Fully Unlocked', 1);
INSERT INTO product (name, price, quantity, description, status) VALUES('Apple iPhone ZXR', '1499.99', 9, ' 164GB, White - Fully Unlocked', 1);

```
