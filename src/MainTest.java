import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

        @Test
        public void testValidUsername() {
            String validUsername = "kyl_1";
            assertTrue(Main.registration(validUsername));
            System.out.println("Valid Username Test Passed");
        }

        @Test
        public void testInvalidUsername() {
            String invalidUsername = "kyle!!!!!!!";
            assertFalse(Main.registration(invalidUsername));
            System.out.println("Invalid Username Test Passed");
        }

        @Test
        public void testValidPassword() {
            String validPassword = "Ch&&sec@ke99!";
            assertTrue(Main.PasswordComplexity(validPassword));
            System.out.println("Valid Password Test Passed");
        }

        @Test
        public void testInvalidPassword() {
            String invalidPassword = "password";
            assertFalse(Main.PasswordComplexity(invalidPassword));
            System.out.println("Invalid Password Test Passed");
        }
    @Test
    public void testLoginSuccess() {
        String validUsername = "kyl_1";
        String validPassword = "Ch&&sec@ke99!";
        Main.registerUser();

        // Assuming registerUser sets Name, Surname, username, and Password correctly
        String result = "Welcome " + Main.Names() + " " + Main.Surname() + ", good to see.";
        System.out.println(result);

        // Assert login success based on registration and password complexity
        assertTrue(Main.registration(validUsername) && Main.PasswordComplexity(validPassword));
        System.out.println("Login Successful");
    }

    @Test
    public void testLoginFailure() {
        String invalidUsername = "kyle!!!!!!!";
        String invalidPassword = "password";
        Main.registerUser();

        // Assuming registerUser sets Name, Surname, username, and Password correctly
        assertFalse(Main.registration(invalidUsername) && Main.PasswordComplexity(invalidPassword));
        System.out.println("Login Unsuccessful");
    }
    }
