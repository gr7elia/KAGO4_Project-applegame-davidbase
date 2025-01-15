package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.*;

public class Ananas extends GraphicalObject {

    //Attribute
    private double speed;

    // Referenzen
    private Player player01;
    private ProgramController pc;

    public Ananas(double x, double y, Player player01, ProgramController pc){
        this.x = x;
        this.y = y;
        speed = 150;
        radius = 30;
        this.player01 = player01;
        this.pc = pc;
        this.setNewImage("src/main/resources/graphic/islammakhachev.png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(this.getMyImage(),x,y);
        /*drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);

        drawTool.setLineWidth(3);
        drawTool.drawLine(x,y-radius, x,y-1.3*radius);
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledPolygon(x,y-radius, x+0.2*radius,y-1.4*radius, x+0.6*radius,y-1.5*radius, x+0.8*radius,y-1.4*radius);*/
    }

    @Override
    public void update(double dt) {
        //TODO 01 Eine Ananas soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).

        if (y-radius < 1000) {y += speed*dt;} else {jumpBack(); player01.decreasePoints(1);}
        //if (checkAndHandleCollision(player01)) {jumpBack();}
    }

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Ananas-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.

    public void jumpBack(){
        y = -2*radius;
        x = radius + Math.random()*(1000-radius);
    }

    public double getY(){return y;}
    public double getAnanasRadius(){return radius;}
}
