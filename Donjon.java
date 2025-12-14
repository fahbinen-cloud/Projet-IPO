import javax.swing.Timer;

public class Donjon {
    public static void main(String[] args) {
        int tempo = 10;
        Jeu jeu = new Jeu("laby1.txt");
        FenetreJeu graphic = jeu.getFenetre();
        Timer timer = new Timer(tempo, e -> {
            jeu.tour();
            graphic.repaint();
            //if (jeu.partieFinie()) { graphic.ecranFinal(jeu.sortis); }
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}
