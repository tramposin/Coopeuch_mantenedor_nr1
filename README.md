# JObs RESTful API
This command executes the rest-api application locally available on port 8080
### Use of available endpoints
1.- Busca tareas
```bash
curl -X GET "http://localhost:8080/api/v1/tarea" -H "accept: */*"
```
2.- Agrega Nueva tarea
```bash
curl -X POST "http://localhost:8080/api/v1/tarea" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"descripcion\": \"Test descr\", \"fechaCreacion\": \"2000-12-15\", \"vigente\": true}"
```
3.- Actualiza tarea por Id
```bash
curl -X PUT "http://localhost:8080/api/v1/tarea/1?descripcion=test%20descr&fechaCreacion=2000-10-20" -H "accept: */*"
```
4.- Elimina tarea por Id
```bash
curl -X DELETE "http://localhost:8080/api/v1/tarea/1" -H "accept: */*" 