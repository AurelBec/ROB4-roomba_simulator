MOD : 17/04/2017 - 12:15
  _____                       _           
 |  __ \                     | |          
 | |__) |___   ___  _ __ ___ | |__   __ _ 
 |  _  // _ \ / _ \| '_ ` _ \| '_ \ / _` |
 | | \ \ (_) | (_) | | | | | | |_) | (_| |
 |_|  \_\___/ \___/|_| |_| |_|_.__/ \__,_|


INTRODUCTION
------------------------
L'équipe : Aurélien BEC et Julien Martin (ROB4)

Le but de ce projet est d'implementer une simulation de robot autonome en langage oriené objet, JAVA.
Pour cela, une classe Main permet de lancer la simulation.
Celle-ci ouvre une fenetre graphique et fait interagir un robot autonome.



LE PROJET
------------------------

LE ROOMBA
--------------
Le robot simulé, Roomba, possède plusieurs capteurs et actionneurs et un comportement.
Les actionneurs sont aux nombres de 4, 2 moteurs et 2 roues, et on ne souhaite pas les modifier.
Les capteurs peuvent être de plusieurs types laissés libres à l'utilisateur de les implementer. Ils doivent être placés selon un R et THETA défini sur le robot, et doivent contenir une méthode isActive() qui déterminera si le capteur est actif ou non.
Le comportement peut lui aussi être modifier. Il se comporte d'une méthode update() qui prend en parametre un EVENT. L'utilisateur n'a plus qu'a definir les différentes réactions souhaitées aux différents EVENT.


LES OBSTACLES
--------------
Ils sont au nombre de 2 : Les taches et les obstacles.
En créer est facile, il suffit de leur définir une forme ainsi qu'une methode capable de préciser si un point (x,y) se trouve dans l'obstacle ou non.



CONCLUSION
------------------------
Le cahier des charges nous semble respecté, nous avons bien terminé le simulateur, et il est possible de rajouter des nouveaux capteurs, ainsi que des comportements.



DOCUMENTATION
------------------------
La documentation du projet peut etre trouvée sous forme JAVADOC dans le dossier /doc du projet.
Pour un affichage friendly, on peut ouvrir le fichier index.html (../doc/index.html) dans un navigateur internet.