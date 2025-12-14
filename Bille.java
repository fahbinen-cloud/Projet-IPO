import java.util.Scanner;
import java.lang.Math;

// Attention : nom identique au nom de fichier, majuscules comprises
public class Bille{
    private double x,y;
    private double vx,vy;
    private double dx,dy;
    boolean avance = false;

    public Bille(double x, double y){
        this.x = x;
        this.y = y;
        this.vx = 0;
        this.vy = 0;
        this.dx = 0;
        this.dy = 0;
    }

    public void avance(){
        //double vitesse = Math.sqrt(this.vx*this.vx + this.vy*this.vy);
        if (this.avance == true){
            /*this.x += this.vx;
            this.y += this.vy;*/
        }else{
            /*if(vitesse> 0.005){
                this.x += this.vx;
                this.y += this.vy;
                this.vx = this.vx * (1 - (0.005/vitesse));
                this.vy = this.vy * (1 - (0.005/vitesse));
            }

            if(vitesse > 0){
                this.dx = this.vx / vitesse;
                this.dy = this.vy / vitesse;
            }else{
                this.dx = 0;
                this.dy = 0;
            }

            else{*/
                this.vx = 0;
                this.vy = 0;
            //}
        
        }
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getVx(){
        return this.vx;
    }

    public double getVy(){
        return this.vy;
    }

    public void setVitesse(double vx, double vy){
        this.vx = vx;
        this.vy = vy;
    }

    public void setCoord(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String toString(String background){
        return background.charAt(0)+ "." + background.charAt(2);
    }
}
