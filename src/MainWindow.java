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

        JPanel browse = new JPanel();
        JLabel catagoryLabel = new JLabel("Computer Catagory");
        JComboBox<String> catagories = new JComboBox<String>(ComputerStoreSystem.catagories);
        JLabel typeLabel = new JLabel("Computer Type");
        JComboBox<String> types = new JComboBox<String>(ComputerStoreSystem.types);
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(catagoryLabel);
        comboBoxPanel.add(catagories);
        comboBoxPanel.add(typeLabel);
        comboBoxPanel.add(types);
        JTable table = new JTable(9,10);
        browse.add(comboBoxPanel,BorderLayout.NORTH);
        browse.add(table);

        JPanel view = new JPanel();
        JPanel details = new JPanel(new GridLayout(9,2));
        details.setBorder(BorderFactory.createEmptyBorder(120,0,0,0));
        JTextField modelIDField = new JTextField();
        JComboBox<String> catagoryCombo = new JComboBox<>(ComputerStoreSystem.catagories);
        JComboBox<String> typeCombo = new JComboBox<>(ComputerStoreSystem.types);
        JTextField brandField = new JTextField();
        JTextField cpuFamilyField = new JTextField();
        JTextField memorySizeField = new JTextField();
        JTextField ssdCapacityField = new JTextField();
        JTextField screenSizeField = new JTextField();
        JTextField priceField = new JTextField();

        details.add(new JLabel("Model ID:"));
        details.add(modelIDField);
        details.add(new JLabel("Catagory:"));
        details.add(catagoryCombo);
        details.add(new JLabel("Type:"));
        details.add(typeCombo);
        details.add(new JLabel("Brand:"));
        details.add(brandField);
        details.add(new JLabel("CPU Family:"));
        details.add(cpuFamilyField);
        details.add(new JLabel("Memory Size:"));
        details.add(memorySizeField);
        details.add(new JLabel("SSD Capacity:"));
        details.add(ssdCapacityField);
        details.add(new JLabel("Screen Size:"));
        details.add(screenSizeField);
        details.add(new JLabel("Price:"));
        details.add(priceField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton add = new JButton("add");
        add.addActionListener(e->{
            //create a new object of type ? and add it to the hashmap
        });
        JButton update = new JButton("update");
        update.addActionListener(e->{
            //update the selected object
        });
        JButton delete = new JButton("delete");
        delete.addActionListener(e->{
            //delete the current object
        });
        JButton clear = new JButton("clear");
        clear.addActionListener(e->{
            //set fields to default state
        });
        buttonPanel.add(add);
        buttonPanel.add(update);
        buttonPanel.add(delete);
        buttonPanel.add(clear);
        buttonPanel.setVisible(true);
        view.add(details);
        view.add(buttonPanel);




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
