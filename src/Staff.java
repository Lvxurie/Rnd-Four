import java.util.Objects;

public class Staff {
    private String username;
    private String password;

    public Staff(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean validateCredentials(String username, char[] password){
        String passwordString = new String(password);
        return this.username.equals(username) && this.password.equals(passwordString);
    }

    public String getUsername() {
        return username;
    }
}
