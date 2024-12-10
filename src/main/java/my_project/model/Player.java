package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    private double speed;
    private int points = 9;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;

    //Referenzen
    private Apple apple01;
    private Pear pear01;

    public Player(double x, double y, Apple apple01, Pear pear01){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 80;
        height = 40;

        this.keyToGoLeft    = KeyEvent.VK_A;
        this.keyToGoRight   = KeyEvent.VK_D;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links

        this.apple01 = apple01;
        this.pear01 = pear01;
    }

    @Override
    public void draw(DrawTool drawTool) {
        //drawTool.setCurrentColor(157,152,3,255);
        drawTool.setCurrentColor(160,117,88,255);
        drawTool.drawFilledRectangle(x,y,width,height);

        drawTool.setLineWidth(4);
        drawTool.drawLine(x,y, x-0.1*width,y+0.9*height);
        drawTool.drawLine(x+width,y, x+1.1*width,y+0.9*height);

        drawTool.setCurrentColor(160,117,88,155);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
        //TODO 05 Überarbeiten Sie die Update-Methode derart, dass ein Player-Objekt nicht den Bildschirm verlassen kann und immer zu sehen ist.
        if(direction == 0){
            if (x <= (1000-width-19)){x = x + speed*dt;}else{System.out.println("X: "+x);}
        }
        if(direction == 2){
            if (x >= 0){x = x - speed*dt;}
        }
        checkApplesPosition(apple01);
        checkPearsPosition(pear01);
    }

    public void checkApplesPosition(Apple a){
        if (a.getY()+a.getApplesRadius() > (1029 - height) && a.getY()-a.getApplesRadius() < (1029)){
            if (collidesWith(a)){ points+=1; }
        } else if (a.getY() - a.getApplesRadius() > 1030 ){
            points -= 1;
        }
    }

    public void checkPearsPosition(Pear p){
        if (p.getY()+p.getHeight() > (1029 - height) && p.getY() < (1029)){
            if (collidesWith(p)){ points+=1; }
        } else if (p.getY() > 1030){
            points -= 1;
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }

    public int getPoints(){return points;}
}
