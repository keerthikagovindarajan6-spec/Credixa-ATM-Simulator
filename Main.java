public class Main {

    public static void main(String[] args) {

        System.out.println("MAIN STARTED");

        DatabaseConnection.connect();

        new LoginFrame();
    }
}