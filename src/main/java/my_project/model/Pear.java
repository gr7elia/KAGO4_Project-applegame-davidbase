package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Pear extends GraphicalObject {

    //Attribute
    private double speed;

    public Pear(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 35;
        height = 50;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y+0.4*height,width,0.4*height);
        drawTool.drawFilledPolygon(x+0.3*width,y, x,y+0.4*height, x+width,y+0.4*height, x+0.7*width,y);
        drawTool.drawFilledPolygon(x,y+0.8*height, x+width,y+0.8*height, x+0.8*width,y+height, x+0.2*width,y+height);

        drawTool.setCurrentColor(0,0,0,255);
        drawTool.setLineWidth(3);
        drawTool.drawLine(x+0.5*width,y,x+0.5*width,y-0.2*height);

        //drawTool.setCurrentColor(0,0,0,255);
        //drawTool.drawRectangle(x,y+0.5*height,width,0.5*height);
        //drawTool.drawPolygon(x+0.3*width,y, x,y+0.5*height, x+width,y+0.5*height, (x+width)-0.3*width,y);

    }

    @Override
    public void update(double dt) {
        //TODO 03 Eine Birne soll von oben herab fallen. Sobald sie unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 04).
        if (y < 1000){ y += speed*dt; } else {jumpBack();}
    }

    //TODO 04 Lege eine Methode jumpBack() an, die bei Aufruf das Pear-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
    public void jumpBack(){
        y = -2*radius;
        x = Math.random()*(1000-width);
    }
}

