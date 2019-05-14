package plesinski.workshop1;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SymulatorLOTTO {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Podaj 6 liczb z zakresu 1 - 49. Po każdej liczbie naciśnij enter");

        int[] listaTypowanychLiczb = new int[5];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listaTypowanychLiczb.length; i++) {
            int liczba = scanner.nextInt();
            listaTypowanychLiczb[i] = liczba;
        }
        System.out.println("Twoje wytypowane liczby to: " + Arrays.toString(listaTypowanychLiczb));

        System.out.println("Rozpoczynamy losowanie liczb" );
        Random random = new Random();
        Set<Integer> listaWylosowLiczb = new TreeSet<>();

        for (int i = 0; i < 6; i++) {
            int liczba = 1 + random.nextInt(48);
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print(liczba + " ");
            listaWylosowLiczb.add(liczba);

        }
        System.out.println("\nWylosowane liczby" + listaWylosowLiczb);



    }
}
