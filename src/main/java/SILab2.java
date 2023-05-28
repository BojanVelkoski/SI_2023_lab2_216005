import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {
    public static boolean function(User user, List<User> allUsers) {
        if (user == null || user.getPassword() == null || user.getEmail() == null) { //A
            throw new RuntimeException("Mandatory information missing!"); //B
        }

        if (user.getUsername() == null) { //C
            user.setUsername(user.getEmail()); //D
        }

        int same = 1; //E
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //E //Emailot mora da sodrzhi @ i . inaku same ostanuva na 1
            same = 0; //1
            for (int i = 0; i < allUsers.size(); i++) { //1, 2, 3
                User existingUser = allUsers.get(i); //F
                if (existingUser.getEmail() == user.getEmail()) { //F //Proverka dali postoi toj e-mail
                    same += 1; //G
                }
                if (existingUser.getUsername() == user.getUsername()) { //H -> I || H -> 3 -> 2 //Proverka dali postoi korisnichkoto ime
                    same += 1; //I -> 3 -> 2
                }
            }
        }

        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //J
        String password = user.getPassword(); //J
        String passwordLower = password.toLowerCase(); //J
        //Ako pasvordot go sodrzhi korisnichkoto ime vo nego ili e so dolzhina < 8 togash ne e validno
        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length() < 8) { //J
            return false; //K
        } else { //L
            if (!passwordLower.contains(" ")) { //L
                for (int i = 0; i < specialCharacters.length(); i++) { //4, 5, 6
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //M -> N || M -> 6 -> 5 //Pasvordot mora da sodrzhi eden od specijalnite karakteri za da bide validen
                        return same == 0; //N -> P //Tochno e samo koga ne e pronajden korisnik so isti e-mail ili username
                    }
                }
            }
        }
        return false; //O
    } //P

}