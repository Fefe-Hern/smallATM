package atm;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
    /**
     * Creates the window/frame for either entering an ID or creating a new ID.
     */
    public static void createLoginArea() {
        JFrame loginFrame = new JFrame("Log In:");
        loginFrame.add(createInputSection());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(200, 100);
        loginFrame.setLocation(900, 500);
        loginFrame.setVisible(true);
    }

    /**
     * Creates the specific panel which holds the components for logging in.
     */
    private static JPanel createInputSection() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        JLabel idLabel = new JLabel("Enter ID: ");
        JTextField idTextField = new JTextField(4);
        JButton loginButton = new JButton("Log In");
        JButton createAccountButton = new JButton("Create ID");
        createActionListeners(loginButton, createAccountButton);
        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(loginButton);
        panel.add(createAccountButton);
        return panel;
    }

    private static void createActionListeners(JButton loginButton, JButton createAccountButton) {
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        
        });
        
        createAccountButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        
        });
    }
}
