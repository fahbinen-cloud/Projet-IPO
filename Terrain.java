import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Terrain {

    private int hauteur, largeur;
    private Case[][] carte;
    private Jeu jeu;
    private Map<Integer, Porte> portes = new HashMap<>();

    /* Initialisation d'un terrain Ã  partir de la description donnÃ©e par
       un fichier texte. Format du fichier de description :
       - hauteur et largeur sur la premiÃ¨re ligne
       - puis dessin du terrain (un caractÃ¨re == une case) avec le codage
         suivant
         '#' pour un mur
         ' ' (espace) pour une case libre
         'O' pour une sortie
         'T' pour une teleporteur
         'D' pour un trou
         'C' pour une clé
         'P' pour une porte
    */
    public Terrain(String file, Jeu jeu) {
        this.jeu = jeu;
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            this.hauteur = sc.nextInt();
            this.largeur = sc.nextInt();
            sc.nextLine();
            this.carte = new Case[hauteur][largeur];

            for (int l=0; l<hauteur; l++) {
                String line = sc.nextLine();
                for (int c=0; c<largeur; c++) {
                    Case cc;
                    Character ch = line.charAt(c);
                    switch (ch) {
                        case '#': cc = new CaseIntraversable(l, c); break;
                        case ' ': cc = new CaseOrdinaire(l, c); break;
                        case 'O': cc = new Sortie(l, c, this.jeu); break;
                        case 'T': cc = new Teleporte(l, c); break;
                        case 'D': cc = new Trou(l, c, this.jeu); break;
                        case 'C': cc = new Cle(l, c, this.jeu, 1); break;
                        case 'P': Porte p = new Porte(l, c, 1);
                                  portes.put(1, p);
                                  cc = p; 
                                  break;
                        default:  cc = null; break;
                    }
                    carte[l][c] = cc;
                }
            }
            sc.close();
        }
        catch (IOException e) { e.printStackTrace(); }
    }
    
    public void print(){
        for(int i = 0; i< hauteur; i++){
            for(int y = 0; y< largeur; y++){
                System.out.print(this.carte[i][y].toString());
            }
            System.out.println("");
        }
    }

    public int getHauteur(){
        return this.hauteur;
    }

    public int getLargeur(){
        return this.largeur;
    }

    public Case getCase(int i, int j){
        return carte[i][j];
    }

    public Porte getPorte(int id) {
        return portes.get(id);
    }


    public void updateBillePosition(Bille b) {
        int i = (int) (b.getY() );
        int j = (int) (b.getX() );

        for (int r = 0; r < hauteur; r++) {
            for (int c = 0; c < largeur; c++) {
                if (carte[r][c] instanceof CaseTraversable) {
                    ((CaseTraversable) carte[r][c]).leave(b);
                }
            }
        }

        if (i >= 0 && i < hauteur && j >= 0 && j < largeur && carte[i][j] instanceof Teleporte) {
            b.setPosition(10.5, 4.5);

            i = (int) b.getY();
            j = (int) b.getX();
        }

        if (i >= 0 && i < hauteur && j >= 0 && j < largeur && carte[i][j] instanceof CaseTraversable) {
            ((CaseTraversable) carte[i][j]).enter(b);
        }

    }

}

