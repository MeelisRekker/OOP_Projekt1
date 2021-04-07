import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Peaklass extends Poomine{

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("sõnad.txt"), StandardCharsets.UTF_8); //loeb mängu jaoks sõnad failist
        Scanner klaviatuur = new Scanner(System.in); //loeb klaviatuurilt sisetatud asju

        List<String> sõnad = new ArrayList<>();

        while (sc.hasNext()){
            sõnad.add(sc.nextLine());
        }

        Random rand = new Random(); //valib randomiga suvalise sõna sisseloetute seast

        String sõna = sõnad.get(rand.nextInt(sõnad.size()));


        List<Character> mängijaArvamised = new ArrayList<>();

        int valesti = 0;
        System.out.println("Tere tulemast mängima poomismängu! Sisestage tähti kuni arvate ära sõna või kaotate!");
        while(true) {  //while-tsükkel kuni mäng katkeb

            prindiMees(valesti);

            if (valesti >= 6) {
                System.out.println("Kaotasid!");
                System.out.println("Valitud sõna oli " + sõna);
                break;
            }

            System.out.println("Arvatav sõna: ");
            prindiSõnaSeis(sõna, mängijaArvamised);
            if (!getMängijaArvamised(klaviatuur, sõna, mängijaArvamised)) { //kui arvatud täht ei ole sõna osa, suurendab counterit
                valesti++;
            }


            if(prindiSõnaSeis(sõna, mängijaArvamised)){ //kui sõna on arvatud (õigeid on sama palju nagu sõna pikkus), lõpetab mängu
                System.out.println("Võitsid!");
                break;
            }

            System.out.println("Arva, mis sõna võiks olla: ");
            if (klaviatuur.nextLine().equals(sõna)){ //kui kirjutati õige sõna, lõpetab mängu
                System.out.println("Võitsid!");
                break;
            }
            else {
                System.out.println("Arvasid valesti! Proovi edasi!"); //jätkab mängu, kui arvati valesti
            }
        }

    }

}
