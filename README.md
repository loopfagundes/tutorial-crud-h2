### Spring Boot H2 Database CRUD - TUTORIAL

### Run Maven and Spring Boot application:
```bash  
mvn spring-boot:run
```  

## Postman  :rocket:

- **URL:** 

``` 
http://localhost:8080/api/tutorials
```
- **PATCH:**
```bash 
/id for GET, PUT, or DELETE 
```


### Headers:

- **Key:** Content-Type

- **Value:** application/json

### Body:
- **raw**
- **JSON**

```
{  
"nome": "nome",  
"dataNascimento": "dd/MM/yyyy",  
"cpf": "00000000000"  
}  
```  

### HTTP Methods, CRUD and Status:
|    HTTP    |  CRUD  | STATUS                  |
|:----------:|:------:|:------------------------|
|  GET ALL   |  READ  | 204 No Content / 200 OK | 
|   GET ID   |  READ  | 200 OK                  |
|    POST    | CREATE | 201 Created             |
|    PUT     | UPDATE | 200 OK                  |
| DELETE ID  | DELETE | 200 OK                  |
| DELETE ALL | DELETE | 200 OK                  |