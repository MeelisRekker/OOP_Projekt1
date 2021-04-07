import java.util.List;
import java.util.Scanner;

public class Poomine {

    static boolean prindiSõnaSeis(String sõna, List<Character> mängijaArvamised) { //meetod sõna arvamise seisu printimiseks
        int õigeid = 0;
        for (int i = 0; i < sõna.length(); i++) { //prindib kas kriipsud või leitud tähed
            if (mängijaArvamised.contains(sõna.charAt(i))) {
                System.out.print(sõna.charAt(i));
                õigeid++;
            } else {
                System.out.print("-");
            }

        }
        System.out.println();

        return (sõna.length() == õigeid); //kas sõna on arvatud

    }

    static boolean getMängijaArvamised(Scanner klaviatuur, String sõna, List<Character> mängijaArvamised) { //meetod mängija tähtede sisestamiseks
        System.out.println("Sisesta üks täht: ");
        String arvatudTäht = klaviatuur.nextLine();
        mängijaArvamised.add(arvatudTäht.charAt(0));  //kui mängija sisestab mingi pikema asja, loeb ainult esimese tähe
        return sõna.contains(String.valueOf(arvatudTäht.charAt(0)));  //kas sõna sisaldab arvatud tähte
    }

    static void prindiMees(int valesti) { //meetod poodud mehikese printimiseks, lubatud on 5 vale arvamist
        System.out.println(" -------");
        System.out.println(" |");
        if (valesti >= 1) {
            System.out.println(" O");
        }

        if (valesti >= 2) {
            System.out.print("\\ ");
            if (valesti >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }

        if (valesti >= 4) {
            System.out.println(" |");
        }
        if (valesti >= 5) {
            System.out.print("/ ");
            if (valesti >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
    }
}




