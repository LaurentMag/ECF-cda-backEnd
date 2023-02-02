# ECF Localib back-end.

## Présentation :

ECF back-end de l'application Localib ( sujet de l'examen ).  
Dans le cadre de la formation concepteur développeur d'application
a m2i, villeneuve d'ascq

## Prérequis :

- Java 11+
- [docker](https://docs.docker.com/get-docker/)
- [docker-compose](https://docs.docker.com/compose/install/)
- IDE (IntelliJ, Eclipse)

## Installation :

### Projet :

Pour lancer la base de donnée, dans un terminal, se déplacer dans le dossier du projet  
Et lancer la commande :

```
docker-compose up -d
```

L'API et la base de donnée vont être dockerisé

## Chemins de l'API :

---

### Clients :

GET :

- **findAll**

```
/clients
```

- **findById**

```
/clients/id
```

- **Recherches**

```
/clients/recherches?paramètre=
```

paramètre : **nom** ou **prenom**

POST :

- **save**

```
/clients
```

- **mise à jour**

```
/clients/id
```

DELETE :

- **suppression**

```
/clients/id
```

---

### Vehicules :

GET :

- **findAll**

```
/vehicules
```

- **findById**

```
/vehicules/id
```

- **Recherches**

```
/vehicules/recherches?paramètre=
```

paramètre : **marque** ou **modele** ou **etat** ou **disponible(true or false)**

POST :

- **save**

```
/vehicules
```

- **mise à jour**

```
/vehicules/id
```

DELETE :

- **suppression**

```
/vehicules/id
```

---

### Locations :

GET :

- **findAll**

```
/locations
```

- **findById**

```
/locations/id
```

POST :

- **save**

```
/locations
```

- **mise à jour**

```
/locations/id
```

DELETE :

- **suppression**

```
/locations/id
```
