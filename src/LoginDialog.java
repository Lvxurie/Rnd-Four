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
        setLayout(null);
        ImageIcon iconImage = new ImageIcon("logo_125_125.png");
        iconLabel = new JLabel(iconImage);
        nameLabel = new JLabel("Username:", SwingConstants.LEFT);
        passLabel = new JLabel("Password:", SwingConstants.LEFT);
        nameTextField = new JTextField(20);
        passTextField = new JPasswordField(20);
        submit = new JButton("Log in");

        add(iconLabel);
        add(nameLabel);
        add(nameTextField);
        add(passLabel);
        add(passTextField);
        add(submit);

        iconLabel.setBounds(0,10,iconImage.getIconWidth(),iconImage.getIconHeight());
        nameLabel.setBounds(130,50, 70,20);
        passLabel.setBounds(130,80, 70,20);
        nameTextField.setBounds(210, 50, 60, 20);
        passTextField.setBounds(210, 80, 60, 20);
        submit.setBounds(230, 110, 40, 20);

        setSize(300,200);
        setLocationRelativeTo(origin);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
}
