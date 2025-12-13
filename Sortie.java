import java.util.Scanner;

// Attention : nom identique au nom de fichier, majuscules comprises
public class Sortie extends CaseTraversable{

    public Sortie(int l, int c){
        super(l, c, null);
    }
    
    public Sortie(int l, int c, Bille b){
        super(l, c, b);
    }

    /*@Override
    public void enter(Bille b){
        b.sort();
        this.contenu = null;
    }*/

    @Override
    public String toString(){
        if(!this.isEmpty()){
            return this.contenu.toString("( )");
        }else{
            return "( )";
        }
    }
}
