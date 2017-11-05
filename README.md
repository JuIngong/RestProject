# RestProject

La specification/documentation, générer avec swagger, est disponnible à l'url [http://localhost:8081/restproject/apidoc](http://localhost:8081/restproject/apidoc)  
Les requêtes cUrl sont disponnibles dans le fichier [curl](curl.txt)

## Bonus
Implémentation de la sécurité en utilisant Spring Security et Spring Security Rest.  
 * ajout de  `compile 'org.grails.plugins:spring-security-core:3.2.0.M1'` dans le build.gradle
 * execution de la commande grails ```s2-quickstart servicerest User Role```
 * ajout de `compile "org.grails.plugins:spring-security-rest:2.0.0.M2"` dans le build.gradle
 * modification du fichier application.groovy générer précédement :
    * changement des static en intercept
    * ajout des permission sur le service de login et isFullyAuthentificated() sur le reste
    * ajout de chainMap
    * ajout d'info nécessaire pour Spring Security Rest
 * creation d'un utilisateur et d'un role dans le bootstrap /!\ utilisation de `springSecurityService.encodePassword ` pour le mot de passe sinon il n'étais pas crypté dans la bdd
 * utilisation
    * /api/login => `{"username":"user", "password":"user"}`
    * recupération de l'access_token
    * ajout de `X-Auth-Token` avec le token récupéré comme valeur dans les headers des autres requetes
    

## Problème

* Pas de rendu xml dans le cas de rendu de code (ex : 200, 404, ...) => du coup code 406
