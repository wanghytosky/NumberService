# Requirement
Design a microservice which does number block management from a telco perspective.
1. need to track status of numbers
2. need to track history of numbers
3. decouple service and number, anything to do with service delivered to the customer using that number is not needed
4. microservice must be able to scale horizontally
5. microservice must supply API to frontend order portal for number selection

# Architecture
![Architecture Diagram](https://github.com/wanghytosky/NumberService/blob/master/image/Architecture.jpeg?raw=true)

# Number Service
![Architecture Diagram](https://github.com/wanghytosky/NumberService/blob/master/image/numberservice.png?raw=true)


# CDN 
Content Distribution Network is used to speed up clients' access and provides protection from large surges in traffic to mitigate the load pressure. 

# FireWall
Ensure network security.

# LVS
Load balancing improves the distribution of workloads (request from clients) across multiple clusters.

# Nginx
Following the URL address rules, nginx distributes multiple request from clients to the corresponding server.

# Redis
Based pubsub pattern (publish-subscribe pattern) and types of list data, implement message queue over redis to maximize the throughput.  

# Solr
Catching the history information by Solr maximizes the efficiency of query to status/histories. Index is updated hourly. 

# DataBase Design
![Architecture Diagram](https://github.com/wanghytosky/NumberService/blob/master/image/database.jpg?raw=true)

# Database overview
* **Customer table**: maintains customer information.</br>
	&#8195;&#8195;&#8195;cus_id (int)&#8195;: primary key, id of each customer.</br>
	&#8195;&#8195;&#8195;cus_name (varchar)&#8195;: name of each customer.</br>
	&#8195;&#8195;&#8195;passport_number (varchar)&#8195;: passport number of the customer.</br>
	&#8195;&#8195;&#8195;passport_expiredTime (datetime)&#8195;: passport expired time.</br></br>
* **Number table**: maintains number information.</br>
	&#8195;&#8195;&#8195;num_id (int)&#8195;: primary key, id of each number. </br>
	&#8195;&#8195;&#8195;cus_id (int)&#8195;: foreign key to customer table.</br>
	&#8195;&#8195;&#8195;service_id(int)&#8195;: foreign key to service table.</br>
	&#8195;&#8195;&#8195;status_id (tinyint)&#8195;: foreign key to status table.</br>
	&#8195;&#8195;&#8195;phone_number (int)&#8195;: phone number</br>
	&#8195;&#8195;&#8195;create_time (datetime)&#8195;: create time of this record.</br>
	&#8195;&#8195;&#8195;expired_time (datetime)&#8195;: number cannot be used after this time.</br></br>
* **History table**: maintains records for every change. </br>
	&#8195;&#8195;&#8195;history_id (int)&#8195;: primary key, id of each change, generated by UUID.</br>
	&#8195;&#8195;&#8195;num_id (int)&#8195;: foreign key to number table.</br>
	&#8195;&#8195;&#8195;cus_id (int)&#8195;: foreign key to customer table.</br>
	&#8195;&#8195;&#8195;service_id(int)&#8195;: foreign key to service table.</br>
	&#8195;&#8195;&#8195;status_id (tinyint)&#8195;: foreign key to status table.</br>
	&#8195;&#8195;&#8195;create_time (datetime)&#8195;: time of change happens.</br></br>
* **NumberStatus table**: maintains status information. </br>
	&#8195;&#8195;&#8195;status_id (tinyint)&#8195;: primary key, id of each status.</br>
	&#8195;&#8195;&#8195;status_name (varchar)&#8195;: the name of the status (0: available 1: in use; 2: pause; 3: disabled).</br>
	&#8195;&#8195;&#8195;description (varchar)&#8195;: describe the details of the status.</br></br>
* **Service table**: maintains service information. </br>
	&#8195;&#8195;&#8195;service_id (int)&#8195;: primary key, id of each service.</br>
	&#8195;&#8195;&#8195;service_name (varchar)&#8195;: the name of the service, such as prepaid, contract.</br>
	&#8195;&#8195;&#8195;service_type (tinyint)&#8195;: 0->Prepaid 1->contact .</br>
	&#8195;&#8195;&#8195;description (varchar)&#8195;: describe the details of the service.</br>

# Restful API Documentation
Run the microservice and enter "http://localhost:8080/swagger-ui.htm" on your browser.</br>
You will see more details of the documentation.</br>
api-docs.json : https://raw.githubusercontent.com/wanghytosky/NumberService/master/api-doc/api-docs.json
![Architecture Diagram](https://github.com/wanghytosky/NumberService/blob/master/image/api.jpeg?raw=true)

# Code Structure
* **Common Modules**:</br>
&#8195;&#8195;&#8195;common: Public class, such as enumerate, constant, general class for service independent unit, etc. </br>
&#8195;&#8195;&#8195;config: Custom Configuration</br></br>
* **Presentation Layer**:</br>
&#8195;&#8195;&#8195;controller: It is in charge of page access control and exposing Rest API interface.</br>
&#8195;&#8195;&#8195;dao: It is short for data access object. MyBatis is chosen as ORM. </br></br>
* **Business Logic Layer**:</br>
&#8195;&#8195;&#8195;service: Service interface includes business logic. </br>
&#8195;&#8195;&#8195;entity: Model Class</br>
# Database Dump File & Configuration
* **Dump File**:</br>
https://github.com/wanghytosky/NumberService/blob/master/mysql_databse/numbermicroservice_db_dump.sql</br></br>
* **Configuration File**:</br>
https://github.com/wanghytosky/NumberService/blob/master/NumberMicroService/src/main/resources/application.properties

# About Optimizaion
The mini project is implemented by some basic technologies.It can be better in performance.</br>
Such as the things in Architecture, e.g:solr, redis, etc.
