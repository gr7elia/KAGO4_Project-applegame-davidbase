package my_project.model;

import KAGO_framework.model.GraphicalObject;
import my_project.Config;
import my_project.control.ProgramController;

public class Fruit extends GraphicalObject {

    private final int speed;

    public Fruit() {
        this.x = Math.random() * Config.WINDOW_WIDTH;
        this.y = Math.random() * -100 - 300;
        this.speed = 150;
    }

    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).

        y += speed*dt;

        if (this.y > 1000)  {
            jumpBack();
        }
        //if (checkAndHandleCollision(player01)) {jumpBack();}
    }

    public void jumpBack(){
        y = -2*height;
        x = Math.random()*(1000-width);
    }


    public double getY(){
        return y;
    }
}
