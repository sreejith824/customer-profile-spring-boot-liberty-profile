### Sample REST APIs :

* [Sample 1 - Get all customer]
GET /v1/customerprofile/?page=5&amp;size=5 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 696818d8-e0bf-f9b0-0d9c-dedbc32a27e6

* [Sample 2 - Get all customer]
GET /v1/customerprofile HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: d692d62b-7173-8553-ef2e-6977a96f2585

* [Sample 3 - Create a customer]
POST /v1/customerprofile HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: fbe412cb-bbba-4efb-54d5-0585c8c8a082

{
	"name" : "Test",
	"age" : "12"
}


