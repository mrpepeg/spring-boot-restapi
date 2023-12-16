# spring-boot-restapi
A rest api module with springboot frameworks as a test for applying on PT INFINITIUM SOLUTIONS.
This project is about validating user payment that registered with hardcoded coding inside the file. The project have a feature to convert the currency from Dollar to rupiah only. For example, if you want to validate your user payment as the listed user below but you want to pay with Dollar currency, you can change the request of "currency" field to "DOLLAR".

HOW TO RUN 
- Clone this repository
- Make sure you are using JDK 1.8 and Maven 3.x
- You can build the project and run the tests by running mvn clean package or click build in your IDEA.
- Once successfully built, run the project.


Here are some users that already registered:
- User 1
  id : 1, name : Ron, accountId : Ron01, amount : 75000, currenct: IDR
- User 2
  id : 2, name : Jack, accountId : Jack01, amount : 150000, currenct: IDR
- User 3
  id : 3, name : Becky, accountId : Becky01, amount : 180000, currenct: IDR
- User 4
  id : 4, name : Ann, accountId : Ann01, amount : 240000, currenct: IDR
- User 5
  id : 5, name : Hod, accountId : Hod01, amount : 270000, currenct: IDR

 
Here are some endpoints you can call:
1. Get user payment by id
   Method : GET
   URL    : BaseURL/userPayment?id=id_user (e.g : 1,2,3,4,5)
2. Validate user payment
   Method : POST
   URL    : BaseURL/validatePayment
   Request:
   {
    "id": 1,
    "name": "Ron",
    "accountId": "Ron01",
    "amount": 75000,
    "currency": "IDR"
   }
   Response:
   - 200 :  "message": "Payment validated!. Currency use : IDR"
   - 404 :  "message": "Payment declined.Users with this account id does not exists"
   - 422 :  "message": "Payment declined.Amount required for this user is not the same."
