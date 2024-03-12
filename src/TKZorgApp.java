public class TKZorgApp {
    public static void main(String[] args) {

        User user = new Dentist(1, "Dhr ElCamera");
        Administration administration = new Administration(user);

        administration.Users.add(user);
        administration.Users.add(new Dentist(2, "Tandarts Dhr van Meurs"));
        administration.Users.add(new GP(3, "Huisarts Dhr van Hal"));
        administration.Users.add(new Physiotherapist(4, "Fysiotherapeut Mvr van Geritsen"));
        administration.Users.add(new Pharmacist(5, "Apotheker Mvr van Oomen"));

        String blueColor = "\u001B[34m";
        administration.menu();
        System.out.print(blueColor);
//        System.out.format("Je bent afgemeld van: [%d] %s\n", user.getUserID(), user.getUserName());
        System.out.format(" Het programma is afgesloten ") ;

    }
}

