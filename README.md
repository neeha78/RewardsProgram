Technologies - Junit, Spring Boot, Maven, H2, Postman
--------------------------------------------
Project Setup
---------------------
Do git clone repo using Gitbash or through IDE(Eclipse/ Intellij etc)

Open project in IDE

Do Maven clean install

Open RewardPointsApplication.java file and then right click run as Java application


Below steps for different data inputs
---------------------------------------
1) Below endpoint will create Transaction data in H2.

http://localhost:8080/transactions

![alt text](https://github.com/neeha78/RewardsProgram/blob/main/Showcase/createTrasactions.png)

| Method  | API                               | Request  | Response                    |
| ------- | --------------------------------- | -------- | --------------------------- |
| POST    |  http://localhost:8080/trasactions |    |  Mockup Data is created     |

2)Get the Transaction details

http://localhost:8080/transactions

![alt text](https://github.com/neeha78/RewardsProgram/blob/main/Showcase/GetTransactions.png)

| Method  | API                               | Request  | Response                    |
| ------- | --------------------------------- | -------- | --------------------------- |
| GET    |  http://localhost:8080/trasactions |    | [     {         "id": 1,         "customerName": "customer1",         "customerId": "ABC",         "purchaseAmount": 100,         "points": 50,         "createdDate": "2023-03-12T18:30:00.000+0000"     },     {         "id": 2,         "customerName": "customer1",         "customerId": "ABC",         "purchaseAmount": 40,         "points": 0,         "createdDate": "2023-03-31T18:30:00.000+0000"     },     {         "id": 3,         "customerName": "customer1",         "customerId": "ABC",         "purchaseAmount": 140,         "points": 130,         "createdDate": "2023-04-01T18:30:00.000+0000"     },     {         "id": 4,h         "customerName": "customer2",         "customerId": "XYZ",         "purchaseAmount": 120,         "points": 90,         "createdDate": "2023-03-10T18:30:00.000+0000"     },     {         "id": 5,         "customerName": "customer2",         "customerId": "XYZ",         "purchaseAmount": 130,         "points": 110,         "createdDate": "2023-03-31T18:30:00.000+0000"     } ]     |


3) Get the customer total earning points and monthly wise total earning points

http://localhost:8080/getRewards?customerId=ABC

![alt text](https://github.com/neeha78/RewardsProgram/blob/main/Showcase/GetCustomerID.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getRewards?customerId=ABC |          |  {     "customerId": "ABC",     "totalPoints": 180,     "rewards": [         {             "month": 3,             "monthPoints": 50         },         {             "month": 4,             "monthPoints": 130         }     ] }    |

4)Get all rewards

http://localhost:8080/getRewards

![alt text](https://github.com/neeha78/RewardsProgram/blob/main/Showcase/GetRewards.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getRewards |          |  [     {         "customerId": "XYZ",         "totalPoints": 200,         "rewards": [             {                 "month": 3,                 "monthPoints": 90             },             {                 "month": 4,                 "monthPoints": 110             }         ]     },     {         "customerId": "ABC",         "totalPoints": 180,         "rewards": [             {                 "month": 3,                 "monthPoints": 50             },             {                 "month": 4,                 "monthPoints": 130             }         ]     } ]    |


To Run Junits 
-----------
Unit Testing  Junit (run com.points.PointsServiceTest.java class)

![alt text](https://github.com/neeha78/RewardsProgram/blob/main/Showcase/Junits.png)

