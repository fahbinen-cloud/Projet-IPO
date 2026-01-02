import java.util.Scanner;
import java.lang.Math;

// Attention : nom identique au nom de fichier, majuscules comprises
public class Bille{
    private double x,y;
    private double vx,vy;
    private Jeu jeu;
    private double rayon = 0.3;
    boolean avancer = false;

    public Bille(double x, double y, Jeu jeu){
        this.x = x;
        this.y = y;
        this.vx = 0;
        this.vy = 0;
        this.jeu = jeu;
    }

    public void avance() {
        this.x += this.vx;
        this.y += this.vy;

        gererCollisions();

        double v = vitesseAbsolue();
        if (v > 0) {
            double dx = vx / v;
            double dy = vy / v;
            double nouvelleVitesse = Math.max(0, v - 0.005);
            vx = dx * nouvelleVitesse;
            vy = dy * nouvelleVitesse;
        }

        // vitesse max
        if (v > 0.2) {
            vx = vx * 0.2 / v;
            vy = vy * 0.2 / v;
        }
    }

    public void gererCollisions() {
        Terrain terrain = jeu.getTerrain();
        int colonne = (int) Math.floor(x);
        int ligne = (int) Math.floor(y);
        
        // vérifier les collisions avec les murs
        // collision avec mur gauche
        if (x - rayon < colonne && colonne > 0) {
            Case caseGauche = terrain.getCase(ligne, colonne-1);
            if (caseGauche != null && caseGauche.estTraversable() == false && vx < 0) {
                vx = -vx * 0.8; // Rebond avec perte d'énergie
                x = colonne + rayon; // Corriger la position
            }
        }
        
        // collision avec mur droite
        if (x + rayon > colonne + 1 && colonne < terrain.getLargeur() - 1) {
            Case caseDroite = terrain.getCase(ligne, colonne+1);
            if (caseDroite != null && caseDroite.estTraversable() == false && vx > 0) {
                vx = -vx * 0.8;
                x = colonne + 1 - rayon;
            }
        }
        
        // Collision avec mur haut
        if (y - rayon < ligne && ligne > 0) {
            Case caseHaut = terrain.getCase(ligne-1, colonne);
            if (caseHaut != null && caseHaut.estTraversable() == false && vy < 0) {
                vy = -vy * 0.8;
                y = ligne + rayon;
            }
        }
        
        // Collision avec mur bas
        if (y + rayon > ligne + 1 && ligne < terrain.getHauteur() - 1) {
            Case caseBas = terrain.getCase(ligne+1, colonne);
            if (caseBas != null && caseBas.estTraversable() == false && vy > 0) {
                vy = -vy * 0.8;
                y = ligne + 1 - rayon;
            }
        }
        // verifier que la bille est bien dans les limites du terrain
        x = Math.max(rayon, Math.min(x, terrain.getLargeur() - rayon));
        y = Math.max(rayon, Math.min(y, terrain.getHauteur() - rayon));
    }



    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getVx(){
        return this.vx;
    }

    public double getVy(){
        return this.vy;
    }
    public double getRayon() { return rayon; }

    public void setVitesse(double vx, double vy){
        this.vx = vx;
        this.vy = vy;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setCoord(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double vitesseAbsolue() {
        return Math.sqrt(vx * vx + vy * vy);
    }

    public String toString(String background){
        return background.charAt(0)+ "." + background.charAt(2);
    }
}
