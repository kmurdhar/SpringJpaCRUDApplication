# Checkout code using git clone 

git clone https://github.com/kmurdhar/SpringJpaCRUDApplication.git

# We are using the postgres database to connect out spring boot application.
# The DB configuration is maintained in application.properties

ClientController contain all the API to Create, Update, Read Client.


#Api to create Client details 

URL :- http://localhost:8081/api/CreateClient
Method :- POST
Request Body :-
{
    "firstName":"abc",
    "lastName":"abc",
    "mobileNumber":"789456123",
    "clientId":"1234",
    "physicalAddress": "The Address is the place where the person is located"
}

Response :- 

{
    "firstName":"abc",
    "lastName":"abc",
    "mobileNumber":"789456123",
    "clientId":"1234",
    "physicalAddress": "The Address is the place where the person is located"
}

## API to get all clients 

URL :- http://localhost:8081/api/clients
Method :- GET
No Request body 

Response :- 
[
    {
        "id": 1,
        "firstName": "abc",
        "lastName": "abc",
        "mobileNumber": 789456123,
        "clientId": 1234,
        "physicalAddress": "The Address is the place where the person is located"
    }
]

## API to search  Based on client_id

URL :- http://localhost:8081/api/clients/client_id/1234
METHOD:- GET
NO Request body
Response :-

{
    "id": 1,
    "firstName": "abc",
    "lastName": "abc",
    "mobileNumber": 789456123,
    "clientId": 1234,
    "physicalAddress": "The Address is the place where the person is located"
}

## API to search  Based on id

URL :- http://localhost:8081/api/clients/id/1
METHOD:- GET
NO Request body
Response :-

{
    "id": 1,
    "firstName": "abc",
    "lastName": "abc",
    "mobileNumber": 789456123,
    "clientId": 1234,
    "physicalAddress": "The Address is the place where the person is located"
}


## API to update  Based on id

URL :- http://localhost:8081/api/clients/1
METHOD:- PUT
Request :- 

{
    "firstName":"abc1",
    "lastName":"abc1",
    "mobileNumber":"789456123",
    "clientId":"1234",
    "physicalAddress": "The Address is the place where the person is located"
}
Response :-

{
    "id": 1,
    "firstName": "abc1",
    "lastName": "abc1",
    "mobileNumber": 789456123,
    "clientId": 1234,
    "physicalAddress": "The Address is the place where the person is located"
}