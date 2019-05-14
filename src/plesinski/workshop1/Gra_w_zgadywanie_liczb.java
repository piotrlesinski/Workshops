package plesinski.workshop1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Gra_w_zgadywanie_liczb {

    public static void main(String[] args) {

        Random random = new Random( );

        Scanner scanner = new Scanner(System.in);


        int liczbaKomputera = random.nextInt(5);
        int mojaLiczba = 0;
        int liczbaProbOdgadnięc = 1;

        System.out.println("Zgadnij liczbę w przedziale 0 - 5");

        try {

            while (true) {
                mojaLiczba = scanner.nextInt( );

                if (liczbaKomputera  ==  mojaLiczba) {
                    System.out.println("Brawo!. Odgadłeś za " + liczbaProbOdgadnięc + " razem.");
                    break;
                } else if (liczbaKomputera > mojaLiczba) {
                    System.out.println("Za mało!");
                } else if (liczbaKomputera < mojaLiczba) {
                    System.out.println("Za dużo!");
                }
                liczbaProbOdgadnięc++;
            }
        } catch (InputMismatchException e) {
            System.err.println("To nie jest liczba człkowita. Zagraj jeszcze raz.");
        }
    }
}