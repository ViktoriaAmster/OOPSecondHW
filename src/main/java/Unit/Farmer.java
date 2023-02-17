package Unit;

public class Farmer extends Human{
    public Farmer(String name) {
        super(name, 10.1f, 10, 3,1,3,1, 1);
    }

    public Farmer(String name, Float hp, Integer maxHp, Integer attack, Integer minDamage, Integer maxDamage, Integer protection, Integer speed) {
        super(name, hp, maxHp, attack, minDamage, maxDamage, protection, speed);
    }

    public void armiger (Shooter Shooter){  }

    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Фермер: \t").append(Farmer.super.name)
                .append("\t ATK: \t").append(Farmer.super.attack)
                .append("\t HP: \t").append(Farmer.super.hp);
    }

}
