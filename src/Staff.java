import java.util.Objects;

public class Staff {
    private String username;
    private String password;
    private boolean editingPrivilages;

    public Staff(String username, String password, boolean editingPrivilages) {
        this.username = username;
        this.password = password;
        this.editingPrivilages = editingPrivilages;
    }
    public boolean validateCredentials(String username, char[] password){
        String passwordString = new String(password);
        return this.username.equals(username) && this.password.equals(passwordString);
    }
    public boolean privalagesCheck(Staff staff){
        return editingPrivilages;
    }
}
