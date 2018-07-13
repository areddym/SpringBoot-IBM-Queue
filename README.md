# IBM MQ Connection 

This project just demonstrate how to send a message to an IBM queue using Spring Boot.

- This is a POST method which you can send a message to the queue, this method body is just a String
```
http://localhost:8080/queue
```

Body Example: 
```
{"test":"test"}
```