public class Jeu {

    private Terrain terrain;
    private FenetreJeu fenetre;
    private Bille bille;

    /* Initialisation d'un jeu avec le terrain initial dÃ©crit dans
       le fichier [f] donnÃ© en paramÃ¨tre */
    public Jeu(String f) {
        this.terrain = new Terrain(f);
        this.bille = new Bille(1., 1.);
        this.fenetre = new FenetreJeu(this.terrain, this.bille);
        this.terrain.updateBillePosition(this.bille);
    }

    public void tour(){
        bille.avance();
        terrain.updateBillePosition(this.bille);
    }
    public Terrain getTerrain(){
        return this.terrain;
    }

    public FenetreJeu getFenetre(){
        return this.fenetre;
    }

    public Bille getBille(){
        return this.bille;
    }

    public static void main(String[] args) {
        Jeu j = new Jeu("laby1.txt");
        j.terrain.print();
    }
}
