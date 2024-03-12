import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient {

    List<Medicijn> medicijnen;

    int       id;
    String    surname;
    String    firstName;
    LocalDate dateOfBirth;
    double weight;
    double height;

    double longInhoud;


    public double bmiCalculator() {
        double bmi = weight / (height * height);
        return (bmi * 100.0) / 100.0 ;
    }

    public int calcAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }

    public Patient(int id, String surname, String firstName, LocalDate dateOfBirth, double weight, double height, double longInhoud) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.longInhoud = longInhoud;
        this.medicijnen = new ArrayList<>();
    }
    public void voegMedicijnToe(Medicijn medicijn) {
        medicijnen.add(medicijn);
    }
    String formatDateOfBirth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dateOfBirth.format(formatter);
    }


    public double getheight() {
        return height;
    }
    double getweight() {
        return weight;
    }
    LocalDate getdateOfBirth() {
        return dateOfBirth;
    }

    String getSurname() {
        return surname;
    }

    String getFirstName() {
        return firstName;
    }

    public void editFirstname(Scanner scanner) {
        System.out.print("Nieuwe voornaam: ");
        scanner.nextLine();
        String FirstName = scanner.nextLine();
        try {
            if (FirstName.matches("^[a-zA-Z]+$")) {
                this.firstName = FirstName;
            } else {
                throw new IllegalArgumentException("Voornaam mag alleen letters bevatten.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    void editSurname(Scanner scanner) {
        System.out.print("Nieuwe achternaam: ");
        scanner.nextLine();
        String Surname = scanner.nextLine();
        try {
            if (Surname.matches("^[a-zA-Z]+$")) {
                this.surname = Surname;
            } else {
                throw new IllegalArgumentException("Achternaam mag alleen letters bevatten.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    void editDateOfBirth(Scanner scanner) {
        System.out.print("Nieuwe geboortedatum (dd-MM-yyyy): ");
        scanner.nextLine();
        String DateOfBirth = scanner.nextLine();
        try {
            LocalDate parsedDate = LocalDate.parse(DateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            this.dateOfBirth = parsedDate;
            // calc new age
        } catch (DateTimeParseException e) {
            System.out.println("Ongeldige datumnotatie. Gebruik het formaat dd-MM-yyyy.");
        }
    }

    void editWeight( Scanner scanner) {
        System.out.print("Nieuw gewicht (kg): ");
        scanner.nextLine();
        try {
            double weight = Double.parseDouble(scanner.nextLine());
            this.weight = weight;
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige gewichtswaarde. Voer een geldig getal in.");
        }
    }

    void editHeight( Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nieuwe lengte (m): ");
        try {
            double height = Double.parseDouble(scanner.nextLine());
            this.height = height;
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige lengtewaarde. Voer een geldig getal in.");
        }
    }

    void editlongInhoud( Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nieuwe longInhoud (l): ");
        try {
            double longInhoud = Double.parseDouble(scanner.nextLine());
            this.longInhoud = longInhoud;
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige longinhoud waarde. Voer een geldig getal in.");
        }
    }


//    void viewData() {
//        System.out.format("===== Patient id=%d ==============================\n", id);
//        System.out.println(" ");
//        System.out.format("%-17s %s\n", "Voornaam:", firstName);
//        System.out.format("%-17s %s\n", "Achternaam:", surname);
//        System.out.format("%-17s %s\n", "Geboortedatum:", formatDateOfBirth());
//        System.out.format("%-17s %d jaar \n", "Leeftijd:", calcAge());
//        System.out.format("%-17s %.1f kg\n", "Gewicht:", weight);
//        System.out.format("%-17s %.2f meter\n", "Lengte:", height);
//        System.out.format("%-17s %.2f liter\n", "LongInhoud:", longInhoud);
//        System.out.format("%-17s %.1f kg/m²\n", "BMI:", bmiCalculator());
//    }

    void changeMedicatie (){
        System.out.println("Welke medicatie wil u wijzigen?");
        viewMedicijn();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        this.medicijnen.get(choice - 1).changeData(sc);

    }
    public void viewMedicijn() {
        System.out.println("Medicijnen:");
        for (int i = 0; i < this.medicijnen.size(); i++) {
            Medicijn medicijn = this.medicijnen.get(i);
            System.out.println((i + 1) + ". Medicijn: " + medicijn.getNaam() + ", Dosering: " + medicijn.getDosering() + ", Omschrijving: " + medicijn.getOmschrijving());

        }
    }


    void removeMedicatie() {
        System.out.println("Welke medicatie wilt u verwijderen?");
        viewMedicijn();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        this.medicijnen.remove(choice - 1);
    }

    public int getId() {
        return id;
    }

    String fullName() {
        return String.format("%s %s ", firstName, surname);
    }
}
