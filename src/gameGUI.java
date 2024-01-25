import javax.swing.*;
import java.awt.*;

public class gameGUI {

    public gameGUI() {
        JFrame frame = new JFrame();
        JPanel startPanel = new JPanel();

        // variables for the frame/window
        frame.setTitle("Number guessing game");
        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(startPanel);

        // might use group or spring
        startPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        startPanel.setBackground(Color.black);

        // title label
        gbc.gridx=0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy=0;
        JLabel welcomeTitle = new JLabel("Welcome to the number guessing game");
        welcomeTitle.setFont(new Font("Helvetica",Font.BOLD,24));
        welcomeTitle.setForeground(Color.GREEN);
        welcomeTitle.setHorizontalAlignment(JLabel.CENTER);
        welcomeTitle.setVerticalAlignment(JLabel.CENTER);
        welcomeTitle.setPreferredSize(new Dimension(600,50));
        startPanel.add(welcomeTitle,gbc);

        // label asking for the name of the person
        gbc.gridy=1;
        JLabel askName = new JLabel("Enter name:");
        askName.setFont(new Font("Cambria",Font.PLAIN,20));
        askName.setForeground(Color.GREEN);
        askName.setHorizontalAlignment(JLabel.CENTER);
        askName.setVerticalAlignment(JLabel.CENTER);
        askName.setPreferredSize(new Dimension(600,50));
        startPanel.add(askName,gbc);

        // input
        gbc.gridy=2;
        gbc.insets = new Insets(0,0,10,0);
        JTextField userName=new JTextField(20);
        userName.setFont(new Font("Cambria",Font.PLAIN,20));
        userName.setPreferredSize(new Dimension(200,25));
        startPanel.add(userName,gbc);

        // button to submit and start the next panel
        gbc.gridy=3;
        JButton submit = new JButton("Submit");
        submit.setPreferredSize(new Dimension(200,20));
        startPanel.add(submit,gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(gameGUI::new);
    }
}
