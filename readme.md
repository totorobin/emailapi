# Email API

##build

pour générer le war
```
mvn war
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