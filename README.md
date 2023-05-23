Technologies - Spring Boot, Maven, H2, Postman
--------------------------------------------
Project Setup
---------------------
Do git clone repo using Gitbash or through IDE(Eclipse/ Intellij etc)

Open project in IDE

Do Maven clean install

Open RewardPointsApplication.java file and then right click run as Java application


Below steps for different data inputs
---------------------------------------
1) Below endpoint will create sample data in H2.

http://localhost:8080/mockupData

![alt text](https://github.com/Raghuj95/CustomerRewardPoints/blob/main/Showcase/mockupdata.png)

| Method  | API                               | Request  | Response                    |
| ------- | --------------------------------- | -------- | --------------------------- |
| POST    |  http://localhost:8080/mockupData |   [{"customerName":"customer1","purchaseAmount":"100","createdDate":"13/03/2023"},{"customerName":"customer1","purchaseAmount":"40","createdDate":"01/04/2023"},{"customerName":"customer1","purchaseAmount":"140","createdDate":"02/04/2023"}]       |  Mockup Data is created     |

2) Get the customer total earning points and monthly wise total earning points

http://localhost:8080/getRewardPoints?customerName=customer1

![alt text](https://github.com/Raghuj95/CustomerRewardPoints/blob/main/Showcase/customer1.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getRewardPoints?customerName=customer1 |          |  {"totalPoints":180,"rewards":[{"month":3,"monthPoints":50},{"month":4,"monthPoints":130}]}     |

3)Get the customer total earning points and monthly wise total earning points

http://localhost:8080/getRewardPoints?customerName=customer2

![alt text](https://github.com/Raghuj95/CustomerRewardPoints/blob/main/Showcase/customer2.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getRewardPoints?customerName=customer2 |          |  {"totalPoints":200,"rewards":[{"month":3,"monthPoints":90},{"month":4,"monthPoints":110}]}    |

4)Incase of user is not found

http://localhost:8080/getRewardPoints?customerName=customer10

![alt text](https://github.com/Raghuj95/CustomerRewardPoints/blob/main/Showcase/nocustomer.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getRewardPoints?customerName=customer10 |          |  {"totalPoints":0,"rewards":[]}    |

To Run Junits 
-----------
Unit Testing  Junit (run com.points.PointsServiceTest.java class)

![alt text](https://github.com/Raghuj95/CustomerRewardPoints/blob/main/Showcase/Junits.png)

For Dockerization
-----------------
use dockerfile to create image
