import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
class Administration {
    static final int STOP = 0;
    static final int VIEW = 1;
    static final int SWITCH_PATIENT = 2;
    static final int SWITCH_USER = 3;
    static final int MODIFY_PATIENT = 4;
    static final int BEWERK_GEGEVENS = 1;
//    static final int MEDICATIE_TONEN = 2;
    static final int MEDICATIE_TOEVOEGEN = 2;

    static final int MEDICATIE_WIJZIGEN = 3;
    static final int MEDICATIE_VERWIJDEREN = 4;
    static final int MENU = 6;

    Patient currentPatient;
    User currentUser;

    private ArrayList<Patient> patients = new ArrayList<>();
    public ArrayList<Medicijn> Medicijnen = new ArrayList<>();
    public ArrayList<User> Users = new ArrayList<>();



    private int currentPatientIndex = 0;
    private Scanner scanner = new Scanner(System.in);

    Administration(User user) {
        currentUser = user;

        patients.add(new Patient(1, "Van Basten", "Marco",
                LocalDate.of(1964, 10, 31), 80, 1.87, 4.5));
        patients.add(new Patient(2, "Van Dijk", "Virgil",
                LocalDate.of(1991, 7, 8), 85, 1.90, 4.5));
        patients.add(new Patient(3, "Van der Vaart", "Rafael",
                LocalDate.of(1983, 2, 11), 70, 1.78, 4.5));
        patients.add(new Patient(4, "Van de Kamp", "Ronald",
                LocalDate.of(1985, 11, 24), 78, 1.82, 4.5));
        patients.add(new Patient(5, "Van Hanegem", "Willem",
                LocalDate.of(1994, 2, 20), 75, 185, 4.5));


        currentPatient = patients.get(currentPatientIndex);


//        System.out.format("Huidige gebruiker: [%d] %s\n", user.getUserID(), user.getUserName());

        System.out.print("\u001B[34m");
        System.out.print("Welkom bij de ZorgApp");
        System.out.println("\u001B[0m");

    }

    private void viewAndModifyPatientData() {
        currentUser.viewData(currentPatient);

        System.out.println("Wat wilt u doen?");
        System.out.println("1: Bewerk gegevens");
//        System.out.println("2: Medicatie tonen");
        System.out.println("2: Medicatie toevoegen");
        System.out.println("3: Medicatie wijzigen");
        System.out.println("4: Medicatie verwijderen");
        System.out.println("5: Terug naar het menu");
        System.out.print("maak keuze: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case BEWERK_GEGEVENS:
                modifyPatientData();
                break;

//            case MEDICATIE_TONEN:
//                currentPatient.viewMedicijn();
//                break;

            case MEDICATIE_TOEVOEGEN:
                medicatieToevoegen();
                break;

            case MEDICATIE_WIJZIGEN:
                currentPatient.changeMedicatie();
                break;

            case MEDICATIE_VERWIJDEREN:
                currentPatient.removeMedicatie();
                break;

            case MENU:
                break;

            default:
                System.out.println("Ongeldige invoer. Voer 1 of 2 in.");
        }
    }

    public void medicatieToevoegen() {
        System.out.println("Welke medicijn wilt u toevoegen?");
        System.out.println("1 Acetylcysteine");
        System.out.println("2 Aciclovir");
        System.out.println("3 Capsicum extract");
        System.out.println("4 Carbocisteine");
        System.out.println("5 Waterstofperoxide");

        int keuze = scanner.nextInt();
        String naam;
        String omschrijving = "";

        switch (keuze) {
            case 1:
                naam = "Acetylcysteine";
                omschrijving = "geen voorwaarden";
                break;
            case 2:
                naam = "Aciclovir";
                omschrijving = "uitsluitend als crème";
                break;
            case 3:
                naam = "Capsicum extract";
                omschrijving = "uitsluitend als dermale crème";
                break;
            case 4:
                naam = "Carbocisteine";
                omschrijving = "uitsluitend als hoestmiddel";
                break;
            default:
                naam = "Waterstofperoxide";
                omschrijving = "uitsluitend als mondspoeling";
                break;
        }

        System.out.println("Wat is de dosering van het medicijn?");
        String dosering = scanner.next();

        System.out.println("Omschrijving voor dit medicijn: " + omschrijving);

        currentPatient.voegMedicijnToe(new Medicijn(naam, dosering, omschrijving));
    }


    public void modifyPatientData() {
        // var scanner = new Scanner(System.in);
        //hiernaar toe verplaatsen
        currentUser.changeData(currentPatient);

    }


    public void addUser(String userName) {
        int userID = Users.size() + 1;
        // User user = new User(userID, userName);
        User user = new Dentist(userID, userName);
        Users.add(user);
    }


    void viewUsers() {
        System.out.println(" ");
        System.out.println("Beschikbare gebruikers:");

        for (User user : Users) {
            System.out.format("[%d] %s\n", user.getUserID(), user.getUserName());

        }
    }

    void switchUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer de gebruiker's ID in om te wisselen: ");
        int selectedUserID = scanner.nextInt();

        User selectedUser = null;
        for (User u : Users) {
            if (u.userID == selectedUserID) {
                selectedUser = u;
                break;
            }
        }

        if (selectedUser == null) {
            System.out.println("No valid user selected");
            return;
        }

        currentUser = selectedUser;
        System.out.format("Schakel over naar een andere gebruiker: [%d] %s\n", currentUser.getUserID(),
                currentUser.getUserName());
    }

    void viewPatients() {
        System.out.println(" ");
        System.out.println("Beschikbare patiënten:");
        for (Patient patient : patients) {
            System.out.format("[%d] %s\n", patient.getId(), patient.fullName());
        }
    }

    void switchPatient() {
        System.out.print("Voer de patiënt's ID in om te wisselen: ");
        int PatientId = scanner.nextInt();

        Patient selectedPatient = null;
        for (Patient patient : patients) {
            if (patient.getId() == PatientId) {
                selectedPatient = patient;
                break;
            }
        }

        if (selectedPatient != null) {
            currentPatient =  selectedPatient;
            System.out.format("Schakel over naar een andere patiënt: %s\n", currentPatient.fullName());
        } else {
            System.out.println("Ongeldige patiënt ID");
        }
    }
    void menu() {
        var scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Kies een gebruiker om te beginnen:");
        for (int i = 0; i < Users.size(); i++) {
            User user = Users.get(i);
            System.out.format("[%d] %s\n", user.getUserID(), user.getUserName());
        }

        int selectedUserID;
        while (true) {
            System.out.println(" ");
            System.out.print("Voer het ID van de gewenste gebruiker in: ");
            try {
                selectedUserID = scanner.nextInt() - 1;
                if (selectedUserID >= 0 && selectedUserID < Users.size()) {
                    break;
                } else {
                    System.out.println("Ongeldige gebruiker ID. Probeer opnieuw.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ongeldige invoer. Voer een geldig nummer in.");
                scanner.next();
            }
        }
        currentUser = Users.get(selectedUserID);

        boolean nextCycle = true;
        while (nextCycle) {
            System.out.println(" ");
            System.out.format("%s\n", "=".repeat(80));

            if (nextCycle) {
                System.out.println(" ");
                System.out.format("Gekozen gebruiker: [%d] %s\n", currentUser.getUserID(), currentUser.getUserName());
                System.out.format("De huidige patiënt : %s, %s \n", currentPatient.getFirstName(),
                        currentPatient.getSurname());
            }

            System.out.println("Maak een keuze:");
            System.out.format("%d:  STOP\n", STOP);
            System.out.format("%d:  Patiëntgegevens bekijken\n", VIEW);
            System.out.format("%d:  Schakel over naar een andere patiënt\n", SWITCH_PATIENT);
            System.out.format("%d:  Schakel over naar een andere gebruiker\n", SWITCH_USER);



            System.out.println(" ");
            System.out.print("maak keuze: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case STOP:
                        nextCycle = false;
                        break;

                    case VIEW:
                        viewAndModifyPatientData();
                        break;

                    case SWITCH_USER:
                        viewUsers();
                        switchUsers();
                        break;

                    case SWITCH_PATIENT:
                        viewPatients();
                        switchPatient();
                        break;

                    case MODIFY_PATIENT:
                        modifyPatientData();
                        break;

                    default:
                        System.out.println("Voer een *geldig* cijfer in");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ongeldige invoer. Voer een geldig nummer in.");
                scanner.next();
            }
        }
    }
}
