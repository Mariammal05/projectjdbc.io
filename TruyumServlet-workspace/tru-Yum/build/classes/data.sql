-- -----------------------------------------------------
-- Menu List Admin
-- -----------------------------------------------------

INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99.00', 'yes', '2017-03-15', 'Main Course', 'yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129.00', 'yes', '2017-12-23', 'Main Course', 'no');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149.00', 'yes', '2018-08-21', 'Main Course', 'no');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57.00', 'no', '2017-07-02', 'Starters', 'yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate', '32.00', 'yes', '2022-11-02', 'Dessert', 'yes');


/*User Table Details */

insert into `truyum`.`user` (us_id, us_name) values(01, 'Vijay');
insert into `truyum`.`user` (us_name) values('Ajith');
insert into  `truyum`.`user` (us_name) values('Ajay');

/*Menu List Customer*/

SELECT me_id,me_name,me_free_delivery,me_price,me_category FROM truyum.menu_item 
where me_date_of_launch > curdate() and  me_active = 'yes';

/*Edit Menu Item*/

SELECT * from `truyum`.`menu_item` WHERE (`me_id` = '2');
UPDATE `truyum`.`menu_item` SET `me_name` = 'Burger' WHERE (`me_id` = '2');

/*Add Cart*/
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,1);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,3);

/*View Cart*/
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from 
truyum.menu_item
inner join  truyum.cart on ct_me_id=me_id
where  ct_us_id=1;

select sum(me_price) as total from truyum.menu_item 
inner join truyum.cart  on   ct_me_id=me_id
where  ct_us_id=1;

/*Remove cart*/

delete from truyum.cart where ct_us_id='1'and ct_me_id='4';
