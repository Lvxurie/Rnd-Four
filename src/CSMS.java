import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSMS extends JFrame {
    private static HashMap<String, Computer> computerHashMap;
    private static List<Staff> staffList;
    private static JFrame mainFrame;
    private static int screenWidth;
    private static int screenHeight;
    public CSMS(){
        computerHashMap = new HashMap<>();
        staffList = new ArrayList<>();
        mainFrame = new JFrame("Computer Store Management System");
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    }
    public static void main(String[] args) {
        new CSMS();
        ComputerStoreSystem.intialiseComputerHashMap(computerHashMap);
        setMainFrame();
        LoginDialog loginScreen = new LoginDialog(mainFrame);
    }
    public static void setMainFrame(){
        mainFrame.setBounds(screenWidth/2 - (screenWidth/4), screenHeight/100, screenWidth/2 ,screenHeight-50);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
