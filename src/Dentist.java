import java.util.Scanner;

public class Dentist extends User {

    static final int editFirstname = 1;
    static final int editSurname = 2;
    static final int editDateOfBirth = 3;

    public Dentist(int id, String name) {
        super(id, name);
    }

    @Override
    public void changeData(Patient selectedPatient) {

        var scanner = new Scanner(System.in);

        System.out.println("Welke gegevens wilt u wijzigen?");
        System.out.println("1: Voornaam");
        System.out.println("2: Achternaam");
        System.out.println("3: Geboortedatum");

        int choice = scanner.nextInt();

        switch (choice) {
            case editFirstname:
                selectedPatient.editFirstname(scanner);
                break;
            case editSurname:
                selectedPatient.editSurname(scanner);
                break;
            case editDateOfBirth:
                selectedPatient.editDateOfBirth(scanner);
                break;
        }
    }

    @Override
    public void viewData(Patient selectedPatient) {
        System.out.format("===== Patient id=%d ==============================\n", selectedPatient.id);
        System.out.println(" ");
        System.out.format("%-17s %s\n", "Voornaam:", selectedPatient.firstName);
        System.out.format("%-17s %s\n", "Achternaam:", selectedPatient.surname);
        System.out.format("%-17s %s\n", "Geboortedatum:", selectedPatient.formatDateOfBirth());
        System.out.format("%-17s %d jaar \n", "Leeftijd:", selectedPatient.calcAge());
        selectedPatient.viewMedicijn();
        System.out.println(" ");
    }

    @Override
    public void changeMedicatie(Patient selectedPatient) {
        System.out.println("U hebt geen toegang om te medicatie te wijzigen");
    }
}
