import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EnteringName extends JFrame implements ActionListener {

    StaticFrame staticFrame = new StaticFrame();

    JButton myButton = new JButton("Вернуться в меню");
    JButton myButtonHard = new JButton("Сложный режим");
    JButton myButtonLow = new JButton("Обычный режим");

    JTextField jTextField = new JTextField("Введите имя:", 25);

    JLabel jLabel = new JLabel("Введите имя для начала игры");

    static int nameСounter = 0;

    static boolean flag = false;

    EnteringName() {
        setLayout(null);
        jLabel.setFocusable(true);
        jLabel.setBounds(80, 50, 450, 25);
        jLabel.setFont(new Font(null, Font.ITALIC, 25));

        jTextField.addActionListener(this);
        jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        jTextField.setBounds(150, 200, 300, 25);
        jTextField.setHorizontalAlignment(JTextField.HORIZONTAL);
        jTextField.setBackground(Color.white);
        jTextField.setForeground(Color.BLACK.brighter());

        myButton.setBounds(330, 400, 240, 40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        myButtonHard.setBounds(15, 250, 240, 40);
        myButtonHard.setFocusable(false);
        myButtonHard.addActionListener(this);

        myButtonLow.setBounds(330, 250, 240, 40);
        myButtonLow.setFocusable(false);
        myButtonLow.addActionListener(this);

        staticFrame.bigWindow.add(jLabel);
        staticFrame.bigWindow.add(myButton);

        staticFrame.bigWindow.add(jTextField);
        jTextField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                staticFrame.bigWindow.add(myButtonHard);
                staticFrame.bigWindow.add(myButtonLow);
                staticFrame.bigWindow.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ee) {

        String getValue = jTextField.getText();


        if (ee.getSource() == myButtonLow) {

            action(getValue); // Метод для перерисовки массива и добавления новых пользователей
            staticFrame.bigWindow.dispose();

            new FlagGameHard();
        }

        if (ee.getSource() == myButtonHard) {

            action(getValue); // Метод для перерисовки массива и добавления новых пользователей
            staticFrame.bigWindow.dispose();
            flag = true;

            new FlagGameHard();
        }

        if (ee.getSource() == myButton) {
            staticFrame.bigWindow.dispose();


        }

    }

    static void action(String name) {
        if (Statistics.data == null) {

            Statistics.data = new String[][]{};

        }
        int length = Statistics.data.length;
        String[][] tmp = new String[length + 1][4];
        System.arraycopy(Statistics.data, 0, tmp, 0, length);
        tmp[length][0] = name;
        Statistics.data = tmp;
    }
}
