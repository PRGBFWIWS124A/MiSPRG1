
import java.util.Random;
public class Sebi {
    private static void baumfaellen ( int i){
        System.out.println("hacken");
        if (i == 1) {
            System.out.println("Baum fällt!");
        } else {
            baumfaellen(i - 1);
        }}



    public static void main(String args[]) {
        Random rand = new Random();
        int Baum = rand.nextInt(10) + 1;

        for (int i = 0; i < Baum; i++) {
            System.out.println("Hau Ruck, Hau Ruck");
        }
        System.out.println("Achtung Baum fällt! \nWow, das war ein Dicker Stamm:" + Baum + "0 Cm, war das anstrengend!" + "\nDieser Satz wurde mit einer For-Schleife erzeugt!\n \n");
        int j = 0;
        while (j < (Baum + 1)) {
            System.out.println("Hau Ruck, Hau Ruck");
            j++;
        }
        System.out.println("Achtung Baum fällt! \nWow, das war ein Dicker Stamm:" + (Baum + 1) + "0 Cm, war das anstrengend! " + "\nDieser Satz wurde mit einer While-Schleife erzeugt!\n \n");
        int k = 0;
        do {
            System.out.println("Hau Ruck, Hau Ruck");
            k++;
        } while (k < (Baum + 2));
        System.out.println("Achtung Baum fällt! \nWow, das war ein Dicker Stamm:" + (Baum + 2) + "0 Cm, war das anstrengend!" + "\nDieser Satz wurde mit einer Do-While-Schleife erzeugt!\n");

        int[] Feld = new int[5];
        Feld[0] = 1;
        Feld[1] = 2;
        Feld[2] = 3;
        Feld[3] = 4;
        Feld[4] = 5;
        System.out.println(Feld[2]);

        int[] hundert = new int[100];
        for (int i = 0; i < 100; i++) {
            hundert[i] = i + 1;
        }
        System.out.println(hundert[99]);
        int[] Eins = {1, 4, 6, 12, 200};
        System.out.println(Eins[3]);
        System.out.println(Eins.length);

        baumfaellen( 4);
    }

    }



