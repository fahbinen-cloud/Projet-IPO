import javax.swing.*;
import java.awt.*;

public class FenetreJeu extends JPanel {
    private Terrain terrain;
    private int tailleCase = 50;
    private int hauteur, largeur;
    private JFrame frame;

    public FenetreJeu(Terrain t) {
        this.hauteur = t.getHauteur();
        this.largeur = t.getLargeur();
        this.terrain = t;

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(largeur * tailleCase, hauteur * tailleCase));

        JFrame frame = new JFrame("Donjon");
        this.frame = frame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i< this.hauteur; i++){
            for(int j = 0; j< this.largeur; j++){
                Object o = this.terrain.getCase(i,j);
                if(o instanceof CaseIntraversable){
                    g.setColor(new Color(0, 0, 0));
                    g.fillRect(j*tailleCase, i*tailleCase, tailleCase, tailleCase);
                }else if(o instanceof CaseTraversable){
                    CaseTraversable ct = (CaseTraversable) o;
                    if(ct.isEmpty()){
                        if(o instanceof CaseOrdinaire){
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(j*tailleCase, i*tailleCase, tailleCase, tailleCase);
                        }
                        if(o instanceof Sortie){
                            g.setColor(new Color(200, 0, 0, 123));
                            g.fillRect(j*tailleCase, i*tailleCase, tailleCase, tailleCase);
                        }
                    }else{
                        if(ct.getContenu() instanceof Bille){
                            g.setColor(new Color(0, 0, 255));
                            g.fillOval(j*tailleCase + 10 , i*tailleCase + 10, 30, 30);
                        }
                    }
                }
            }
        }
    }

    public void ecranFinal(int n) {
        frame.remove(this);
        JLabel label = new JLabel("Score " + n);
        label.setFont(new Font("Verdana", 1, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setSize(this.getSize());
        frame.getContentPane().add(label);
        frame.repaint();
    }
}
