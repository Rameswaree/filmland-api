A REST API application using Java 8 and Spring Boot for Filmland API

Note: This application will register new user, login, subscribe a category and share the subscribed category to a friend who is also a registered user.

Steps to run the application:

Clone the git repository or download the extract zip file.
Go to the path where the project is present and type 'mvn clean install' from the command terminal.
After this, navigate to the class FilmLandApplication and run the application.
Open the terminal.
Type 'curl -X GET "http://localhost:9999/filmland/details?name=Rameswaree"'. The logs should appear as shown "Categories: Unauthorized to access service Not Authorized". 
Go to the terminal and run the command 'curl -X POST "http://localhost:9999/filmland/signup" -H "Content-Type: application/json" -d '{\"email\":\"rameswaree@gmail.com\", \"name\":\"Rameswaree\", \"password\":\"1234\"}''. This will give a successful response '{"status":"200 OK","message":"User has been Successfully Registered"}'. 
Next type the command 'curl -X POST "http://localhost:9999/filmland/login" -H "Content-Type: application/json" -d '{\"email\":\"rameswaree@gmail.com\", \"password\":\"1234\"}''. This will give a successful response '{"status":"200 OK","message":"Login Successful"}'. 
Again type the command  'curl -X GET "http://localhost:9999/filmland/details?name=Rameswaree"'.This will give a list of categories as shown '{"availableCategories":[{"name":"Rameswaree","userName":"Dutch Series","availableContent":"20","price":6.0}],"subscribedCategories":[]}'.
To subscribe a category, run the command 'curl -X POST "http://localhost:9999/filmland/subscribe?name=Rameswaree" -H "Content-Type: application/json" -d "{\"name\":\"International films\"}"'. If the user does not have the subscription, it will give the response as '{"status":"Success200 OK","message":" Subscription item Rameswaree has been added to the bucket list of International films"}'. 
Again type the command  'curl -X GET "http://localhost:9999/filmland/details?name=Rameswaree"'. Since a category is subscribed for the user, the subscribed category will also appear in the response '{"availableCategories":[{"name":"Rameswaree","userName":"Dutch Series","availableContent":"20","price":6.0}],"subscribedCategories":[{"id":"1","name":"Rameswaree",
"userName":"International films","subscribedContent":"1","price":10.0,"subscribedDate":"2023-09-04T11:40:23.89","startDate":"2023-09-04T11:40:23.935"}]}'. 
Next, type 'curl -X GET "http://localhost:9999/filmland/details?name=Srikanth"'. The logs should appear as shown "Categories: Unauthorized to access service Not Authorized". 
Go to the terminal and run the command 'curl -X POST "http://localhost:9999/filmland/signup" -H "Content-Type: application/json" -d '{\"email\":\"srikanth@gmail.com\", \"name\":\"Srikanth\", \"password\":\"5678\"}''. This will give a successful response '{"status":"200 OK","message":"User has been Successfully Registered"}'. 
Next type the command 'curl -X POST "http://localhost:9999/filmland/login" -H "Content-Type: application/json" -d '{\"email\":\"srikanth@gmail.com\", \"password\":\"5678\"}''. This will give a successful response '{"status":"200 OK","message":"Login Successful"}'.
Now, type the command 'curl -X POST "http://localhost:9999/filmland/shareSubscribe?name=Rameswaree" -H "Content-Type: application/json" -d "{\"friendName\":\"Srikanth\", \"categoryName\":\"International films\"}"'. If the category name exists for the user Rameswaree, then it will get successfully shared with the user Srikanth. The response is as shown '{"status":"Success200 OK","message":" Successfully shared the item to Srikanth"}'. 
