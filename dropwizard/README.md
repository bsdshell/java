# Simple Dropwizard example

- Last Updated: 

#### tasklist-service 
- How to run the service in your localhost
- cd to tasklist-service and run following commands

```
    mvn install 
```
- jar filel will be created in target directory

```sh
    target/tasklist-service-1.0-SNAPSHOT.jar
```
- run
```sh
    java -jar target/tasklist-service-1.0-SNAPSHOT.jar server tasklist-service.yml
```
- above command will run localhost in port 8080
- point your browse to following URL 
- http://localhost:8080/task-list
