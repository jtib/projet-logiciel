Applications possibles :

1. Bulletins de notes (générer de appréciations)
2. Bulletin de présence sur un mois
3. Bulletins météorologiques (annonce du temps selon les paramètres du temps / bulletin marine
4. Recette de cuisine (proposer des recettes selon les ingrédients disponibles)

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

Possibilité de règles pour les **BULLETINS DE PRESENCE SUR UN MOIS**

***

Possibilité de règles pour les **BULLETINS METEOROLOGIQUES**

Condition 1 (Soleil)| Condition 2 (Pluie)| Condition 3 (Neige)| Appréciation|
------------ | ------------ | ------------ | ------------ | ------------ | ------------|
<5| |  Un soleil un peu voilé.
<10| | Timides éclarcies.
<20| |  De belles éclarcies.
| 1<x<5|  Il y a de pluies fines.
| <10| |  Prenez votre parapluie en sortant.
| <20| |  Des averses sont à prévoir.
| | 1<5|  Petites chutes de neige.
| | <10| Pensez à changer les pneus hiver.

Condition 4 (Nuage)| Condition 5 (Brouillard)| Condition 6 (Vent)| Appréciation|
------------ | ------------ | ------------ | ------------ | ------------ | ------------|
 >5| | | Le ciel est quelque peu couvert.
 <10| | | Des grisailles.
 | | <10| Le vent est modéré.
 | | <20| Des rafales de vent.
 | <10 | | Des brumes de brouillard.
 | <20| | Ciel couvert, fort brouillard.
