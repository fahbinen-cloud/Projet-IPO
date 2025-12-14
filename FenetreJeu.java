import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class FenetreJeu extends JPanel implements MouseListener, MouseMotionListener {
    private Terrain terrain;
    private Bille bille;
    private int tailleCase = 50;
    private int hauteur, largeur;
    private JFrame frame;
    private double ancienX, ancienY;

    public FenetreJeu(Terrain t, Bille b) {
        this.hauteur = t.getHauteur();
        this.largeur = t.getLargeur();
        this.terrain = t;
        this.bille = b;

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(largeur * tailleCase, hauteur * tailleCase));

        JFrame frame = new JFrame("Donjon");
        this.frame = frame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.getContentPane().addMouseListener(this);
        frame.getContentPane().addMouseMotionListener(this);
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
                        if(o instanceof CaseOrdinaire){
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(j*tailleCase, i*tailleCase, tailleCase, tailleCase);
                        }
                        if(o instanceof Sortie){
                            g.setColor(new Color(200, 0, 0, 123));
                            g.fillRect(j*tailleCase, i*tailleCase, tailleCase, tailleCase);
                        }
                    }
                }
            }
        double billeX = bille.getX();
        double billeY = bille.getY();
        g.setColor(new Color(0, 0, 255));
        g.fillOval((int) (billeX*tailleCase) , (int) (billeY*tailleCase), 30, 30);
    }   
            

    /*Verifie que la case cliquait par le joueur est une case traversable, puis debloque la bille,
    si la case cliquait contient bien une bille, afin que l'on puisse commencer a deplacer la bille 
    avec la souris. Enfin garde les coordonnées de la souris pour le premier mouvement avec la souris*/
    public void mousePressed(MouseEvent e){
        Object o = this.terrain.getCase((int) Math.round((e.getY()/tailleCase)), (int) Math.round((e.getX()/tailleCase)));
        if (o instanceof CaseTraversable){
            CaseTraversable ct = (CaseTraversable) o;
            if(ct.getContenu() instanceof Bille){
                this.bille.avance = true;
                ancienX = e.getX();
                ancienY = e.getY();
            }
        }
    }


    /*Calcule la mouvement de la souris, puis change la vitesse de cette bille selon ce mouvement,
    puis verifie que cette vitesse ne depasse pas la vitesse max de 0.2, et enfin garde la position
    actuelle de la souris pour le prochain mouvement*/
    public void mouseDragged(MouseEvent e){
        if(bille.avance){
            double sx = e.getX() - ancienX;
            double sy = e.getY() - ancienY;
            this.bille.setCoord(this.bille.getX() + sx / (double)tailleCase, this.bille.getY() + sy / (double)tailleCase);

            //this.bille.avance();

            //this.bille.setVitesse(0,0);
            this.terrain.updateBillePosition(this.bille);

            /*this.bille.setVitesse(this.bille.getVx() + (0.1) * sx, this.bille.getVy() + (0.1) * sy);
                
            double v = Math.sqrt(this.bille.getVx()*this.bille.getVx() + this.bille.getVy()*this.bille.getVy());
            if(v> 0.6){
                this.bille.setVitesse(this.bille.getVx() * 0.6 /v, this.bille.getVy() * 0.6 /v);
            }*/

            ancienX = e.getX();
            ancienY = e.getY();

            this.repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {
        bille.avance = false;
        this.bille.setVitesse(0,0);
        this.terrain.updateBillePosition(this.bille);
        this.repaint();
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

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
