// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static int bossHeals = 800;

    public static int bossDamage = 60;


    public static int[] heroHals = {250, 260, 270, 280};
    public static int[] heroDamage = {20, 25, 30, 0};
    public static String[] heroAttackTyre = {"Warior", "Magick", "Telepan", "Medic"};
    public static int round = 0;

    public static int[] medicHals;


    public static void main(String[] args) {

        printStatistics();
        while (!isGameFinished()) {
            round++;
            round();

        }

    }

    public static boolean isGameFinished() {
        boolean allHerosDead = true;
        if (bossHeals <= 0) {
            System.out.println("HEROES WIN !!!");
            return true;
        }

        for (int i = 0; i < heroHals.length; i++) {
            if (heroHals[i] > 0) {
                allHerosDead = false;
                break;

            }

        }
        if (allHerosDead) {
            System.out.println("BOSS WIN !!!");
        }

        return allHerosDead;
    }


    public static void printStatistics() {
        System.out.println("STATISTIC");
        System.out.println(" Boss heals " + bossHeals + ";" + " damage " + bossDamage);
        for (int i = 0; i < heroAttackTyre.length; i++) {
            System.out.println(" Hero heals " + heroAttackTyre[i]
                    + " " + heroHals[i] + " domage " + heroDamage[i]);
        }
    }

    public static void bossHits() {
        for (int i = 0; i < heroAttackTyre.length; i++) {
            if (bossHeals > 0) {
                if (heroHals[i] < bossDamage) {
                    bossHeals = 0;

                } else {
                    heroHals[i] = heroHals[i] - bossDamage;

                }

            }
        }
    }

    public static void medic() {
        boolean medicA =false;
        medicA = false;
        for (int i = 0; i < heroAttackTyre.length; i++) {
            if (heroHals[i] > 0 && heroAttackTyre[i].equals("Medic")) {
                medicA = true;
            }
        }
        for (int i = 0; i < heroAttackTyre.length; i++) {
            if (heroHals[i] > 0 && heroHals[i] < 100 && medicA) {
                heroHals[i] = heroHals[i] + 25;
                System.out.println("medic hils up" + heroAttackTyre[i]);
                break;
            }

        }
    }


    public static void heroHits() {
        for (int i = 0; i < heroAttackTyre.length; i++) {
            if (heroHals[i] > 0) {
                if (bossHeals < heroDamage[i]) {
                    bossHeals = 0;
                } else {
                    bossHeals = bossHeals - heroDamage[i];
                }
            }
        }

    }


    public static void round() {
        System.out.println("ROUND - " + round);
        bossHits();
        heroHits();
        medic();
        printStatistics();
    }


}

