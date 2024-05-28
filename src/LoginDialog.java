import javax.swing.*;
import java.awt.*;


public class LoginDialog extends JDialog{
    private JLabel iconLabel;
    private JLabel nameLabel;
    private JLabel passLabel;
    private JButton submit;
    private JTextField nameTextField;
    private JTextField passTextField;
    

    public LoginDialog(JFrame origin){
        super(origin, "Log in..",true);
        setSize(300,200);
        setLocationRelativeTo(origin);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        setLayout(new GridBagLayout());
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());


        ImageIcon iconImage = new ImageIcon("logo_125_125.png");
        iconLabel = new JLabel(iconImage);
        nameLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        nameTextField = new JTextField(20);
        passTextField = new JPasswordField(20);
        submit = new JButton("Log in");
        submit.setFocusPainted(true);

        leftPanel.add(iconLabel);

        GridBagConstraints usernameLabelConstraints = new GridBagConstraints();
        usernameLabelConstraints.gridx = 0;
        usernameLabelConstraints.gridy =1;
        usernameLabelConstraints.insets = new Insets(5,5,5,5);
        //usernameLabelConstraints.anchor = GridBagConstraints.CENTER;
        rightPanel.add(nameLabel, usernameLabelConstraints);

        GridBagConstraints usernameTextFieldConstraints = new GridBagConstraints();
        usernameLabelConstraints.gridx = 0;
        usernameLabelConstraints.gridy =2;
        usernameLabelConstraints.insets = new Insets(5,5,5,5);
        //usernameLabelConstraints.anchor = GridBagConstraints.CENTER;
        rightPanel.add(nameTextField, usernameTextFieldConstraints);

        GridBagConstraints passwordLabelConstraints = new GridBagConstraints();
        usernameLabelConstraints.gridx = 0;
        usernameLabelConstraints.gridy =4;
        usernameLabelConstraints.insets = new Insets(5,5,5,5);
        //usernameLabelConstraints.anchor = GridBagConstraints.CENTER;
        rightPanel.add(passLabel, passwordLabelConstraints);

        GridBagConstraints passwordTextFieldConstraints = new GridBagConstraints();
        usernameLabelConstraints.gridx = 0;
        usernameLabelConstraints.gridy =2;
        usernameLabelConstraints.insets = new Insets(5,5,5,5);
        //usernameLabelConstraints.anchor = GridBagConstraints.CENTER;
        rightPanel.add(passTextField, passwordTextFieldConstraints);

        GridBagConstraints submitButtonConstraints = new GridBagConstraints();
        usernameLabelConstraints.gridx = 0;
        usernameLabelConstraints.gridy = 6;
        usernameLabelConstraints.insets = new Insets(5,5,5,5);
        //usernameLabelConstraints.anchor = GridBagConstraints.CENTER;
        rightPanel.add(submit, submitButtonConstraints);

        GridBagConstraints mainPane = new GridBagConstraints();
        mainPane.gridx = 0;
        mainPane.gridy =0;
        mainPane.fill = GridBagConstraints.BOTH;

    }
}
