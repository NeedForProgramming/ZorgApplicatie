import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Medicijn {
    public String naam;
    public String dosering;
    public String omschrijving;

    Medicijn(String naam, String dosering, String omschrijving) {
        this.naam = naam;
        this.dosering = dosering;
        this.omschrijving = omschrijving;
    }

    public String getNaam() {
        return naam;
    }

    public String getDosering() {
        return dosering;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String toString() {
        return this.naam + ", " + this.dosering + ", " + this.omschrijving;
    }

    public void setNaam(Scanner sc) {
        System.out.println("Nieuwe naam?");
        // printMedicijnen();
        this.naam = sc.nextLine();
    }

    public void setDosering(Scanner sc) {
        System.out.println("Nieuwe dosering?");
        this.dosering = sc.nextLine();
    }

    public void setOmschrijving(Scanner sc) {
        System.out.println("Nieuwe omschrijving?");
        this.omschrijving = sc.nextLine();
    }

    public void changeData(Scanner sc) {
        System.out.println("Wat wilt u wijzigen?");
        System.out.println("1. Naam");
        System.out.println("2. Dosering");
        System.out.println("3. Omschrijving");

        int choice = sc.nextInt();
        sc.nextLine(); // na het lezen van een int moet je hem op de volgende regel zetten als je niks meer op de originele regel hoeft te doen
        switch (choice) {
            case 1:
                setNaam(sc);
                break;
            case 2:
                setDosering(sc);
                break;
            case 3:
                setOmschrijving(sc);
                break;
        }
    }

//    public static void printMedicijnen() {
//        System.out.println("1 Acetylcysteine");
//        System.out.println("2 Aciclovir");
//        System.out.println("3 Alginaat");
//        System.out.println("4 Alginezuur");
//        System.out.println("5 Aluminiumhydroxide");
//    }


//
//    public static void main(String[] args) {
//        List<Medicijn> medicijnen = new ArrayList<>();
//        medicijnen.add(new Medicijn("Acetylcysteine", "dosage1", "description1"));
//        medicijnen.add(new Medicijn("Aciclovir", "dosage2", "description2"));
//        medicijnen.add(new Medicijn("Alginaat", "dosage3", "description3"));
//        medicijnen.add(new Medicijn("Alginezuur", "dosage4", "description4"));
//        medicijnen.add(new Medicijn("Aluminiumhydroxide", "dosage5", "description5"));
//
//
//        printMedicijnen();
//    }
}
