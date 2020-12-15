# springboot-book-store

### An Demo of E-Commerce system of book store by using java spring-boot and gradle

**Completed List**
- [x] Example of Junit Test
- [x] Static Code Analysis by PMD
- [ ] Feature buying with discounted (Kata Potter https://codingdojo.org/kata/Potter/) 
- [x] Dockerfile and Docker Compose
- [x] Stub service of Depenendcy 
- [x] Component Test with Postman
- [x] Build pipeline with Jenkins
- [x] Using H2 embeded database

> Test case in this project only contain for example for using tools to create test script and will not enough for coverage the business conditions

---
## Designing System
**Acceptance Test Scenario** : User buying 5 difference books of potter and completed the order with payment

**Start** 
:white_circle:  [1.Listing all books] -> [2.Order the selected books] -> [3.Complete payment to the order] -- :black_circle:
**End** 

---
## How to build/test/run

-	Run static code analysis
	```
	./gradlew check
	```
-	Run unit test
	```
	./gradlew test
	```
-	Build package jar
	```bash
	./gradlew build
	```
-	Run static code analysis
	```bash
	./gradlew check
	```
-	Start stub service
	```bash
	java -jar stubby4j-7.0.0.jar -d payment-gateway.yaml -s 4000
	```
-	Build Docker image
	```bash
	docker-compose build
	```
- Starting service to ready for component test
	```bash
	docker-compose up
	```
- Run component test
	```bash
	newman run book-store.postman_collection.json -e book-store-local.postman_environment.json
	```
