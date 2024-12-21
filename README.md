# B+ Tree implementation

## Introduction
This is a basic implementation of a B+ Tree in Java. It supports the following operations:
* Insert
* Delete
* Search

Project is exposing a REST API to perform the operations. The API is documented using Swagger and can be accessed at http://localhost:8080/swagger-ui.html

Open api documentation is available at http://localhost:8080/v3/api-docs

## How to run
First, make sure you have Java 17 installed on your machine and JAVA_HOME environment variable is set on that path.

The project is using Gradle as build tool. To run the project, execute the following command:
```
./gradlew clean bootRun
``` 
Project will then be available at http://localhost:8080

## Endpoints

### 1. `/`
**Method:** `GET`  
**Description:** Retrieves the tree data.  
**Operation ID:** `index`  
**Response:**
- **200 OK:**
  - Content Type: `application/json`
  - Response Body: Full tree.
```bash
curl -X GET http://localhost:8080/ 
```

### 2. `/add`
**Method:** `GET`  
**Description:** Adds a new value to the tree.  
**Operation ID:** `add`  
**Response:**
- **200 OK:**
  - Content Type: `application/json`
  - Response Body: The entire tree with the new value added.
```bash
curl -X GET http://localhost:8080/add 
```

### 3. `/delete`
**Method:** `GET`  
**Description:** Deletes the entire tree.  
**Operation ID:** `delete`  
**Response:**
- **200 OK**
```bash
curl -X GET http://localhost:8080/delete 
```


## What's next
You first need to understand how this implementation works.
Next, you can try to implement a few features, the minimum being:
* Creating a way to **import data from a file containing a least 100000 entries**
* Creating a way to **serialize the tree**, so that it can be **saved** to a file and **loaded** later
* **Benchmarking the implementation** to see how it performs
  * Pick a random number (try for 100, 1k, 10k values) of entries existing in dataset, then : 
    * Search for these values in the tree, measure the time to find them (average time, min time, max time, etc) 
    * Search for the **same values** in the file directly (load file in memory **once** then search all the values), for each search operation, measure the response time and calculate min / max / average
  * Build a report with the results of the benchmarking and explain the results, pair with graphs to display results.
* Write a README with instructions 
  * How to execute your project
  * How to load data into the tree
  * How to serialize the tree
  * How to execute the benchmark

## How to submit your work
Your work should only be submitted through the Github classroom assignment link. You should not create a pull request to the original repository. (https://classroom.github.com/a/c8lFUPv6)

## References
Based on the following repository : https://github.com/linli2016/BPlusTree
Heavily changed to incorporate real b+ tree constraints and to use dynamic collections instead of fixed size arrays.

