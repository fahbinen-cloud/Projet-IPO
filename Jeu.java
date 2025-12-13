public class Jeu {

    Terrain terrain;
    int sortis = 0;
    Bille bille;
    FenetreJeu fenetre;

    /* Initialisation d'un jeu avec le terrain initial dÃ©crit dans
       le fichier [f] donnÃ© en paramÃ¨tre */
    public Jeu(String f) {
        this.terrain = new Terrain(f);
        this.bille = new Bille(1., 1., 0.1, 0.05);
        this.fenetre = new FenetreJeu(terrain);
    }

    public void tour(){
        bille.avance();
        terrain.updateBillePosition(bille);
    }

    public static void main(String[] args) {
        Jeu j = new Jeu("laby1.txt");
        j.terrain.print();
    }
}
