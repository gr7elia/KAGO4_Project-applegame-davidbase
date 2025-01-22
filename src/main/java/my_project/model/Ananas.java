package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.*;

public class Ananas extends Fruit {

    //Attribute
    private double speed;

    // Referenzen
    private Player player01;
    private ProgramController pc;

    public Ananas(double x, double y, Player player01, ProgramController pc){
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

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Ananas-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.

    public double getAnanasRadius(){return radius;}
}
