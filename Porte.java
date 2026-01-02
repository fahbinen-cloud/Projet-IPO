import java.util.Scanner;
import java.awt.Color;

public class Porte extends Case {
    private int id;
    private boolean ouverte = false;
    protected Bille contenu;

    public Porte(int l, int c, int id) {
        super(l, c);
        this.id = id;
    }

    public void ouvrir() {
       this. ouverte = true;
    }

    @Override
    public boolean estTraversable() {
        return this.ouverte;
    }

    public Color getCouleur() {
        if (this.ouverte){
            return Color.LIGHT_GRAY;
        }
        return Color.BLACK;
    }

    @Override
    public boolean isEmpty() {
        return this.contenu == null;
    }

    @Override
    public void enter(Bille b) {
        if(this.ouverte){
            this.contenu = b;
        }
    }

    @Override
    public void leave(Bille b) {
        if (this.contenu == b) {
            this.contenu = null;
        }
    }

    @Override
    public void touch(Bille b) {}

    public int getId() {
        return id;
    }
}
