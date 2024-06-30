### Spring Boot H2 Database CRUD - TUTORIAL

### Run Maven and Spring Boot application:
```bash  
mvn spring-boot:run
```  

## Postman  :rocket:

### Headers:

- **Key:** Content-Type

- **Value:** application/json

### Body:
- **raw**
- **JSON**

```bash
{  
"nome": "nome",  
"dataNascimento": "dd/MM/yyyy",  
"cpf": "00000000000"  
}  
```  

### HTTP Methods and Status:
| HTTP|STATUS|
|--|--|
|GET ALL|204 No Content / 200 OK|
|GET ID| 200 OK|
|POST|201 Created|
|PUT|200 OK|
|DELETE ID|200 OK|
|DELETE ALL|200 OK|