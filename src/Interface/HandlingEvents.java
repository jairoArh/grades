package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlingEvents implements ActionListener {
    static final String add_Student = "Agregar Estudiante";

    private MainWindow mainWindow;

    public HandlingEvents( MainWindow mainWindow ){
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case add_Student:
        }
    }
}
