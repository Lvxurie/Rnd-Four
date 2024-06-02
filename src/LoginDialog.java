import javax.swing.*;
import java.awt.*;
import java.util.List;


public class LoginDialog extends JDialog{
    private JLabel iconLabel;
    private JLabel nameLabel;
    private JLabel passLabel;
    private JButton submit;
    private JTextField nameTextField;
    private JPasswordField passTextField;
    
    //JFrame for relative positioning and staffCredentialsList for login check.
    public LoginDialog(JFrame origin, List<Staff> staffCredentialsList){
        //Creates a modal JDialog object
        super(origin, "Log in..",true);
        setSize(300,200);
        //center JDialog
        setLocationRelativeTo(origin);
        //Cannot close via the exit button
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        //split the Dialog into two panel for easier object placement
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());

        ImageIcon iconImage = new ImageIcon("logo_125_125.png");
        iconLabel = new JLabel(iconImage);
        nameLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        nameTextField = new JTextField(10);
        passTextField = new JPasswordField(10);
        submit = new JButton("Log in");
        submit.setFocusPainted(true);

        iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 0));
        leftPanel.add(iconLabel, BorderLayout.CENTER);
        //set the positions of each component
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy =1;
        constraints.insets = new Insets(0,5,5,5);
        rightPanel.add(nameLabel, constraints);

        constraints.gridy =2;
        rightPanel.add(nameTextField, constraints);

        constraints.gridy =4;
        rightPanel.add(passLabel, constraints);

        constraints.gridy =5;
        rightPanel.add(passTextField, constraints);

        constraints.gridy = 6;
        //when the login button is pressed compare each of the fields to the staffCredentialsList
        submit.addActionListener(e -> {
         String username = nameTextField.getText();
         char[] password = passTextField.getPassword();
         boolean success = false;
            for(Staff s : staffCredentialsList){
                if(s.validateCredentials(username, password)){
                    //break from loop if a match is found
                    success = true;
                    break;
                }
            }
            //dispose of the log in box if a match is found
            if(success){
                JOptionPane.showMessageDialog(this, "Logging in..", "Success!", JOptionPane.PLAIN_MESSAGE);
                MainWindow.setLoginButtonText(true);
                dispose();
                MainWindow.Open(origin);
            }
            //otherwise show an error and clear the password field.
            else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                passTextField.setText("");
            }
        });
       rightPanel.add(submit, constraints);
       //add both panels to the JDialog
       add(leftPanel, BorderLayout.WEST);
       add(rightPanel, BorderLayout.CENTER);

        setResizable(false);
        setVisible(true);
    }
}
