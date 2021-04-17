import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements ActionListener {

    private final JButton btnLogin = new JButton("Войти");
    private final JButton btnForgot = new JButton("Забыли пароль ?");
    private final JTextField login = new JTextField();
    private final JPasswordField password = new JPasswordField();

    public LoginWindow() {
        init();
    }

    private void init() {
        //задаем настройки окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Мое графическое приложение");
        setLayout(new GridLayout(3, 1));

        //создаем верхнюю панель
        JPanel upPanel = new JPanel(new FlowLayout());
        JLabel upText = new JLabel("Добро пожаловать");
        upPanel.add(upText);

        //создаем среднюю панель
        JPanel middlePanel = new JPanel(new GridLayout(2, 2));
        JLabel loginText = new JLabel("Логин");
        loginText.setHorizontalAlignment(JTextField.CENTER);
        JLabel passwordText = new JLabel("Пароль");
        passwordText.setHorizontalAlignment(JTextField.CENTER);
        login.setHorizontalAlignment(JTextField.CENTER);
        password.setHorizontalAlignment(JPasswordField.CENTER);
        middlePanel.add(loginText);
        middlePanel.add(login);
        middlePanel.add(passwordText);
        middlePanel.add(password);

        //создаем нижнюю панель
        JPanel downPanel = new JPanel(new GridLayout(1, 2));
        JPanel downLeftPanel = new JPanel(new FlowLayout());
        JPanel downRightPanel = new JPanel(new FlowLayout());

        downLeftPanel.add(btnLogin);
        downRightPanel.add(btnForgot);
        downPanel.add(downLeftPanel);
        downPanel.add(downRightPanel);

        //Добавляем обработчик событий на кнопки
        btnLogin.addActionListener(this);
        btnForgot.addActionListener(this);
        //помещаем панели на окно
        add(upPanel);
        add(middlePanel);
        add(downPanel);
        setVisible(true);
    }

    //определяем источник события и направляем в соответствующий метод для обработки нажатия кнопки
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == btnLogin) {
            handleBtnLogin();
        }

        if(event.getSource() == btnForgot) {
            handleBtnForgot();
        }
    }

    // обработка нажатия кнопки логин
    private void handleBtnLogin() {
        String incomingLogin = login.getText();
        String incomingPassword = String.valueOf(password.getPassword());

        String password = Users.users.get(incomingLogin);
        if(password == null) {
            new ResultWindow("Пользователь не найден");
        } else if(password.equals(incomingPassword)) {
            new ResultWindow("Пароль верен ! WELCOME !");
        } else {
            new ResultWindow("Пароль не верен !");
        }
    }

    // обработка нажатия кнопки забыли пароль
    private void handleBtnForgot() {
        new ResultWindow("Ваш пароль: " + Users.users.get(login.getText()));
    }
}
