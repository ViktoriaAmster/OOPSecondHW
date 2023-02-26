package Unit;

import java.util.ArrayList;

public class Bandit extends Infantry{

    int disguise;

    public Bandit(String name, Vector2D position) {
        super(name, 50f, 50, 10, 2,6 , 7,6, position.posX, position.posY);
        this.disguise = 15;
    }


    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Бандит: \t").append(Bandit.super.name)
                .append("\t ATK: \t").append(Bandit.super.attack)
                .append("\t HP: \t").append(Bandit.super.hp)
                .append("\t Speed: \t").append(Bandit.super.speed);
    }

    @Override
    public void step() {

    }

}
