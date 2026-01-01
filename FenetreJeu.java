import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class FenetreJeu extends JPanel implements MouseListener, MouseMotionListener {
    private Jeu jeu;
    private Bille bille; 
    private int tailleCase = 50;
    private int hauteur, largeur;
    private JFrame frame;
    private double ancienX, ancienY;

    public FenetreJeu(Jeu jeu) {
        this.jeu = jeu;
        this.bille = jeu.getBille();  // initialisation ici
        this.hauteur = jeu.getTerrain().getHauteur();
        this.largeur = jeu.getTerrain().getLargeur();

        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(largeur * tailleCase, hauteur * tailleCase));

        frame = new JFrame("Redux - Projet ORABI Zahra && NDIAYE Adama Fahbine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.getContentPane().addMouseListener(this);
        frame.getContentPane().addMouseMotionListener(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Terrain t = jeu.getTerrain();
        for(int i = 0; i < hauteur; i++){
            for(int j = 0; j < largeur; j++){
                Case c = t.getCase(i,j);
                Color couleur;

                if(c instanceof CaseIntraversable){
                    couleur = Color.BLACK;
                } else if(c instanceof Sortie){
                    couleur = Color.GREEN;
                } else {
                    couleur = Color.LIGHT_GRAY;
                }

                g.setColor(couleur);
                g.fillRect(j * tailleCase, i * tailleCase, tailleCase, tailleCase);

                // Bordures des cases
                g.setColor(Color.DARK_GRAY);
                g.drawRect(j * tailleCase, i * tailleCase, tailleCase, tailleCase);
            }
        }

        // Bille
        int x = (int) (bille.getX() * tailleCase);
        int y = (int) (bille.getY() * tailleCase);
        int rayonPixels = (int) (bille.getRayon() * tailleCase);
        
        // Dessiner la bille (centre aux coordonnées, rayon ajusté)
        g.setColor(Color.RED);
        g.fillOval(x - rayonPixels, y - rayonPixels, rayonPixels * 2, rayonPixels * 2);
        
        // Contour de la bille
        g.setColor(Color.DARK_GRAY);
        g.drawOval(x - rayonPixels, y - rayonPixels, rayonPixels * 2, rayonPixels * 2);
        
        // Indicateur de direction (si la bille bouge)
        double vitesse = bille.vitesseAbsolue();
        if (vitesse > 0.01) {
            g.setColor(Color.YELLOW);
            int x2 = x + (int)(bille.getVx() * tailleCase * 5);
            int y2 = y + (int)(bille.getVy() * tailleCase * 5);
            g.drawLine(x, y, x2, y2);
        }
        // Info
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("Cliquez et glissez pour deplacer la bille", 10, 20);
        g.drawString(String.format("Vitesse: %.3f", bille.vitesseAbsolue()), 10, 40);
    }

    @Override
    public void mousePressed(MouseEvent e){
        Object o = jeu.getTerrain().getCase(e.getY()/tailleCase, e.getX()/tailleCase);
        if(o instanceof CaseTraversable){
            CaseTraversable ct = (CaseTraversable)o;
            if(ct.getContenu() instanceof Bille){
                bille.avancer = true;
                ancienX = e.getX();
                ancienY = e.getY();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e){
        if(!bille.avancer) return;

        double sx = e.getX() - ancienX;
        double sy = e.getY() - ancienY;

        bille.setVitesse(bille.getVx() + 0.001*sx, bille.getVy() + 0.001*sy);
        double v = bille.vitesseAbsolue();
        if(v > 0.2){
            bille.setVitesse(bille.getVx() * 0.2 / v, bille.getVy() * 0.2 / v);
        }

        ancienX = e.getX();
        ancienY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e){
        bille.avancer = false;
    }

    @Override public void mouseEntered(MouseEvent e){}
    @Override public void mouseExited(MouseEvent e){}
    @Override public void mouseClicked(MouseEvent e){}
    @Override public void mouseMoved(MouseEvent e){}

    public void afficherVictoire(){
        JOptionPane.showMessageDialog(frame,
            "Bravo! Vous avez atteint la sortie!\n",
            "Victoire!", JOptionPane.INFORMATION_MESSAGE);
    }
}