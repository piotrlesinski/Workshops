package src.plesinski.workshop1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KomputerZgadnijLiczbe {

    public static void main(String[] args) {

        int min = 0;
        int max = 100;
        int licznik = 0;
        String zgadles = "zgadles";
        String odpowiedz;

        System.out.println("Pomyśl liczbę od 0 do 100 a ja zgadnę ją zgadnę w max. 10 próbach. ");

        try {
            Scanner scanner = new Scanner(System.in);

            while (true){
                int zgadywanaLiczba = ((max - min) / 2) + min;

                System.out.println("Zgaduję: " + zgadywanaLiczba + "\nWybierz odpowiedź z zestawu: za duzo, za malo, zgadles");
                odpowiedz = scanner.nextLine( );
                System.out.println("Odpowiedź: " + odpowiedz);
                if (odpowiedz.equals("za duzo")) {
                    max = zgadywanaLiczba;
                } else if (odpowiedz.equals("za malo")) {
                    min = zgadywanaLiczba;
                } else if (odpowiedz.equals(zgadles)) {
                    System.out.println("Wygrałem!!!");
                    System.out.println("Licznik: " + licznik);
                    break;
                } else {
                    System.out.println("Podałeś niepoprawną odpowiedź. Wybierz odpowiedź z zestawu.");
                }
                licznik++;
                if(licznik > 10) {
                    System.out.println("Oszukujesz!!");
                    break;
                }
            }


        } catch (InputMismatchException e) {
            System.out.println("Niepoprawny typ danych. Zagraj jeszcze raz.");
        }
    }

}
