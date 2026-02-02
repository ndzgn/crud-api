# CRUD API

Une API REST complète développée avec Spring Boot, offrant des opérations CRUD (Create, Read, Update, Delete) avec validation des données et tests automatisés.

##  Fonctionnalités

- **Opérations CRUD complètes** : Création, lecture, mise à jour et suppression d'entités
- **Validation des données** : Validation automatique des entrées avec Spring Validation
- **Tests automatisés** : Suite de tests unitaires et d'intégration
- **Architecture RESTful** : Respect des conventions REST pour les endpoints
- **Gestion des erreurs** : Gestion centralisée des exceptions avec messages clairs

##  Technologies utilisées

- **Java** : JDK 17
- **Spring Boot** : Framework principal
- **Maven** : Gestion des dépendances et build
- **Spring Data JPA** : Accès aux données
- **Spring Validation** : Validation des entrées
- **JUnit & Mockito** : Tests unitaires et d'intégration
- **PostgreSQL** : Base de données 

##  Prérequis

Avant de commencer, assurez-vous d'avoir installé :

- **JDK 17 ou supérieur** ([Télécharger ici](https://www.oracle.com/java/technologies/downloads/))
- **Maven 3.6+** ([Télécharger ici](https://maven.apache.org/download.cgi))
- **Git** ([Télécharger ici](https://git-scm.com/downloads))

Vérifiez vos installations :
```bash
java -version
mvn -version
git --version
```

##  Installation

### 1. Cloner le projet

```bash
git clone https://github.com/votre-username/crud-api.git
cd crud-api
```

### 2. Compiler le projet

```bash
mvn clean package
```

Cette commande va :
- Nettoyer les fichiers de build précédents
- Télécharger les dépendances
- Compiler le code source
- Exécuter les tests
- Générer le fichier JAR exécutable dans le dossier `target/`


##  Configuration

Le fichier `application.properties` ou `application.yml` permet de configurer :

- Port du serveur
- Configuration de la base de données
- Niveau de logs
- Propriétés de validation





##  Dépannage

### Le port 8080 est déjà utilisé
```bash
# Utiliser un port différent
java -jar target/crud-api.jar --server.port=8081
```

### Erreur de mémoire Java
```bash
# Augmenter la mémoire allouée
java -Xmx512m -jar target/crud-api.jar
```

### Problèmes de compilation Maven
```bash
# Nettoyer complètement le projet
mvn clean
rm -rf target/
mvn install
```
