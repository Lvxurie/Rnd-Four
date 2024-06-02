import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSMS extends JFrame {
    private static HashMap<String, Computer> computerHashMap;
    private static List<Staff> staffList;
    private static int screenWidth;
    private static int screenHeight;
    private static ImageIcon iconImage;
    private static JLabel iconLabel;
    private static JPanel preLoginPanel;
    private static JButton preLoginButton;
    private static boolean initiateLogin;

    public CSMS(){
        computerHashMap = new HashMap<>();
        staffList = new ArrayList<>();
        iconImage = new ImageIcon("logo_125_125.png");
        iconLabel = new JLabel(iconImage);
        preLoginPanel = new JPanel();
        preLoginButton = new JButton("Click to login");
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        initiateLogin = false;

        //Setting up main window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(screenWidth/2, screenHeight);
        getContentPane().setBackground(Color.GRAY);

        setVisible(true);
    }
    public static void main(String[] args) {
        CSMS mainWindow = new CSMS();
        loginPanel(mainWindow);
        while(initiateLogin){
            JDialog loginDialog = new JDialog(mainWindow, true);
        }
        ComputerStoreSystem.intialiseComputerHashMap(computerHashMap);
        ComputerStoreSystem.initialiseStaffLogins(staffList);
    }
    public static void setIsLoggedIn(boolean l){
        initiateLogin = l;
    }
    public static void loginPanel(CSMS main){
        preLoginButton.setFocusPainted(false);
        preLoginButton.addActionListener(e-> setIsLoggedIn(true));

        preLoginPanel.add(iconLabel);
        preLoginPanel.add(preLoginButton);

        main.add(preLoginPanel, BorderLayout.NORTH);
    }
}
