import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Menu extends JComponent implements ActionListener {

    StaticFrame staticFrame = new StaticFrame();

    JLabel label = new JLabel("Добро пожаловать в игру Угадай флаг!");
    JButton myButton = new JButton("Таблица рекордов");
    JButton myButton2 = new JButton("Начать игру");

    JLabel jLabel = new JLabel();
    JPanel jPanel = new JPanel();
    ImageIcon flagImage = new ImageIcon("C:/Users/Caspe/IdeaProjects/Flag/src/ImagFlag/Screensaver.png");

    File file = new File("output.txt");
    PrintWriter out = new PrintWriter(file);
    FileReader in = new FileReader(file);


    Menu() throws FileNotFoundException {


        myButton.setBounds(15, 400, 240, 40);
        myButton2.setBounds(330, 400, 240, 40);
        myButton.setFocusable(false);
        myButton2.setFocusable(false);
        myButton.addActionListener(this);
        myButton2.addActionListener(this);

        label.setBounds(50, 50, 500, 25);
        label.setFont(new Font(null, Font.PLAIN, 25));

        staticFrame.bigWindow.add(label);

        staticFrame.bigWindow.add(myButton);
        staticFrame.bigWindow.add(myButton2);


        jLabel.setIcon(flagImage);
        jLabel.setBounds(0, 0, 600, 500);
        staticFrame.bigWindow.add(jLabel);


    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            File file = new File("output.txt");
            PrintWriter out = new PrintWriter(file);
            FileReader in = new FileReader(file);
            String[] columnNames = {
                    "Игрок",
                    "Правильных ответов",
                    "Неправильных ответов",
                    "Затраченое время",

            };


            @Override
            public void run() {
                try {
                    new Menu();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        

        if (e.getSource() == myButton) {
            staticFrame.bigWindow.dispose();
            Statistics statistics = new Statistics();
        }
        if (e.getSource() == myButton2) {
            staticFrame.bigWindow.dispose();
            EnteringName enteringName = new EnteringName();
        }

    }
}
