package Unit;

import java.util.ArrayList;

public class Farmer extends Human{
    protected int arrows;
    public Farmer(String name,Vector2D position) {
        super(name, 10f, 10, 3,1,3,1, 1, position.posX, position.posY);
        this.arrows = 1;
    }

    public int getArrows() {return arrows;}
    public void setArrows(int arrows) {this.arrows = arrows;}

    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Фермер: \t").append(Farmer.super.name)
                .append("\t HP: \t").append(Farmer.super.hp)
                .append("\t State: \t").append(Farmer.super.state);
    }

    @Override
    public void step() {

    }

}
