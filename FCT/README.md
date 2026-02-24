# FCT Manager (pendiente)
# [ Documento usado para la organización a tiempo real del proyecto](./FCT%20Manager.md)
# Progreso realizado
## 1. Controller
### 1.1. AuthController
- Endpoints definidos, pero sin lógica.
### 1.2. AlumneController
- Endpoints definidos, pero sin lógica.
### 1.3. ConveniController
- Endpoints definidos, pero sin lógica.

### 1.4. DashboardController
- Endpoints definidos, pero sin lógica.

### 1.5. EmpresaController
- Endpoints definidos.
- Lógica completada.

### 1.6. TutorsControllers
- Endpoints definidos, pero sin lógica.

**Hace falta cambiar el nombre**

## 2. Model
- Todos los modelos se han creado.
**Dispuesto a cambios de nomencaltura, según como avancen los otros cambios**


## 3. Service
AlumneService y TutorCentreService implementados a falta de agregar los métodos de crear y modificar los alumnos y tutores.
Servicio de Dasboard sin el método para devolver todos los campos.
Servicio de empresa implementado, en principio no necesita más cambios.

## 4. Dto
Las DTO’s están todas acabadas, falta arreglar los nombres, ya que los imports no tienen los nombres correctos debido a las diferencias entre singular / plural. Además, habría que arreglar la confusión entre Tutor/TutorEmpresa/TutorCentro.

dto/
├─ AlumenRequest.java 
├─ AlumneResponse.java
├─ CicleRequest.java
├─ CicleResponse.java
├─ ConveniRequest.java
├─ ConveniResponse.java
├─ DashboardResponse.java
├─ EmpresaRequest.java
├─ EmpresaResponse.java
├─ LoginRequest.java
├─ LoginResponse.java
├─ TutorCentreResponse.java
├─ TutorEmpresaResponse.java
└─ TutorRequest.java


