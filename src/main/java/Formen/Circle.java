package Formen;
import java.math.*;
public class Circle {
    int x;
    int y;
    int radius;
    public static void main(String[] args){
   
    }
    public Circle(int x, int y, int radius){
        newCircle(x, y, radius);
    }
    static Circle newCircle(int x, int y, int radius){
        if(radius <= 0){
            Utility.error("Fehler!");
            return null;
        }
        return new Circle(x, y, radius);
    }
    static Circle clone(Circle kreis){
        return new Circle(kreis.x, kreis.y, kreis.radius);
    }
    int getX(){
        return x;
    }
    void setX(int inputx){
        x = inputx;
    }
    int getY(){
        return y;
    }
    void setY(int inputy){
        y = inputy;
    }
    int getRadius(){
        return radius;
    }
    void setRadius(int inputRadius){
        if(inputRadius != 0){
            radius = inputRadius;
        }
        Utility.error("Fehler!");
    }
    boolean contains(Circle... others){
        for (Circle kreis : others) {
            double xabstand = kreis.x - x;
            double yabstand = kreis.y - y;
            double abstand = Math.sqrt((xabstand * xabstand)+(yabstand * yabstand));
            if(abstand + kreis.radius > radius){
                return false;
            }
        }
        return true;
    }
    double size(Circle... circles){
        double ausgabe = 0;
        for(Circle kreis : circles){
            ausgabe =+ (kreis.radius * kreis.radius)*Math.PI;
        }
        return ausgabe;
    }
    String toString(int x, int y, int radius){
        return "(" + x + "," + y + ")," + radius;
    }
    public void performAction(CircleAction action){
        switch (action) {
            case UP:
                y += 10;
                break;
            case DOWN:
                y -= 10;
                break;
            case RIGHT:
                x += 10;
                break;
            case LEFT:
                x -= 10;
                break;
            case BIGGER:
                radius += 10;
                break;
            case SMALLER:
            if(radius > 10){
                radius -= 10;
            }
            else{
                Utility.error("Fehler!");
            }
            default:
                break;
        }
    }
}
