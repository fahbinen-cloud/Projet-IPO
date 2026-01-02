import java.util.Scanner;

// Attention : nom identique au nom de fichier, majuscules comprises
public class CaseTraversable extends Case{
    protected Bille contenu;

    public CaseTraversable(int l, int c) {
        super(l, c);
        this.contenu = null;
    }
    
    public CaseTraversable(int l, int c, Bille b){
        super(l, c);
        this.contenu = b;
    }

    @Override
    public boolean isEmpty() {
        return contenu == null;
    }

    @Override
    public void enter(Bille b) {
        this.contenu = b;
    }

    @Override
    public void leave(Bille b) {
        if (this.contenu == b) {
            this.contenu = null;
        }
    }

    @Override
    public void touch(Bille b) {}


    public Bille getContenu(){
        return this.contenu;
    }

    public void setContenu(Bille b){
        this.contenu = b;
    }

    @Override
    public boolean estTraversable() {
        return true;
    }
}
