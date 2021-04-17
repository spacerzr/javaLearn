import javax.swing.*;
import java.awt.*;

public class ResultWindow extends JFrame {

    private final String text;

    public ResultWindow(String text) {
        this.text = text;
        init();
    }

    private void init() {
        setSize(300, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Результат");
        setLayout(new FlowLayout());
        add(new JLabel(text));
        setVisible(true);
    }
}
