# API Spec

## Authentication

All API must use this authentication

Request :
- Header :
    - X-Api-Key : "your secret api key"

## Create Quote

Request :
- Method : POST
- Endpoint : `/api/quotes`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
    "id" : "string, unique",
    "author" : "string",
    "text" : "string",
}
```

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "id" : "string, unique",
         "author" : "string",
         "text" : "string",
     }
}
```

## Get Quote

Request :
- Method : GET
- Endpoint : `/api/quotes/{id_quote}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "id" : "string, unique",
         "author" : "string",
         "text" : "string",
     }
}
```

## Update Quote

Request :
- Method : PUT
- Endpoint : `/api/quotes/{id_quote}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
    "author" : "string",
    "text" : "string",
}
```

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "id" : "string, unique",
         "author" : "string",
         "text" : "string",
     }
}
```

## List Quote

Request :
- Method : GET
- Endpoint : `/api/quotes`
- Header :
    - Accept: application/json
- Query Param :
    - size : number,
    - page : number

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : [
        {
             "id" : "string, unique",
             "author" : "string",
             "text" : "string",
        },
        {
             "id" : "string, unique",
             "author" : "string",
             "text" : "string",
         }
    ]
}
```

## Delete Quote

Request :
- Method : DELETE
- Endpoint : `/api/quotes/{id_quote}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
    "status" : "string"
}
```
