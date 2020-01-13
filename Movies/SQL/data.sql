
-- -----------------------------------------------------
-- Movie Admin
-- -----------------------------------------------------
SELECT * FROM movie.movie_list;
INSERT INTO `movie`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_teaser`) VALUES ('1', 'Avatar', '2787965087', 'Yes', '2020-05-15', 'Science Fiction', 'yes');
INSERT INTO `movie`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_teaser`) VALUES ('2', 'The Avengers', '1518812988', 'Yes', '2021-03-12', 'Super hero', 'No');
INSERT INTO `movie`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_teaser`) VALUES ('3', 'Titanic', '2187463944', 'Yes', '2025-08-23', 'Romance', 'No');
INSERT INTO `movie`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_teaser`) VALUES ('4', 'Jurassic World', '1671713208', 'No', '2019-07-23', 'Science Fiction', 'yes');
INSERT INTO `movie`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_teaser`) VALUES ('5', 'Avengers: End Game', '2750760348', 'Yes', '2015-04-12', 'Superhero', 'yes');

Select * from movie_list where mov_date_of_launch > curdate()and mov_active = 'Yes' ;

select * from movie_list where mov_id =5;

UPDATE `movie`.`movie_list` SET `mov_title` = 'Titanic ', `mov_active` = 'No' WHERE (`mov_id` = '3');
UPDATE `movie`.`movie_list` SET `mov_title` = 'Harry Potter' WHERE (`mov_id` = '4');
UPDATE `movie`.`movie_list` SET `mov_gross` = '1518816988.00' WHERE (`mov_id` = '2');
UPDATE `movie`.`movie_list` SET `mov_date_of_launch` = '2015-03-12' WHERE (`mov_id` = '5');

update `movie`.`movie_list` set mov_date_of_launch ='2020-06-06' where mov_id='1';
-- -----------------------------------------------------
-- Customer
-- -----------------------------------------------------
INSERT INTO `movie`.`user` (`us_id`, `us_name`) VALUES ('1', 'Vijay');
INSERT INTO `movie`.`user` (`us_id`, `us_name`) VALUES ('2', 'Ajay');
-- -----------------------------------------------------
-- Add Movies
-- -----------------------------------------------------
INSERT INTO `movie`.`favorites` (`fav_id`, `fav_us_id`, `fav_mov_id`) VALUES ('101', '1', '1');
INSERT INTO `movie`.`favorites` (`fav_id`, `fav_us_id`, `fav_mov_id`) VALUES ('102', '1', '3');
INSERT INTO `movie`.`favorites` (`fav_id`, `fav_us_id`, `fav_mov_id`) VALUES ('103', '1', '4');

Select * from movie.favorites;
select COUNT(*) as no_of_favorites from movie.favorites;
-- -----------------------------------------------------
--Remove Favorites
-- -----------------------------------------------------
DELETE FROM `movie`.`favorites` WHERE (`fav_id` = '102');

use movie;
-- -----------------------------------------------------
-- Total Favorites
-- -----------------------------------------------------
select count(*) as no_of_favorites from movie.favorites 
inner join movie.movie_list  on  mov_id = fav_mov_id
where  fav_us_id=2
;