abstract class User {
    String userName;
    int userID;

    public User(int id, String name) {
        this.userID = id;
        this.userName = name;
    }

    String getUserName() {
        return userName;
    }

    int getUserID() {
        return userID;
    }


    public abstract void changeData(Patient selectedPatient);
    public abstract void changeMedicatie(Patient selectedPatient);

    public abstract void viewData(Patient selectedPatient);



}
