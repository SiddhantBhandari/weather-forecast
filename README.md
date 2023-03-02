# Weather Forecast Application
A simple Spring Boot Application for retrieving the weather forecast for a specific location.

# Guide to use.
The RESTful API endpoints are ready to use. You can simply clone the repo and run this application and test the APIs on your localhost server.
The application contains two API endpoints
 #### 1. Retrieve the weather forecast summary details
 #### 2. Retrieve the weather forecast summary details hourly.
 
 
 To Test these API endpoints three things are necessary which needs to be passed in the Header.
 ##### 1. Client-ID = anyValue
 ##### 2. Client-Secret = anyValue
 ##### 3. Accept = application/json
 
 
 ### 1. To retrieve the weather forecast summary details.
 For retrieving the weather forecast summary details the following API endpoint is useful. 
 
 http://localhost:4000/api/forecast/summary/{locationName}
 
 By entering the locationName in the URI path the weather summary details of the given location will be retrieved.
 
 
 ### 2. To retrieve the weather forecast summary details hourly. 
 For retrieving the weather forecast summary details the following API endpoint is useful. 
 
 http://localhost:4000/api/forecast/hourly-summary/{locationName}
 
 By entering the locationName in the URI path the weather summary details on hourly basis of the given location will be retrieved.
