import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainWindow extends JFrame {
    private static HashMap<String, Computer> computerHashMap;
    private static List<Staff> staffList;
    private static int screenWidth;
    private static int screenHeight;
    private static ImageIcon iconImage;
    private static JLabel iconLabel;
    private static JPanel preLoginPanel;
    private static JButton preLoginButton;
    private static boolean isLoggedIn;
    private static final String login = "Click to login";
    private static final String logout = "Log Out";
    public MainWindow(){
        computerHashMap = new HashMap<>();
        staffList = new ArrayList<>();
        iconImage = new ImageIcon("logo_125_125.png");
        iconLabel = new JLabel(iconImage);
        preLoginPanel = new JPanel();
        isLoggedIn = false;
        preLoginButton = new JButton();
        setLoginButtonText(isLoggedIn);
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        //Setting up main window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(screenWidth/2, screenHeight);
        getContentPane().setBackground(Color.GRAY);
        loginPanel(this);
        setVisible(true);
    }
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        ComputerStoreSystem.intialiseComputerHashMap(computerHashMap);
        ComputerStoreSystem.initialiseStaffLogins(staffList);
    }
    public static void Open(JFrame origin){
        JTabbedPane tabbedPane = new JTabbedPane();
        //create 2 panels to be added to the tabbedpane
        JPanel browse = new JPanel();
        JPanel view = new JPanel();

        tabbedPane.addTab("Browse Products", browse);
        tabbedPane.addTab("View Item", view);

        tabbedPane.setVisible(true);
        origin.add(tabbedPane);




    }
    public static void setLoginButtonText(boolean loggedIn){
        if(loggedIn){ preLoginButton.setText(logout);}
        else{preLoginButton.setText(login);}
    }
    public static void loginPanel(MainWindow main){
        preLoginButton.setFocusPainted(false);
        preLoginButton.addActionListener(e-> new LoginDialog(main, staffList));

        preLoginPanel.add(iconLabel);
        preLoginPanel.add(preLoginButton);

        main.add(preLoginPanel, BorderLayout.SOUTH);
    }
}
