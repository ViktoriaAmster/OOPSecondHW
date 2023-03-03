package Unit;

public class Crossbowman extends Shooter{

    public Crossbowman(String name,Vector2D position) {
        super(name, 100f, 100, 10, 15, 20, 3,
                5, position.posX, position.posY, 15,5);
    }

    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Арбалет: \t").append(Crossbowman.super.name)
                .append("\t HP: \t").append(Crossbowman.super.hp)
                .append("\t Arrows: ").append(Crossbowman.super.cartridges)
                .append("\t State: \t").append(Crossbowman.super.state);
    }

    @Override
    public void step() {}

}
