Applications possibles :

1. Bulletins de notes (générer de appréciations)
2. Bulletins météorologiques (annonce du temps selon les paramètres du temps / bulletin marine
3. (Eventuellement) Recette de cuisine (proposer des recettes selon les ingrédients disponibles)
4. (Eventuellement) Bulletin de présence sur un mois

***

Possibilité de règles pour les **BULLETINS DE NOTES**

Condition (moyenne entre x,y)| Appréciation
------------ | ------------
[0,5[ | Mettez vous au travail !
[5,10[ | Travaillez plus !
[10,13[ | Résultats assez biens mais encore justes. Travaillez et gardez espoir.
[13,15[ | Résultats satisfaisants. Bon travail.
[15,17[ | Très bons résultats ! Continuez ainsi.
[17,19[ | Excellents résultats !
20 | Parfait. Rien à redire.
m < 15 | Vous pouvez encore progresser
m >= 15| Continuez ainsi

Règles plus sophistiquées

Condition | Appréciation
------------ | ------------
si m=10 et les notes n1, n2 sont égales ou croissantes | Résultats encourageants
si m=10 et les notes n1, n2 sont décroissantes|Résultats trop justes
si n1=n2 et n1 > 7| Résultats stables
si n1=n2 et n1 <= 7| Résultats désespérement stables
si n2 < n1|Ne vous relâchez pas
si n2 > n1 et ecart <= 2| En légère progression
si n2 > n1 et ecart > 2|En nette progression

Appréciation générale

Condition (moyenne générale)| Appréciation
------------ | ------------
[0,5[ | Des résultats décevants, c'est bien dommage. Reprenez confiance.
[5,10[ | L'élève est capable de mieux.
[10,13[ | Ensemble correct. Continuez à travailler, vos efforts seront récompensés.
[13,15[ | Le niveau de l'élève est bon, la suite est très encourageante.
[15,17[ | Très bon résultats, élève sérieux, le travail est très satisfaisant.
[17,19[ | Excellents résultats !
20 | Bilan parfait, élève exemplaire tout à fait exceptionnel !

***

**Condition pour les bulletins météorologiques**

**Moyenne sur une journée**

**Conditions simples**

Notes sur les conditions simples :

Temperature moyenne (en degre Celcius) : ([-15,0[); ([0,10[); ([10,20[); ([20,30[)

Precipitation (en %) : (inférieur à 40); (supérieur ou égal à 40)

Vent (en km/h) : (inférieur à 2); (inférieur à 30); (inférieur à 75); (supérieur ou égal à 75)

Temperature moyenne (en degre Celcius)| Precipitation (en %)| Vent (en km/h)|  Appreciation
------------ | ------------ | ------------ | ------------ 
[-15,0[ | < 40 | < 2| Faibles chances d'averses et ciel calme. Attention au gel.
[-15,0[ | < 40 | < 30| De jolies brises par un temps sec et glacial.
[-15,0[ | < 40 | < 75| Attention aux coups de vent glaciaux, combinés à des possibilités d'averses isolées. 
[-15,0[ | < 40 | >= 75| Temps glacial. Peu de chance d'averses mais un vent d'ouragan ! Ne pas sortir.
[-15,0[ | >= 40 | < 2 | Temps glacial et calme, mais des averses en vue.
[-15,0[ | >= 40 | < 30| La poussière est soulevée par le vent froid. Plusieurs averses.
[-15,0[ | >= 40 | < 75| Il sera pénible d'avancer en grelottant dans le vent et la pluie.
[-15,0[ | >= 40 | >= 75| Ouragan ! Temps glacé ! Des averses ! Ô rage ! Ô désespoir...
[0,10[ | < 40 | < 2| Froid et sec mais pas glacial. La fumée monte en ligne droite.
[0,10[ | < 40 | < 30| Les branches remuent sous la brise froide, mais le temps n'est pas mouillé.
[0,10[ | < 40 | < 75| De petites branches peuvent vous tomber sur la tête, même si vous avez prévu un bonnet.
[0,10[ | < 40 | >= 75| Il fait un peu froid et sec, mais l'ouragan vous interdit de sortir.
[0,10[ | >= 40 | < 2 | Temps calme, paisible et frais, prévoyez juste un parapluie.
[0,10[ | >= 40 | < 30| Des brises fraîches, peut-être accompagnée par une pluie plus ou moins grande.
[0,10[ | >= 40 | < 75| De petites branches mouillées peuvent vous tomber sur la tête et tremper votre chapeau.
[0,10[ | >= 40 | >= 75| Frais. Des vents violents et une pluie pouvant causer de gros dégâts.
[10,20[ | < 40 | < 2| Il fait beau, il n'y pas de vent ni de risque de pluie ! Bel temps pour sortir.
[10,20[ | < 40 | < 30| Un beau temps avec une brise légère et douce, ni chaude ni froide. Pourquoi ne pas sortir ?
[10,20[ | < 40 | < 75| Beau temps avec peu de chance de pluie, seulement attention aux pots de fleur qui peuvent tomber.
[10,20[ | < 40 | >= 75| Malgré un ciel beau et éclairé, il y a des risques que vous soyez emporté par l'ouragan.
[10,20[ | >= 40 | < 2 | Pas de vent, il fait doux. Prévoyez juste un parapluie.
[10,20[ | >= 40 | < 30| Des risques de pluies soutenus et de faibles brises. Mais il fait doux.
[10,20[ | >= 40 | < 75| Doux, humide, beaucoup de vent...il est préférable de bien prendre ses précautions en sortant.
[10,20[ | >= 40 | >= 75| La température est agréable, mais ni l'ouragan ni les averses soutenues encouragent à sortir.
[20,30[ | < 40 | < 2| Pas vraiment de risque de pluie ni de vent, un T-shirt peut être amplement suffisant comme équipement.
[20,30[ | < 40 | < 30| Un peu de vent, mais vous n'avez pas à prendre votre parapluie, sauf pour se protéger contre les UV.
[20,30[ | < 40 | < 75| Chaud et peu de risque de pluie, mais un vent très fort...
[20,30[ | < 40 | >= 75| Même s'il fait chaud et beau, vous allez être emporté par l'ouragan.
[20,30[ | >= 40 | < 2 | Chaud, humide, des risques de pluie, mais pas une poussière ne bouge.
[20,30[ | >= 40 | < 30| La chaleur et la pluie peuvent être quelque peu incomfortable, mais vous aurez droit à quelques brises.
[20,30[ | >= 40 | < 75| Vous pouvez vous habiller léger pour aujourd'hui. Mais les risques de pluie sont grands et il y a un vent très fort.
[20,30[ | >= 40 | >= 75| Il fait plutôt chaud, mais ce n'est pas vraiment le moment idéal pour sortir...vous seriez la cible de l'ouragan et de l'orage.

**Conditions Composees**

Temperature max - min | Appreciation
------------ | ------------ 
[0,5[ | La température est très stable aujourd'hui
[5,10[ | Il y a quelques variations de températures au cours de la journée, mais rien de très important.
[10,15[ | D'importantes variations de température aujourd'hui. Faites-y attention.
[15,20[ | Les changements de températures sont très importants, prévoyez des vêtements de change.
[20,25[ | Des variations de températures plus qu'importantes. Vous valsez entre l'hiver et l'été en l'espace d'une journée.
