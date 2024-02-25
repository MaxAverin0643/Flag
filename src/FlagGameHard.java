import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class FlagGameHard implements ActionListener { // Объявление класса FlagDemo который реализует интерфейс ActionListener

    StaticFrame staticFrame = new StaticFrame();

    long startTime = System.nanoTime();

    JLabel jlab = new JLabel("Угадайте флаг");//Создать метку
    JLabel jlab2 = new JLabel();//Создать метку

    JPanel jpanelJlab = new JPanel();

    FlagsNames flagsList = new FlagsNames();

    int number = 0;

    RaNdom raNdom = new RaNdom();
    int[] array = raNdom.yRandom(9);

    JLabel labelImage = new JLabel();
    ImageIcon flagImage = new ImageIcon(flagsList.flagsNames[array[number]][0]);

    JPanel jpanelImage = new JPanel();

    JPanel jpanelExcel = new JPanel();

    int[] nums = raNdom.yRandom(4);

    JButton jb1 = new JButton(flagsList.flagsNames[array[number]][nums[0] + 1]);
    JButton jb2 = new JButton(flagsList.flagsNames[array[number]][nums[1] + 1]);
    JButton jb3 = new JButton(flagsList.flagsNames[array[number]][nums[2] + 1]);
    JButton jb4 = new JButton(flagsList.flagsNames[array[number]][nums[3] + 1]);

    JButton jb5 = new JButton(" Завершить игру и выйти в меню");

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    ImageIcon flagLive = new ImageIcon("C:/Users/Caspe/IdeaProjects/Flag/src/ImagFlag/ScreensaverMini.png");

    FlagGameHard() { // Создаём конструктор

        labelImage.setIcon(flagImage);
        jpanelImage.add(labelImage);
        jpanelImage.setBounds(140, 5, 300, 200);
        staticFrame.bigWindow.add(jpanelImage);

        jpanelExcel.add(jb1);
        jpanelExcel.add(jb2);
        jpanelExcel.add(jb3);
        jpanelExcel.add(jb4);
        jpanelExcel.setBounds(85, 295, 400, 40);
        staticFrame.bigWindow.add(jpanelExcel);

        //Добавить слушателей действий
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);

        jb5.setBounds(330, 400, 240, 40);
        jb5.setFocusable(false);
        jb5.addActionListener(this);

        jpanelJlab.add(jlab);//Добавить метку во фрейм
        jpanelJlab.setBounds(200, 240, 200, 100);
        staticFrame.bigWindow.add(jpanelJlab);
        jpanelJlab.add(jlab2);//Добавить метку во фрейм

        staticFrame.bigWindow.add(jb5);

        if (EnteringName.flag) {
            jLabel1.setIcon(flagLive);
            jLabel2.setIcon(flagLive);
            jLabel3.setIcon(flagLive);
            jLabel1.setBounds(70, 400, 40, 40);
            jLabel2.setBounds(130, 400, 40, 40);
            jLabel3.setBounds(190, 400, 40, 40);
            staticFrame.bigWindow.add(jLabel1);
            staticFrame.bigWindow.add(jLabel2);
            staticFrame.bigWindow.add(jLabel3);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ((ae.getSource() == jb5) | (flagsList.flagsNames.length == number + 1)) {
            staticFrame.bigWindow.dispose();

            String stringCorrectAnswer = String.valueOf(StaticFrame.correctAnswer);//String.valueOf - преобразует число "correctAnswer" в строку
            Statistics.data[EnteringName.nameСounter][1] = stringCorrectAnswer;

            String stringWrongAnswer = String.valueOf(StaticFrame.wrongAnswer);
            Statistics.data[EnteringName.nameСounter][2] = stringWrongAnswer;

            long endTime = System.nanoTime();
            long timeSpend = endTime - startTime;
            String stringTimeElapsedr = String.valueOf(timeSpend / 1000000000);
            Statistics.data[EnteringName.nameСounter][3] = stringTimeElapsedr;

            Result result = new Result();
            StaticFrame.correctAnswer = 0;
            StaticFrame.wrongAnswer = 0;
            EnteringName.nameСounter++;

        } else if (ae.getActionCommand().equals(flagsList.flagsNames[array[number]][1])) {
            jlab.setText(" ");
            jlab2.setText(" ");

            StaticFrame.correctAnswer++;
            String stringCorrectAnswer = String.valueOf(StaticFrame.correctAnswer);
            Statistics.data[EnteringName.nameСounter][1] = stringCorrectAnswer;

            jpanelExcel.setBackground(Color.GREEN);

        } else {
            jlab.setText("Не верно.");
            StaticFrame.wrongAnswer++;
            String stringWrongAnswer = String.valueOf(StaticFrame.wrongAnswer);
            Statistics.data[EnteringName.nameСounter][2] = stringWrongAnswer;
            jlab2.setText(flagsList.flagsNames[array[number]][1]);
            jpanelExcel.setBackground(Color.RED);

            if (EnteringName.flag) {
                switch (StaticFrame.wrongAnswer) {
                    case 1:
                        jLabel3.hide();
                        staticFrame.bigWindow.repaint();
                        break;
                    case 2:
                        jLabel2.hide();
                        staticFrame.bigWindow.repaint();
                        break;
                    case 3:
                        Result result = new Result();
                        break;
                }
            }

        }

        if (flagsList.flagsNames.length == number + 1) {
            jlab2.setText("Флаги кончались");
        }

        number++;

        flagImage = new ImageIcon(flagsList.flagsNames[array[number]][0]);

        int[] nums = raNdom.yRandom(4);

        jb1.setText(flagsList.flagsNames[array[number]][nums[0] + 1]);
        jb2.setText(flagsList.flagsNames[array[number]][nums[1] + 1]);
        jb3.setText(flagsList.flagsNames[array[number]][nums[2] + 1]);
        jb4.setText(flagsList.flagsNames[array[number]][nums[3] + 1]);

        jpanelExcel.add(jb1);
        jpanelExcel.add(jb2);
        jpanelExcel.add(jb3);
        jpanelExcel.add(jb4);

        labelImage.setIcon(flagImage);
        jpanelImage.add(labelImage);
    }
}

