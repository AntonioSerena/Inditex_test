# Inditex Spring Boot H2 RestAPI 

* Java 17
* Spring Boot 3.1
* JPA H2 database console:  http://localhost:8080/h2-console
* JUnit Jupiter API tests
* Maven 3.3.1


# POSTMAN:
0. GET http://localhost:8080/api
1. GET http://localhost:8080/api/allPrices
2. GET http://localhost:8080/api/price, Body:  
   {
   "applicationDate" : "2020-06-15T10:00:00",
   "productId": "35455",
   "brandId": 1
   }
 
# Comentarios
Para este test a priory se ha descartado el uso de librerias tipo Lombok 
