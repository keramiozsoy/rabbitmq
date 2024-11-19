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
- Topic Exchange
- One exchange - one topic

```SHELL
GET http://localhost:8080/publish?message=HelloRabbitMQ
```
## Example 2

- Topic Exchange
- One exchange - multiple topic

```SHELL
GET http://localhost:8080/publish?type=sms&message=Hello+SMS
GET http://localhost:8080/publish?type=email&message=Hell+Email
GET http://localhost:8080/publish?type=push&message=Hello+Push
```


## Resources
- https://www.rabbitmq.com/tutorials
- https://www.rabbitmq.com/docs/shovel
( To move messages, the shovel plugin must be enabled, try:
$ rabbitmq-plugins enable rabbitmq_shovel rabbitmq_shovel_management
)


## TODO
- create repo as multi-module.