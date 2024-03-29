package gui;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {

    private final JButton ButtonSubmit;
    private JButton buttonYes;
    private final JLabel TitleLabel;
    private final JLabel SubTitleLabel;
    private final JLabel ThirdTextLabel;
    private JTextField specialInputField;

    public CustomPanel(String Title, String subtitle, String thirdText, boolean special, String button2Text) {
        // variables for the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.black);

        // title
        gbc.gridy=0;
        TitleLabel=setLabel(Title, "Helvetica", Font.BOLD, 24);
        add(TitleLabel,gbc,0);

        // subtitle
        gbc.gridy=1;
        SubTitleLabel=setLabel(subtitle, "Cambria", Font.PLAIN, 20);
        add(SubTitleLabel,gbc,1);

        // 3rd text
        gbc.gridy=2;
        ThirdTextLabel=setLabel(thirdText, "Cambria", Font.PLAIN, 20);
        add(ThirdTextLabel,gbc,2);

        // the 4th object in the panel
        gbc.gridy=3;
        gbc.insets = new Insets(0,0,10,0);
        // variable special used to determine the 4th object in the GUI
        if (special) {
            // input field that allow the user to guess
            specialInputField = new JTextField();
            specialInputField.setColumns(10);
            specialInputField.setFont(new Font("Cambria",Font.PLAIN,25));
            specialInputField.setPreferredSize(new Dimension(200,30));
            add(specialInputField,gbc);
        } else {
            // otherwise create a button
            buttonYes = new JButton("Yes");
            buttonYes.setPreferredSize(new Dimension(200,30));
            add(buttonYes,gbc);
        }

        // button to submit and start the next panel
        gbc.gridy=4;
        ButtonSubmit = new JButton(button2Text);
        ButtonSubmit.setPreferredSize(new Dimension(200,30));
        add(ButtonSubmit,gbc);

    }

    private JLabel setLabel(String text, String fontType, int fontStyle, int fontSize) {
        // labels have similar styles with only slight alterations that are used as the inputs to this function
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontType, fontStyle, fontSize));
        label.setForeground(Color.green);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(600, 50));
        return label;
    }

    // methods that get the panel variables to be used
    public JButton getSubmitButton() {
        return ButtonSubmit;
    }

    public JButton getButtonYes() {
        return buttonYes;
    }

    public JTextField getSpecialInputField() { return specialInputField;}

    public String getSubmissionText() {
        return specialInputField.getText();
    }

    // methods that change the value of specific labels on the panel
    public void setTitleText(String text) {
        TitleLabel.setText(text);
    }

    public void setSubtitleText(String text) {
        SubTitleLabel.setText(text);
    }

    public void setThirdText(String text) {
        ThirdTextLabel.setText(text);
    }

    public void resetSpecialInputText() {
        specialInputField.setText("");
    }

    // removes the button for the game stats screen
    public void removeButton() {
        remove(buttonYes);
        revalidate();
        repaint();
    }
}