import java.util.List;
import java.util.Scanner;

public class Poomine  {

    static String ANSI_RESET = "\u001B[0m";                        //konsooli teksti värvid
    static String ANSI_BLACK = "\u001B[30m";
    static String ANSI_RED = "\u001B[31m";
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_BLUE = "\u001B[34m";


    static boolean prindiSõnaSeis(String sõna, List<Character> mängijaArvamised) {          //meetod sõna arvamise seisu printimiseks
        int õigeid = 0;
        System.out.print("Arvatav sõna:   ");

        for (int i = 0; i < sõna.length(); i++) {                   //prindib kas kriipsud või leitud tähed
            if (mängijaArvamised.contains(sõna.charAt(i))) {
                System.out.print(ANSI_GREEN + sõna.charAt(i) + ANSI_RESET);
                õigeid++;
            } else
                System.out.print(ANSI_RED + "_" + ANSI_RESET);
        }
        System.out.println();
        return (sõna.length() == õigeid);               //kas sõna on arvatud
    }

    static boolean getMängijaArvamised(Scanner klaviatuur, String sõna, List<Character> mängijaArvamised) {     //meetod mängija tähtede sisestamiseks
        System.out.print("Sisesta üks täht: ");

        String sisend = klaviatuur.nextLine();

        if (sisend.equals("")) {
            System.out.println(ANSI_BLUE + "jätkan.." + ANSI_RESET);
            System.out.print("Sõna praegu:   ");
            return false;
        }

        Character uusTäht = sisend.charAt(0);

        for (Character arvatudTähed : mängijaArvamised) {
           if (arvatudTähed.equals(uusTäht))
               System.out.println(ANSI_BLUE + "Tähte " + uusTäht + " juba arvati" + ANSI_RESET);
        }
        mängijaArvamised.add(uusTäht);                                    //kui mängija sisestab mingi pikema asja, loeb ainult esimese tähe
        return sõna.contains(String.valueOf(uusTäht));                    //kas sõna sisaldab arvatud tähte

    }

    static void prindiMees(int valesti) {                               //meetod poodud mehikese printimiseks, lubatud on 5 vale arvamist
        System.out.println(ANSI_BLACK + " _______" + ANSI_RESET);
        System.out.println(ANSI_BLACK + " |" + ANSI_RESET);
        if (valesti >= 1)
            System.out.println(" O");

        if (valesti >= 2) {
            System.out.print("\\ ");
            if (valesti >= 3)
                System.out.println("/");
            else
                System.out.println();
        }

        if (valesti >= 4)
            System.out.println(" |");

        if (valesti >= 5) {
            System.out.print("/ ");
            if (valesti >= 6)
                System.out.println("\\");
            else
                System.out.println();
        }
    }
}




