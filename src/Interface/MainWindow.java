package Interface;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JDesktopPane desktopPane;
    private  WindowAddStudent windowAddStudent;

    public MainWindow(){
        setTitle("Gestión de notas");
        setSize(700, 400);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        begin();
    }

    private void begin() {
        beginComponents();
        addComponents();
    }

    private void addComponents() {
        add(desktopPane, BorderLayout.CENTER);

    }

    private void beginComponents() {
        desktopPane = new JDesktopPane();
        windowAddStudent = new WindowAddStudent(desktopPane, this);
    }

    public WindowAddStudent getWindowAddStudent(){
        return windowAddStudent;
    }

    public void addStudent(){

    }
}
