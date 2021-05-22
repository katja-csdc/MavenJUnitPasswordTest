import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class isValidTest {

    @Test
    @DisplayName("Has password longer length")
    void testPasswordLengthLonger() {
        assertFalse(PasswordCheck.isValid("aaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    @DisplayName("Has password shorter length")
    void testPasswordLengthShorter() {
        assertFalse(PasswordCheck.isValid("aaaas"));
    }

    @Test
    @DisplayName("Has password no small letters")
    void testPasswordForSmallLetters() {
        assertFalse(PasswordCheck.isValid("QWEASDZXC12#3"));
    }

    @Test
    @DisplayName("Has password no capital letters")
    void testPasswordForCapitalLetters() {
        assertFalse(PasswordCheck.isValid("qweasdzxc12#3"));
    }

    @Test
    @DisplayName("Has password no numbers")
    void testPasswordForNumbers() {
        assertFalse(PasswordCheck.isValid("QWEASDzxc##"));
    }


    @Test
    @DisplayName("Has password no special characters")
    void testPasswordFoSpecialChars() {
        assertFalse(PasswordCheck.isValid("QWEASDzxc132"));
    }

    @Test
    @DisplayName("Has password consecutive numbers")
    void checkForConsecutiveNumbers() {
        assertFalse(PasswordCheck.isValid("QWEASDzxc123#"));
    }

    @Test
    @DisplayName("Has password same 4 numbers")
    void checkForSameNumbers() {
        assertFalse(PasswordCheck.isValid("QWEASDzxc1111#"));
    }

    @Test
    @DisplayName("Is password correct")
    void checkForCorrectPassword() {
        assertTrue(PasswordCheck.isValid("QWEASDzxc12#3"));
    }
}