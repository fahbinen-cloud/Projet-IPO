import java.util.Scanner;

// Attention : nom identique au nom de fichier, majuscules comprises
public class Cle extends CaseTraversable{
    private Jeu jeu;
    private int idPorte;

    public Cle(int l, int c, Jeu jeu,  int idPorte){
        super(l, c);
        this.jeu = jeu;
        this.idPorte = idPorte;
    }
    

    @Override
    public void enter(Bille b){
        super.enter(b);
        jeu.ouvrirPorte(idPorte);
    }

}
