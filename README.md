# rabbitmq


```SHELL
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

```SHELL
http://localhost:15672/
guest
guest
```

## Exchange Types

- DIRECT
- TOPIC
- FANOUT
- HEADERS 
- SYSTEM


## Example 1

Topic Exchange

```SHELL
http://localhost:8080/publish?message=HelloRabbitMQ
```


## Resources
- https://www.rabbitmq.com/tutorials
- https://www.rabbitmq.com/docs/shovel
