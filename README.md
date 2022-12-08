# ECF Localib back-end.

## Présentation :
ECF back-end de l'application Localib ( sujet de l'examen ).  
Dans le cadre de la formation concepteur développeur d'application
a m2i, villeneuve d'ascq

Liens vers le **Front-End** :
[GitHub](https://github.com/LaurentMag/ECF-cda-frontEnd)


## Prérequis :
- Java 11+
- [docker](https://docs.docker.com/get-docker/)
- [docker-compose](https://docs.docker.com/compose/install/)
- IDE (IntelliJ, Eclipse)

## Installation :
### Base de donnée :
Pour lancer la base de donnée, dans un terminal, se déplacer dans le dossier du projet   
Et lancer la commande :
```
docker-compose up -d
```

### Lancer l'application dans l'IDE :
Ouvrir le projet dans l'IDE choisi, et lancer la class :  
`Ecf3CdaBackEndApplication`

### Lancer l'application sans IDE :
Dans un terminal, se déplacer dans le dossier du projet, et lancer la commande :
```
./gradlew spring-boot:run
```