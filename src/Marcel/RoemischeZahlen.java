package Marcel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RoemischeZahlen {

    // Eine HashMap zur Speicherung der römischen Ziffern und ihrer entsprechenden Dezimalwerte
    private static final Map<Character, Integer> roemischeZiffern = new HashMap<>();

    // Statischer Initialisierungsblock, um die HashMap mit Werten zu füllen
    static {
        roemischeZiffern.put('I', 1);
        roemischeZiffern.put('V', 5);
        roemischeZiffern.put('X', 10);
        roemischeZiffern.put('L', 50);
        roemischeZiffern.put('C', 100);
        roemischeZiffern.put('D', 500);
        roemischeZiffern.put('M', 1000);
    }

    // Methode zur Umwandlung einer römischen Zahl in eine Dezimalzahl
    public static int roemischZuDezimal(String roemisch) {
        int ergebnis = 0; // Variable zur Speicherung des Endergebnisses
        int letzteWert = 0; // Variable zur Speicherung des Wertes der letzten verarbeiteten Ziffer

        // Schleife durchläuft den String von rechts nach links
        for (int i = roemisch.length() - 1; i >= 0; i--) {
            char ziffer = roemisch.charAt(i); // Extrahiert das aktuelle Zeichen aus dem String
            int wert = roemischeZiffern.get(ziffer); // Holt den entsprechenden Dezimalwert aus der HashMap

            // Wenn der aktuelle Wert kleiner ist als der vorherige Wert, wird dieser subtrahiert
            if (wert < letzteWert) {
                ergebnis -= wert;
            } else { // Andernfalls wird er addiert
                ergebnis += wert;
            }
            letzteWert = wert; // Aktualisiert den letzten Wert
        }

        return ergebnis; // Gibt das Endergebnis zurück
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner-Objekt zur Eingabe von der Konsole

        System.out.print("Bitte geben Sie eine römische Zahl ein: ");
        String eingabe = scanner.nextLine(); // Liest die Benutzereingabe

        int dezimalWert = roemischZuDezimal(eingabe); // Wandelt die römische Zahl in eine Dezimalzahl um

        System.out.println("Die dezimale Darstellung von " + eingabe + " ist: " + dezimalWert); // Gibt das Ergebnis aus

        scanner.close(); // Schließt den Scanner
    }
}