import java.util.Scanner;

// Attention : nom identique au nom de fichier, majuscules comprises
public class CaseOrdinaire extends CaseTraversable{

    public CaseOrdinaire(int l, int c){
        super(l, c, null);
    }
    
    public CaseOrdinaire(int l, int c, Bille b){
        super(l, c, b);
    }

    @Override
    public String toString(){
        if(!this.isEmpty()){
            return this.contenu.toString("   ");
        }else{
            return "   ";
        }
    }
}
