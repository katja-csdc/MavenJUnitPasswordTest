import java.util.regex.Matcher;
import java.util.regex.Pattern;
//comment//
public class PasswordCheck {
    public static boolean isValid(String password) {
        if (password.length() < 8 || password.length() > 25)
            return false;

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[()#$?!%/@]).+$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);

        if (!m.matches())
            return false;

        int l = password.length();

        for (int i = 0; i < l - 3; i++) {
            if (Character.isDigit(password.charAt(i)) && Character.isDigit(password.charAt(i + 1)) &&
                    Character.isDigit(password.charAt(i + 2)) && Character.isDigit(password.charAt(i + 3))) {
                if (password.charAt(i) == password.charAt(i + 1) &&
                        password.charAt(i + 1) == password.charAt(i + 2) &&
                        password.charAt(i + 2) == password.charAt(i + 3)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < l - 2; i++) {
            if (Character.isDigit(password.charAt(i)) && Character.isDigit(password.charAt(i + 1)) &&
                    Character.isDigit(password.charAt(i + 2))){
                if ((int)password.charAt(i) == ((int)password.charAt(i + 1) - 1) &&
                        (int)password.charAt(i + 1) == ((int)password.charAt(i + 2) - 1)){
                    return false;
                }
            }
        }

        return true;
    }
}
