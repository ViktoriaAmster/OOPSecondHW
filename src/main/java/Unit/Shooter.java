package Unit;

import java.util.ArrayList;

public abstract class Shooter extends Human {
    protected int cartridges;
    protected int range;

    public Shooter(String name, float hp, int maxHp, int attack, int minDamage, int maxDamage, int protection,
                   int speed, int posX, int posY, int cartridges, int range) {
        super(name, hp, maxHp, attack, minDamage, maxDamage, protection, speed, posX, posY);
        this.cartridges = cartridges;
        this.range = range;
    }

    protected boolean findFarmer(ArrayList<Human> team) {
        ArrayList<Human> arrayFarmers = new ArrayList<>();
        for (Human pers : team) {
            if (pers.getInfo().toString().contains("Ф")
                    && ((Farmer) pers).getArrows() > 0) {
                arrayFarmers.add(pers);
            }
        }
        if (arrayFarmers.size() == 0) {
            return false;
        } else if (arrayFarmers.size() == 1) {
            ((Farmer) arrayFarmers.get(0)).setArrows(0);
            return true;
        } else {
            ((Farmer) findNearest(arrayFarmers)).setArrows(0);
            return true;
        }
    }

    public void step(ArrayList<Human> ourTeam, ArrayList<Human> notOurTeam) {
        if (hp > 0) {
            if (cartridges > 0) {
                makeDamage(findNearest(notOurTeam));
                if (findFarmer(ourTeam)) {
                    return;
                }
                cartridges--;
            }
        }
    }

}