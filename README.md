# 1003_jwtSecurity
This is an example application just to show how JWT token is generated and how you can validate or extract data from it. 
It still uses the spring security login and no filter is intercepted. To test the application from the browser you still have to login using the username
and password from the application.properties ( john/johnny) to access the endpoints.

From POST man, you can select the authorization as "Bearer Token" from the Type dropdown under "Authorization" tab. The way to test from postman is to first hit
any URL with Authorization Type as "Basic Auth" and have "john/johnny" and once cookie JSESSIONID is set with the credentials then you can select Authorization
as Type "Bearer Token" and enter a valid token you got from getJWTToken.

Steps to test 
1. http://localhost:8003/employees/getJWTtoken/MasterMindsGroUps on the web browser and enter credentials john/johnny and you will see a jwt token returned
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNYXN0ZXJNaW5kc0dyb1VwcyIsImV4cCI6MTYzNDk3MDA5MSwiaWF0IjoxNjM0OTM0MDkxfQ.pC9dMPlr4ZLwkJ1UOUgkBArdtQgO1aqoTJTyoJuuvqI

2. Go to POSTMAN and enter http://localhost:8003/employees/getUsernameFromToken with GET operation , authroization as "Basic Auth"  john/johnny , this will
successfully generate the cookie with JSESSIONID , which can be used for subsequent requests but you will the response as
:Invalid format for JWT Token needs to start with "Bearer ":  // as the Authorization VALUE is not as expected 

3. Hit the same URL http://localhost:8003/employees/getUsernameFromToken with GET operation But this time under Authorization tab, select  authorization "Type"
as "Bearer Token" and enter Token value what you got from the web browser or from postman jwtToken
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNYXN0ZXJNaW5kc0dyb1VwcyIsImV4cCI6MTYzNDk3MDA5MSwiaWF0IjoxNjM0OTM0MDkxfQ.pC9dMPlr4ZLwkJ1UOUgkBArdtQgO1aqoTJTyoJuuvqI

This will extract the username from the jwt token and shown in the response as 
MasterMindsGroUps is the username for:eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNYXN0ZXJNaW5kc0dyb1VwcyIsImV4cCI6MTYzNDk3MDA5MSwiaWF0IjoxNjM0OTM0MDkxfQ.pC9dMPlr4ZLwkJ1UOUgk
BArdtQgO1aqoTJTyoJuuvqI

4. you can use any text in URL http://localhost:8003/employees/getJWTtoken/<your text> and use the jwt token in header for 
http://localhost:8003/employees/getUsernameFromToken and you will see <your text> in response.
