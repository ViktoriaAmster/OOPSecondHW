package main;

import Unit.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class main {

    static final int UNITS = 10;
    public static void main(String[] args) {

        ArrayList<Human> lightSide = new ArrayList<>();
        ArrayList<Human> darkSide = new ArrayList<>();
        ArrayList<Human> teams = new ArrayList<>();
        Scanner user_input = new Scanner(System.in);
        createTeam(lightSide, 0, 4, 1);
        createTeam(darkSide, 3, 7, 10);
        teams.addAll(lightSide);
        teams.addAll(darkSide);


        while (true) {
            sortTeam(lightSide);
            sortTeam(darkSide);
            sortTeam(teams);
            gameInfo(lightSide,darkSide);
            if (Human.findLive(lightSide).size() == 0){
                System.out.println("Победила команда DarkSide");
                return;
            } else if (Human.findLive(darkSide).size() == 0) {
                System.out.println("Победила команда LightSide");
                return;
            } else {
                for (Human pers: teams){
                    if (lightSide.contains(pers)){
                        pers.step(Human.findLive(lightSide),Human.findLive(darkSide));
                    }else {pers.step(Human.findLive(darkSide),Human.findLive(lightSide));}
                }
                user_input.nextLine();
            }
        }
    }

    public static void gameInfo (ArrayList<Human> team1, ArrayList<Human> team2) {
        for (int i = 0; i < team1.size(); i++) {
            System.out.

                    println(team1.get(i).getInfo());
        }
        System.out.println();
        for (int i = 0; i < team2.size(); i++) {
            System.out.println(team2.get(i).getInfo());
        }
        System.out.println();
//            for (int i = 0; i < teams.size(); i++) {
//                System.out.println(teams.get(i).getInfo());
//            }
//            System.out.println();
    }
    public static void createTeam(ArrayList targetList, int start, int end, int posY) {

        for (int i = 1; i < UNITS+1; i++) {
            int rnd = new Random().nextInt(start, end);
            switch (rnd) {
                case (0):
                    targetList.add(new Sniper(getName(),new Vector2D(i,posY)));
                    break;
                case (1):
                    targetList.add(new Witch(getName(),new Vector2D(i,posY)));
                    break;
                case (2):
                    targetList.add(new Bandit(getName(),new Vector2D(i,posY)));
                    break;
                case (3):
                    targetList.add(new Farmer(getName(),new Vector2D(i,posY)));
                    break;
                case (4):
                    targetList.add(new Crossbowman(getName(),new Vector2D(i,posY)));
                    break;
                case (5):
                    targetList.add(new Spearman(getName(),new Vector2D(i,posY)));
                    break;
                case (6):
                    targetList.add(new Monk(getName(),new Vector2D(i,posY)));
                    break;
            }
        }
    }

    static void sortTeam(ArrayList<Human> team) {
        team.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                if (o1.getSpeed() == o2.getSpeed()) return (int) (o1.getHp() - o2.getHp());
                else return (o1.getSpeed() - o2.getSpeed());
            }
        });
    }
        public static String getName () {
            String name = String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
            return name;
        }
}

