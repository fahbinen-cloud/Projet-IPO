public class Jeu {

    private Terrain terrain;
    private FenetreJeu fenetre;
    private Bille bille;
    private boolean jeuEnCours = true;

    /* Initialisation d'un jeu avec le terrain initial dÃ©crit dans
       le fichier [f] donnÃ© en paramÃ¨tre */
    public Jeu(String f) {
        this.terrain = new Terrain(f, this);
        this.bille = new Bille(1.5, 1.5, this);
        this.fenetre = new FenetreJeu(this);
        this.terrain.updateBillePosition(this.bille);
    }

    public void tour(){
        if (jeuEnCours) {
            bille.avance();
            terrain.updateBillePosition(bille);
            fenetre.repaint();
        }
    }


    public void victoire() {
        if (jeuEnCours) {
            jeuEnCours = false;
            Donjon.arreterTimer();
            fenetre.afficherVictoire();
        }
    }

    public void defaite() {
        if (jeuEnCours) {
            jeuEnCours = false;
            Donjon.arreterTimer();
            fenetre.afficherDefaite();
        }
    }

    public void ouvrirPorte(int id) {
        Porte p = terrain.getPorte(id);
        if (p != null) {
            p.ouvrir();
            fenetre.repaint();
        }
    }

    public boolean isJeuEnCours() {
        return jeuEnCours;
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
