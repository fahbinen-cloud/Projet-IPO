import java.util.Scanner;

// Attention : nom identique au nom de fichier, majuscules comprises
public class Sortie extends CaseTraversable{
    private Jeu jeu;

    public Sortie(int l, int c, Jeu jeu){
        super(l, c);
        this.jeu = jeu;
    }
    

    @Override
    public void enter(Bille b){
        super.enter(b);
        // victoire
        if (jeu != null) {
            jeu.victoire();
        }
    }

    @Override
    public String toString(){
        if(!this.isEmpty()){
            return this.contenu.toString("( )");
        }else{
            return "( )";
        }
    }
}
