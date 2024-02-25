import javax.swing.*;

public class StaticFrame {

    static int correctAnswer = 0;
    static int wrongAnswer = 0;

    JFrame bigWindow = new JFrame("Приложение угадай флаг"); // Создаём главный контейнер

    StaticFrame() {
        bigWindow.setSize(600, 500); // Задаём размер фрейма
        bigWindow.setResizable(false); // Делаем рамку статичной одного размера
        bigWindow.setLocationRelativeTo(null); // Делает окно по центру
        bigWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Прекращение работы при закрытии приложения
        bigWindow.setLayout(null);
        bigWindow.setVisible(true);
    }
}
