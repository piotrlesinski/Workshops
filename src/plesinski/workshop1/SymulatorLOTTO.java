package src.plesinski.workshop1;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SymulatorLOTTO {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Wpisz 6 liczb z zakresu 1 - 49. Po każdej liczbie naciśnij enter");
        System.out.println("Wpisz 1 liczbę." );

//============================== typowanie liczb ===============================

        Set<Integer> listaTypowanychLiczb = new TreeSet<>( );

        try {
            Scanner scanner = new Scanner(System.in);
            int licznik = 6;
            for (int i = 0; i < licznik; i++) {
                int liczba = scanner.nextInt( );
                if (!listaTypowanychLiczb.contains(liczba)) {
                    if (liczba > 0 && liczba < 50) {
                        listaTypowanychLiczb.add(liczba);
                    } else {
                    System.out.println("Twoja liczba " + liczba + " nie jest z zakresu 1-49. Wpisz inną.");
                    licznik++;
                    }
                } else {
                    System.out.println("Ta liczba jest już podana. Wpisz inną. " );
                    licznik++;
                }
                System.out.println("Wpisz " + (listaTypowanychLiczb.size() + 1) + " liczbę.");
            }
            System.out.println("\nTwoje wytypowane liczby to: " + listaTypowanychLiczb);

//================================ losowanie liczb ===================================

            System.out.println("\nRozpoczynamy losowanie liczb");
            Random random = new Random( );
            Set<Integer> listaWylosowLiczb = new TreeSet<>( );

            int licznik2 = 6;
            for (int i = 0; i < licznik2; i++) {
                int liczba = 1 + random.nextInt(15);
                TimeUnit.MILLISECONDS.sleep(800);
                if (!listaWylosowLiczb.contains(liczba)) {
                    listaWylosowLiczb.add(liczba);
                    System.out.print(liczba + " ");
                } else {
                    licznik2++;
                }
            }
            System.out.println("\nWylosowane liczby to: " + listaWylosowLiczb);

//========================== szczęśliwe liczby =======================================

            Set<Integer> szczesliweLiczby = new TreeSet<>();
            Iterator<Integer> iterWytypLiczb = listaTypowanychLiczb.iterator();

            for (int i = 0; i < listaTypowanychLiczb.size(); i++) {

                int wytypowanaLiczba = iterWytypLiczb.next();

                Iterator<Integer> iterWylosLiczb = listaWylosowLiczb.iterator();

                for (int j = 0; j < listaWylosowLiczb.size(); j++) {

                    int wylosowanaLiczba = iterWylosLiczb.next( );

                    if (wylosowanaLiczba == wytypowanaLiczba) {
                        szczesliweLiczby.add(wylosowanaLiczba);
                    }
                }
            }
            if (szczesliweLiczby.isEmpty()) {
                System.out.println("\nPrzykro mi. Nic nie trafiłeś. \nSpróbuj szczęścia ponownie.");
            } else if (szczesliweLiczby.size() >= 3){
                System.out.println("\nGratulacje WYGRAŁEŚ!!! \nTwoje szczęśliwe liczby: " + szczesliweLiczby);
            } else {
                if (szczesliweLiczby.size( ) == 1) {
                    System.out.println("\nPrzykro mi. Nic nie wygrałeś. Trafiłeś tylko liczbę " + szczesliweLiczby);
                } else {
                    System.out.println("\nPrzykro mi. Nic nie wygrałeś. Trafiłeś tylko liczby " + szczesliweLiczby);
                }
            }


        } catch (
                InputMismatchException e) {
            System.out.println("To nie jest liczba całkowita. Zagraj jeszcze raz.");
        }




//        public int compare (Integer i1, Integer i2){
//            return i1.compareTo(i2);
//        }
    }
}

