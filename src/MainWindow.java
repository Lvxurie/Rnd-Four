import javax.swing.*;
import java.awt.*;
import java.util.*;
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
    private static Staff staffMemberLoggedIn;

    public MainWindow() {
        computerHashMap = new HashMap<>();
        staffList = new ArrayList<>();
        iconImage = new ImageIcon("logo_125_125.png");
        iconLabel = new JLabel(iconImage);
        preLoginPanel = new JPanel();
        isLoggedIn = false;
        preLoginButton = new JButton();
        loginInit(isLoggedIn);
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        //Setting up main window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(screenWidth / 2, screenHeight);
        getContentPane().setBackground(Color.GRAY);
        loginPanel(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        ComputerStoreSystem.intialiseComputerHashMap(computerHashMap);
        ComputerStoreSystem.initialiseStaffLogins(staffList);
    }

    public static void Open(JFrame origin) {
        //create a tabbed pane for the main window
        JTabbedPane tabbedPane = new JTabbedPane();
        //create the browse pane
        JPanel browse = new JPanel();
        //create a model to handle the table data from the hashmap and a scroll panel
        StockTableModel stockTableModel = new StockTableModel(computerHashMap.values());
        JTable table = new JTable(stockTableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);

        JLabel catagoryLabel = new JLabel("Computer Category");
        JComboBox<String> categoryComboBox = new JComboBox<String>(ComputerStoreSystem.categories);
        categoryComboBox.addActionListener(e -> {
            String selectedCategory = (String) categoryComboBox.getSelectedItem();
            stockTableModel.updateCategory(selectedCategory);
        });
        JLabel typeLabel = new JLabel("Computer Type");
        JComboBox<String> typeComboBox = new JComboBox<String>(ComputerStoreSystem.types);
        typeComboBox.addActionListener(e -> {
            String selectedType = (String) typeComboBox.getSelectedItem();
            stockTableModel.updateType(selectedType);
        });
        //create a panel for the buttons
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(catagoryLabel);
        comboBoxPanel.add(categoryComboBox);
        comboBoxPanel.add(typeLabel);
        comboBoxPanel.add(typeComboBox);

        //add the panels to the browse window
        browse.add(comboBoxPanel, BorderLayout.NORTH);
        browse.add(tableScrollPane);

        //create the view pane
        JPanel view = new JPanel();
        JPanel details = new JPanel(new GridLayout(9, 2));
        details.setBorder(BorderFactory.createEmptyBorder(120, 0, 0, 0));

        JTextField modelIDField = new JTextField();
        JComboBox<String> categoryCombo = new JComboBox<>(ComputerStoreSystem.categories);
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
        details.add(categoryCombo);
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
        add.addActionListener(e -> {
            if(!stockTableModel.checkDuplicateID(modelIDField.getText())){
                String category = "";
                String type;
                String id;
                String brand;
                String cpuFamily;
                String memorySize;
                String ssdCapacity;
                String screenSize;
                double price;

                if(categoryCombo.getSelectedItem()!= null){
                    category = categoryCombo.getSelectedItem().toString();
                }
                if(typeCombo.getSelectedItem()!= null){
                    type = typeCombo.getSelectedItem().toString();
                }
                if(modelIDField.getText()!= null){
                    id = modelIDField.getText();
                }
                if(brandField.getText()!= null){
                    brand = brandField.getText();
                }
                if(cpuFamilyField.getText()!= null){
                    cpuFamily = cpuFamilyField.getText();
                }
                if(priceField.getText()!= null){
                    price = Double.parseDouble(priceField.getText());
                }
                switch(category){
                    case "Desktop PC": {
                        if(memorySizeField.getText()!= null){
                            memorySize = memorySizeField.getText();
                        }
                        if(ssdCapacityField.getText()!= null){
                            ssdCapacity = ssdCapacityField.getText();
                        }
                        //Computer temp = new Computer();
                    }
                    case "Laptop":{
                        if(memorySizeField.getText()!= null){
                            memorySize = memorySizeField.getText();
                        }
                        if(ssdCapacityField.getText()!= null){
                            ssdCapacity = ssdCapacityField.getText();
                        }
                        if(memorySizeField.getText()!= null){
                            memorySize = memorySizeField.getText();
                        }
                        if(screenSizeField.getText()!= null){
                            screenSize = screenSizeField.getText();
                        }
                    }
                    case "Tablet":{
                        if(screenSizeField.getText()!= null){
                            screenSize = screenSizeField.getText();
                        }
                    }

                }

                //computerHashMap.put(modelIDField.getText(), temp);
                stockTableModel.updateMasterList(computerHashMap.values());
            }

        });
        JButton update = new JButton("update");
        update.addActionListener(e -> {
            //update the selected object
        });
        JButton delete = new JButton("delete");
        delete.addActionListener(e -> {
            //delete the current object
        });
        JButton clear = new JButton("clear");
        clear.addActionListener(e -> {
            //set fields to default state
        });
        buttonPanel.add(add);
        buttonPanel.add(update);
        buttonPanel.add(delete);
        buttonPanel.add(clear);
        buttonPanel.setVisible(true);
        view.add(details);
        view.add(buttonPanel);
        //Listener for when the tab is changed
        table.getSelectionModel().addListSelectionListener(e -> {
            /*When a tab swap occurs, the selectedRow value changes to -1 and if an update occurs
            an out of bound exception is thrown*/
            try {
                //get the object from the table row
                Computer selectedComputer = stockTableModel.activeSelection(table.getSelectedRow());
                modelIDField.setText(selectedComputer.getId());
                categoryCombo.setSelectedItem(selectedComputer.getCategory());
                typeCombo.setSelectedItem(selectedComputer.getType());
                brandField.setText(selectedComputer.getBrand());
                cpuFamilyField.setText(selectedComputer.getCpuFamily());
                priceField.setText(selectedComputer.getPrice());

                if (selectedComputer instanceof Desktop) {
                    String memorySize = ((Desktop) selectedComputer).getMemorySize();
                    memorySizeField.setText(memorySize);
                    String ssdCapacity = ((Desktop) selectedComputer).getSsdCapacity();
                    ssdCapacityField.setText(ssdCapacity);
                } else if (selectedComputer instanceof Laptop) {
                    String memorySize = ((Laptop) selectedComputer).getMemorySize();
                    memorySizeField.setText(memorySize);
                    String ssdCapacity = ((Laptop) selectedComputer).getSsdCapacity();
                    ssdCapacityField.setText(ssdCapacity);
                    String screenSize = ((Laptop) selectedComputer).getScreenSize();
                    screenSizeField.setText(screenSize);
                } else if (selectedComputer instanceof Tablet) {
                    String screenSize = ((Tablet) selectedComputer).getScreenSize();
                    screenSizeField.setText(screenSize);
                }
            } catch (IndexOutOfBoundsException err) {
                System.out.println(err);
            }
        });

        tabbedPane.addTab("Browse Products", browse);
        tabbedPane.addTab("View Item", view);
        tabbedPane.setVisible(true);
        tabbedPane.addChangeListener(e -> {
            stockTableModel.updateData();
        });
        origin.add(tabbedPane);
    }

    public static void loginInit(boolean loggedIn) {
        if (loggedIn) {
            preLoginButton.setText(logout);
        } else {
            preLoginButton.setText(login);
        }
    }

    public static void setStaffMember(Staff staffMember) {
        staffMemberLoggedIn = staffMember;
    }

    public static void loginPanel(MainWindow main) {
        preLoginButton.setFocusPainted(false);
        preLoginButton.addActionListener(e -> new LoginDialog(main, staffList));

        preLoginPanel.add(iconLabel);
        preLoginPanel.add(preLoginButton);

        main.add(preLoginPanel, BorderLayout.SOUTH);
    }
}
