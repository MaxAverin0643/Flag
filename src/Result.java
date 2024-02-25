import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Result implements ActionListener {

    StaticFrame staticFrame = new StaticFrame();

    JButton myButton = new JButton("Вернуться в меню");

    JLabel jLabel = new JLabel("Вы дали: " + StaticFrame.correctAnswer +
            " верных ответа, и " + StaticFrame.wrongAnswer + " неверных.");

    Result() {

        myButton.setBounds(330, 400, 240, 40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        jLabel.setBounds(50, 50, 500, 25);

        staticFrame.bigWindow.add(myButton);
        staticFrame.bigWindow.add(jLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == myButton) {
            staticFrame.bigWindow.dispose();

        }
    }
}
