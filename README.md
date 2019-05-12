# myStore

How to run this project :

1. Install Grails
   - Download grails 3.2.4 from http://grails.org/download.html
   - Set the GRAILS_HOME environment variable to the location where you extracted the zip
   - export GRAILS_HOME=/path/to/grails-3.2.4
   - export PATH="$PATH:$GRAILS_HOME/bin

2. Install java 8
   - Download java 8 from https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
   - export JAVA_HOME=/path/to/jdk1.8.0_131
   - export PATH="$PATH:$JAVA_HOME/bin

3. Install mysql workbench
   - Download mysql from https://dev.mysql.com/downloads/workbench/
   - Create new schema mystore

4. Start project 
   - Clone this repository
   - Run the app using the run-app command
   - cd myStore
   - grails run-app

-------------------------------------

answer for question 1 : localhost:8080/question1?input=bestCrimeMovies=theGuilty;bestComedyMovies=shaolinSoccer;bestActionMovies=IronMan;

result : 
Status:200 OK
Time:392 ms
Size:287 B

"answerNo1": {
        "bestComedyMovies": "shaolinSoccer",
        "bestActionMovies": "IronMan",
        "bestCrimeMovies": "theGuilty"
}

answer for question 3

Data user :

INSERT INTO `user` (`id`,`version`,`email`,`name`,`password`,`role_id`,`created_by`,`date_created`,`last_updated`,`updated_by`) VALUES (1,0,'admin@store.com','Admin_1','1234',1,NULL,'2017-01-01 00:00:00',NULL,NULL);
INSERT INTO `user` (`id`,`version`,`email`,`name`,`password`,`role_id`,`created_by`,`date_created`,`last_updated`,`updated_by`) VALUES (2,0,'employee@store.com','Employee_1','1234',2,'1','2017-01-01 00:00:00',NULL,NULL);
INSERT INTO `user` (`id`,`version`,`email`,`name`,`password`,`role_id`,`created_by`,`date_created`,`last_updated`,`updated_by`) VALUES (3,0,'affiliate@store.com','Affiliate 1','1234',3,'1','2017-01-01 00:00:00',NULL,NULL);
INSERT INTO `user` (`id`,`version`,`email`,`name`,`password`,`role_id`,`created_by`,`date_created`,`last_updated`,`updated_by`) VALUES (4,0,'user@store.com','User 1','1234',4,'1','2017-05-09 00:00:00',NULL,NULL);
INSERT INTO `user` (`id`,`version`,`email`,`name`,`password`,`role_id`,`created_by`,`date_created`,`last_updated`,`updated_by`) VALUES (5,0,'user@store.com','User 1','1234',4,'1','2019-05-09 00:00:00',NULL,NULL);


Data role :

INSERT INTO `role` (`id`,`version`,`name`) VALUES (1,0,'ROLE_ADMIN');
INSERT INTO `role` (`id`,`version`,`name`) VALUES (2,0,'ROLE_EMPLOYEE');
INSERT INTO `role` (`id`,`version`,`name`) VALUES (3,0,'ROLE_AFFILIATE');
INSERT INTO `role` (`id`,`version`,`name`) VALUES (4,0,'ROLE_USER');

1. http://localhost:8080/totalPay?totalPrice=810&userId=2
    - user 2 : role = employee , get discount 30%
    - total discount for userId 2, 10% from total price =243
    - {"totalBill":567.0}

2. http://localhost:8080/totalPay?totalPrice=810&userId=3
    - user 3 : role = affiliate , get discount 10%
    - total discount for userId 3, 10% from total price = 81
    - {"totalBill":729.0}
    
3. http://localhost:8080/totalPay?totalPrice=810&userId=4
    - user 4 : role = user , has been a customer for over 2 years , get discount 5%
    - total discount for userId 4, 5% from total price = 40.5
    - {"totalBill":769.5}
    
4. http://localhost:8080/totalPay?totalPrice=810&userId=5
    - user 5 : role = user , get 5$ for every 100$
    - total discount for userId 5 = 40
    - {"totalBill":770}

