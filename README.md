APLICACIÓN HOLA MUNDO

FUNCION
La aplicación muestra "Hola Mundo" cuando se llama por http al vinculo del
balanceador de carga generado por kubernetes (minikube).

DESCRIPCIÓN
La aplicación esta contenida en GitHub, https://github.com/GitRonald2023/bcobta.git
que inclye el codigo fuente, las declaraciones .yml que ejecutan deployment y servicio
en kubernetes local y el pipeline de CI CD.
La aplicación es desarrollada con framework Spring Boot, maven y java.

DIRECTORIOS
Aplicación: bcobta
Fuentes: scr/main/java/bcobta/bcobta/BcobtaApplication.java
Controller: scr/main/java/bcobta/bcobta/controllers/HomeController.java
Pruebas Unitarias: src/test/java/com/bcobta/bcobta/HomeControllersTest.java
Imagen Docker: Dockerfile
Declaraciones .yml para kubernetes: k8s/

VARIABLES Y SECRETS
github.run_number : numero que controla github para referirse al # ejecución
github.event.head_commit.author.email : Variable de github que contiene el correo con 
el que se está generando el commit
USERNAME_GITHUB: variable de repositorio que almacena el usuario de github que tiene 
al repositorio de desarrollo
DOCKERHUB_USERNAME: secreto en el repositirio que almacena el usuario para logearse a 
Docker Hub
DOCKERHUB_TOKEN: secreto en el repositorio que almacena la clave para logearse a 
Docker Hub
MY_PAT : secreto en el repositorio que contiene el token del sistema para realizar commit 
automaticamente dentro del workflow, el token debe tener permisos de read-write en el 
ambiente, sus variables, secretos y demás elementos del repositorio de trabajo. 


SISTEMAS PARA FUNCIONAMIENTO:
On-premise
Docker Desktop (latest)
Manejador de contenedores
Minikube (lates)
Orquestador de amiente local de kubernetes
kubectl (latest)
Herramienta de interacción para administración de kubernetes
ArgoCD (lates)
Integrador de GitHub con Kubernetes local

Cloud
GihHub 
Repositorio de codigo fuente
GitHub Action
Ejecución de Pipeline
Docker Hub
Repositorio de imagenes docker

PIPELINE
TEST
La aplicación tiene dos(2) pruebas unitarias para validar que cuando 
cargue muestre "Hola Mundo" y un segundo vinculo /people muestre
"20 registros"
BUILD
Contruye un JAR con el que dockerfile crea la imagen docker, despúes
de ser creada la imagen es cargada en docker hub para ser usada desde
las declaraciones .yml de deployment.yml y service.yml 
DEPLOY
ArgoCD en on-premise lee cambios en el repo de GitHub en los .yml en 
la carpeta k8s y ejecuta en local el deployment.yml con la nueva imagen

En on-premise, desde el cluster de kubernetes se trabaja con un balanceador 
de carga para los pods creados con el deploymente, en el que se evidencian 
los cambio realizados al codigo.

DETALLE TECNICO
La aplicación funciona sobre el puerto 5000, en los contenedores se expone en 8080
y el balanceador de carga maneja puerto aleatorio, pero el vinculo se obtine con 
el comando "minikube service bcobta-service"




