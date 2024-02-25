import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Statistics implements ActionListener {

    StaticFrame staticFrame = new StaticFrame();

    JButton myButton = new JButton("Вернуться в меню");

    JLabel jLabel = new JLabel("Таблица рекордов");

    String[] columnNames = {
            "Игрок",
            "Правильных ответов",
            "Неправильных ответов",
            "Затраченное время"
    };
    static String[][] data;
    static String[][] tmp;

    JTable table = new JTable(data, columnNames);

    JScrollPane scrollPane = new JScrollPane(table);

    Statistics() {

        myButton.setBounds(330, 400, 240, 40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        scrollPane.setBounds(30, 50, 500, 300);

        staticFrame.bigWindow.add(scrollPane);

        staticFrame.bigWindow.add(myButton);
        jLabel.setBounds(230, 5, 520, 25);
        staticFrame.bigWindow.add(jLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == myButton) {
            staticFrame.bigWindow.dispose();

        }
    }
}
