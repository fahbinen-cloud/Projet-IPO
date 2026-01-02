import java.util.Scanner;

// Attention : nom identique au nom de fichier, majuscules comprises
public class Trou extends CaseTraversable{
    private Jeu jeu;

    public Trou(int l, int c, Jeu jeu){
        super(l, c);
        this.jeu = jeu;
    }
    

    @Override
    public void enter(Bille b){
        super.enter(b);
        // defaite
        if (jeu != null) {
            jeu.defaite();
        }
    }
}
