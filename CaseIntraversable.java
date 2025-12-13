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
    public void enter(Bille b) {
        //touch(b);
    }

    @Override
    public void leave(Bille b) {}

    @Override
    public void touch(Bille b) {
        //b.rebond();
    }

    @Override
    public String toString(){
        return "###";
    }

}
