## Spring Boot H2 Database CRUD - TUTORIAL

### Run Maven and Spring Boot application:
```bash  
mvn spring-boot:run
```  

### Postman  :rocket:

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

```
{  
"nome": "Teste 2",  
"dataNascimento": "10/10/1990",  
"cpf": "01",  
    "description": [
        {
            "phrase": "GOL" 
        }
    ]
}  
```


### HTTP Methods, CRUD and Status:
:rocket: [What are Http methods?](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods)

:rocket: [What is CRUD?](https://www.codecademy.com/article/what-is-crud)

:rocket: [HTTP response status code](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

|    HTTP    |  CRUD  | STATUS      |
|:----------:|:------:|:------------|
|  GET ALL   |  READ  | 200 OK      | 
|   GET ID   |  READ  | 200 OK      |
|    POST    | CREATE | 201 Created |
|    PUT     | UPDATE | 200 OK      |
| DELETE ID  | DELETE | 200 OK      |
| DELETE ALL | DELETE | 200 OK      |