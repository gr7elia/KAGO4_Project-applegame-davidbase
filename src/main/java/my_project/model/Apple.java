package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.*;

public class Apple extends GraphicalObject {

    //Attribute
    private double speed;

    // Referenzen
    private Player player01;
    private ProgramController pc;

    public Apple(double x, double y, Player player01, ProgramController pc){
        this.x = x;
        this.y = y;
        speed = 150;
        radius = 30;
        this.player01 = player01;
        this.pc = pc;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);

        drawTool.setLineWidth(3);
        drawTool.drawLine(x,y-radius, x,y-1.3*radius);
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledPolygon(x,y-radius, x+0.2*radius,y-1.4*radius, x+0.6*radius,y-1.5*radius, x+0.8*radius,y-1.4*radius);
    }

    @Override
    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).

        if (y < 1000) {y += speed*dt;} else {jumpBack(false);}
        if (checkAndHandleCollision(player01)) {jumpBack(true);}
    }

    //#TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
    public boolean checkAndHandleCollision(Player p){
        if (collidesWith(p)){
            return true;
        }
        return false;
    }

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Apple-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.

    public void jumpBack(boolean collided){
        y = -2*radius;
        x = radius + Math.random()*(1000-radius);
        //if (! collided){ pC.decreasePoints(); }
    }

    public double getY(){return y;}
    public double getApplesRadius(){return radius;}
}
