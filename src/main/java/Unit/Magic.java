package Unit;

import java.util.ArrayList;

public abstract class Magic extends Human {

    protected int mana;
    protected int maxMana;
    protected int heal;

    public Magic(String name, float hp, int maxHp, int attack, int minDamage, int maxDamage, int protection, int speed,
                 int posX, int posY, int mana, int maxMana, int heal) {
        super(name, hp, maxHp, attack, minDamage, maxDamage, protection, speed, posX, posY);
        this.mana = mana;
        this.maxMana = maxMana;
        this.heal = heal;
    }


    protected void healing(ArrayList<Human> ourTeam) {
        ArrayList<Human> notMaxHPTeam = new ArrayList<>();
        for (Human pers : ourTeam) {
            if (pers.getHp() < pers.getMaxHp()) {
                notMaxHPTeam.add(pers);
            }
        }
        if (notMaxHPTeam.size() > 0) {
            Human persForHeal = findNearest(notMaxHPTeam);
            if (persForHeal.getHp() + heal > persForHeal.getMaxHp()) {
                persForHeal.setHp(persForHeal.getMaxHp());
            } else {
                persForHeal.setHp(persForHeal.getHp() + heal);
            }
        }
    }

    public void step(ArrayList<Human> ourTeam, ArrayList<Human> notOurTeam) {
        if (mana > 0) {
            healing(ourTeam);
            mana -= 5;
        }
    }
}


