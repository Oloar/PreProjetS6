### Objectifs :
Programmer une maquette de logiciel de jeu, sur un jeu très simple. Les objectifs de cette phase sont les suivants :

- Prendre conscience, à une échelle réduite, de l'essentiel des problèmes que vous rencontrerez dans la suite du projet.
- Identifier ceux d'entre eux qui sont indépendants du jeu (et qui se poseront à nouveau plus tard).
- Aider à définir le planning de la suite du projet et la répartition des "forces" entre les différentes parties.
- Expérimenter le travail dans votre groupe et vérifier que vous vous comprenez bien. 
- Disposer d'une maquette sur laquelle vous pourrez, pendant toute la durée du projet, tester vos idées et expérimenter de nouvelles pistes : quelle charge de travail demanderait leur réalisation, quel intérêt elles pourront présenter dans le logiciel final.

### Regles du jeu :
C'est un jeu à 2 joueurs. Le but du jeu est d'obliger l'autre joueur à jouer le coup perdant. 

**Déroulement de la partie :**

1. L'un des deux joueurs commence. 
2. Ensuite, chacun joue à tour de rôle et est obligé de jouer (passer son tour est interdit) jusqu'à ce qu'un des joueurs joue le coup perdant. 
3. La partie est alors terminée, ce dernier joueur est déclaré perdant et l'autre gagnant.

**Description des coups autorisés et du coup perdant :**

- Description arithmétique. La gaufre est représentée par un entier g de la forme 2a3b où a et b sont des entiers positifs. Un coup est un diviseur 2i3j de g qui ne soit pas multiple d'un coup déjà joué. Le coup perdant est 1.
- Description géométrique. La gaufre est représentée par une matrice (0..a, 0..b). Un coup (qui consiste à mordre dans la gaufre) est un couple (i, j) avec 1≤i≤a et 1≤j≤b. Après qu'un coup (i; j) ait été joué, la partie de la gaufre telle que  (i'≥i et j'≥j) disparaît. Le coup perdant (la case empoisonnée) est (0, 0).
La taille standard de la gaufre est 6×8 (a=5, b=7).


### ToDo :
Votre maquette doit comporter au moins les éléments suivants :

- jouer à deux joueurs humains, jouer contre l'ordinateur
- IHM :
    1. ~~affichage lisible du déroulement du jeu~~
    2. ~~regroupement de toutes les informations importantes pour l'utilisateur :~~
        1. ~~état de la gaufre~~
        2. ~~joueur ayant la main~~
    4. ~~interface ergonomique de saisie du coup à jouer et d'accès aux fonctionnalités~~
- IA :
    1. ~~3 niveaux pour l'IA :~~
        1. ~~jeu aléatoire~~
        2. ~~choix d'un coup non perdant (s'il existe) ou gagnant (s'il existe)~~
        3. ~~Stratégie gagnante, laisse jouer.~~
- fonctionnalités :
    1. démarrer une nouvelle partie (en abandonnant l'état courant) **(Fait côté moteur) TODO: lien vers IHM**
    2. fonctions annuler et rejouer (conservation de l'historique de tous les coups) **(Fait côté moteur) TODO: lien vers IHM**
    3. sauvegarder et restaurer une partie et son historique complet **(Fait côté moteur) TODO: lien vers IHM**

Vous devrez faire une mini-démo de votre maquette avant le choix du sujet pour le reste du projet.

### Reflexions :
Quelques idées de ce que vous pouvez ajouter au cahier des charges minimal. 
- possibilité pour le joueur d'abandonner en cours de partie
- fonction *démonstration*
- aide(s) au joueur : tutoriel, suggestion d'un coup
- ~~possibilité de choisir la taille de la gaufre~~
- possibilité d'enchaîner les parties (de faire un match)
- stockage des meilleurs scores, classement
- navigation directe dans l'historique
- min-max seuillé, élagage alpha-béta
- ...
