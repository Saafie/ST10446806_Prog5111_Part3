import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoginSystem {
    //Declaring
    String username;
    String password;
    String name;
    String surname;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        });
    }

    public LoginSystem(String username1, String password1, String name1, String surname1) {
        this.username = username1;
        this.password = password1;
        this.name = name1;
        this.surname = surname1;


        int i = 0;
        //Checks if username and password are valid or invalid
        while(i<1){
            username1 = JOptionPane.showInputDialog("Enter Username: ");
            password1 = JOptionPane.showInputDialog("Enter Password: ");
        if (username1.equals(username) && password1.equals(password)) {
            JOptionPane.showMessageDialog((Component)null, "Welcome " + name + " " + surname + " it is great to see you again.");
            JOptionPane.showMessageDialog((Component)null, " Welcome to EasyKanban"); //Displays when username and password is correct
            i++;
        } else {
            JOptionPane.showMessageDialog((Component)null, "Invalid username or password."); //Displays if username or password is incorrect
        }

    }Task.questions();
}}
