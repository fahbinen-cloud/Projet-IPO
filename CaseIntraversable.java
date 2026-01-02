import java.util.Scanner;

// Attention : nom identique au nom de fichier, majuscules comprises
public class CaseIntraversable extends Case{
    
    public CaseIntraversable(int l, int c){
        super(l, c);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enter(Bille b) {}

    @Override
    public void leave(Bille b) {}

    @Override
    public void touch(Bille b) {}

    @Override
    public String toString(){
        return "###";
    }

    @Override
    public boolean estTraversable() {
        return false;
    }

}
