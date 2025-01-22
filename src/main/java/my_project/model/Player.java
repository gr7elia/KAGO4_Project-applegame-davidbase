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

    public Player(double x, double y){
        this.x = x;
        this.y = y;
        speed = 300;
        width = 80;
        height = 40;

        this.keyToGoLeft    = KeyEvent.VK_A;
        this.keyToGoRight   = KeyEvent.VK_D;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
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

        drawTool.setCurrentColor(0,0,0,255);
        if ( points > 0 && points < 10 ){
            drawTool.drawText(20,40, String.valueOf(points) );
        } else if (points > 9){
            drawTool.drawText(20,40, "YOU WIN :)");
        } else if (points < 0){
            drawTool.drawText(20,40, "YOU LOOSE :(");
        }

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

        //TODO 08 Nachdem Sie die TODOs 01-07 erledigt haben: Setzen Sie um, dass im Falle einer Kollision (siehe TODO 06 bzw. 07) zwischen dem Spieler und dem Apfel bzw. dem Spieler und der Birne, die jumpBack()-Methode von dem Apfel bzw. der Birne aufgerufen wird.


        if (checkAndHandleCollision(apple01)){points++; apple01.jumpBack();}
        if (checkAndHandleCollision(pear01)){points++; pear01.jumpBack();}
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
    public void decreasePoints(int amount){points -= amount;}
    public void befriendApple(Apple a){
        this.apple01 = a;
    }
    public void befriendPear(Pear p){
        this.pear01 = p;
    }

    //#TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
    //TODO 07 Fügen Sie eine Methode checkAndHandleCollision(Pear p) hinzu. Diese gibt true zurück, falls das Pear-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.

    public boolean checkAndHandleCollision(Apple a){
        if (collidesWith(a)){
            return true;
        }
        return false;
    }
    public boolean checkAndHandleCollision(Pear p){
        if (collidesWith(p)){
            return true;
        }
        return false;
    }
}
