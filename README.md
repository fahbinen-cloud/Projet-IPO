# 🎮 Projet Jeu de Bille

Petit jeu développé en **Java** dans le cadre d’un projet universitaire.  
Le joueur contrôle une bille qui évolue sur un terrain composé de différentes cases, chacune ayant un comportement spécifique.

---

## 🧠 Principe du jeu

- Déplacer une bille sur une grille
- Interagir avec l’environnement :
  - obstacles
  - trous
  - téléporteurs
  - clés
  - portes
- Atteindre la **sortie** sans perdre la partie

Certaines zones sont **bloquées** au départ et deviennent accessibles après avoir déclenché des événements (ex : récupérer une clé).

---

## 🕹️ Gameplay

🎥 **Démonstration en vidéo**  
Une courte vidéo montrant une partie complète du jeu est disponible ici :

https://github.com/user-attachments/assets/a53e49e6-8768-4c83-a706-9eaef000884f

---

## ❌ Défaite

🖼️ **Écran de défaite**  
Voici ce qu’il se passe lorsque la bille tombe dans un trou ou échoue :
<img width="741" height="771" alt="Projet Redux" src="https://github.com/user-attachments/assets/bc4fd7fe-4560-4b33-ae44-a71d751b1205" />

---

## 🧩 Éléments du jeu

- ⬜️ **Case ordinaire** : libre
- ⬛ **Case intraversable** : mur
- 🟡 **Clé** : permet d’ouvrir une porte
- 🚪 **Porte** : bloquée tant que la clé n’est pas récupérée
- 🔴 **Trou** : défaite
- 🟠 **Téléporteur** : déplacement instantané
- 🟢 **Sortie** : victoire 🎉

---
## ✨ Remarques

Projet réalisé dans un objectif pédagogique, avec un accent sur :
- la modélisation objet
- la gestion des interactions
- la cohérence entre logique et affichage
