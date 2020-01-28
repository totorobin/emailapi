# Email API

##build

pour générer le war
```
mvn clean install
```


##configuration

modifier le fichier "application.properties"

en mode demo, utilisation de [MailJet](https://app.mailjet.com) 
````
spring.profiles.active=demo
````

en production, utiliser un serveur smtp 
````
spring.profiles.active=prod


spring.mail.host=smtp.gmail.com
spring.mail.port=587
...
````


##tester en local

telécharger [FakeSMTP](http://nilhcem.github.com/FakeSMTP/downloads/fakeSMTP-latest.zip)

le dézziper et lancer le jar :
````
 java -jar fakeSMTP.jar
````

configuration :
````
spring.profiles.active=prod


spring.mail.host=localhost
spring.mail.port=25
...
````