import java.util.Scanner;

// Attention : nom identique au nom de fichier, majuscules comprises
abstract class Case{
    public final int lig;
    public final int col;
    
    public Case(int l, int c){
        this.lig = l;
        this.col = c;
    }

    public int getLigne(){ 
        return lig; 
    }
    public int getColonne(){ 
        return col; 
    }

    abstract public boolean isEmpty();
    abstract public void enter(Bille b);
    abstract public void leave(Bille b);
    abstract public void touch(Bille b);
    abstract boolean estTraversable();
}
