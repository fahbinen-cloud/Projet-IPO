import java.util.Scanner;
import java.lang.Math;

// Attention : nom identique au nom de fichier, majuscules comprises
public class Bille{
    private double x,y;
    private double vx,vy;
    private double dx,dy;
    private double vitesse;

    public Bille(double x, double y, double vx, double vy){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.vitesse = Math.sqrt(this.vx*this.vx + this.vy*this.vy);
        this.dx = vx / this.vitesse;
        this.dy = vy / this.vitesse;
    }

    public void avance(){
        this.x += this.vx;
        this.y += this.vy;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public String toString(String background){
        return background.charAt(0)+ "." + background.charAt(2);
    }
}
