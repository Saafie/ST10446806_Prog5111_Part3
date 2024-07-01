//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;

public class Main {
    private static String Name;
    private static String Surname;
    private static String username;
    private static String Password;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            registerUser();
        });
    }

    public static boolean registration(String username) {
        int valid = 0;
        int invalid = 0;

        // Validating if Username is or is not successful
        int length = username.length();
        if (length == 5 && username.contains("_")) {
            valid += 1;
        } else {
            invalid += 1;
        }

        return valid > invalid;
    }

    public static boolean PasswordComplexity(String password) {
        int Successful = 0;
        int Unsuccessful = 0;

        // Password validation
        if (password.length() >= 8 && (password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&].*"))) {
            Successful = 1;
        } else {
            Unsuccessful = 1;
        }

        return Successful > Unsuccessful;
    }

    public static String Names(){

    return Name; }

    public static String Surname(){

    return Surname;}

    public static void registerUser() {
        Name = JOptionPane.showInputDialog("Enter name");
        Surname = JOptionPane.showInputDialog("Enter Surname");
        username = JOptionPane.showInputDialog("Enter Username");
        Password = JOptionPane.showInputDialog("Enter Password");

        boolean checkUsername = registration(username);
        boolean checkPassword = PasswordComplexity(Password);

        String registerUserMessage = (checkUsername ? "Name: " + Name + "\nSurname: " + Surname : "Resubmit") + "\n\n"
                + (checkUsername ? "Username Successfully Captured" : "Username must be 5 characters long and contain an underscore (_)")
                + "\n" + (checkPassword ? "Password Successfully captured" : "Password must:\n- Contain at least 8 characters\n- Contain a capital letter\n- Contain a number\n- Contain a special character");

        JOptionPane.showMessageDialog(null, registerUserMessage);

        if (checkUsername && checkPassword) {
            // Assuming LoginSystem class constructor takes these parameters
            SwingUtilities.invokeLater(() -> {
                LoginSystem loginSystem = new LoginSystem(username, Password, Name, Surname);
            });
        }
    }
}