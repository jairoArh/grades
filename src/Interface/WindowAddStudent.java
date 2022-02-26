package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WindowAddStudent extends JInternalFrame {

    private JTextField name;
    private JTextField code;
    private JButton addStudent;
    private DefaultTableModel model;
    private JTable students;
    private GridBagConstraints gbc = new GridBagConstraints();

    private JDesktopPane desktopPane;
    private MainWindow mainWindow;


    public WindowAddStudent(JDesktopPane desktopPane, MainWindow main){
        this.desktopPane = desktopPane;
        this.mainWindow = main;
        setTitle("Agregar estudiante");
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setClosable( true );
        setIconifiable( true );
        setLayout( new GridBagLayout());
        desktopPane.add( this );
        begin();
    }

    private void begin() {
        beginComponent();
        addComponents();
        this.setVisible( true );
    }

    private void addComponents() {

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel("Código"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(new JLabel("Nombre"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(code, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(name, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        add(addStudent, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(students), gbc);

    }

    private void beginComponent() {
        name = new JTextField();
        code = new JTextField();

        addStudent = new JButton("Agregar Estudiante");
        addStudent.setActionCommand(HandlingEvents.add_Student);
        addStudent.addActionListener(new HandlingEvents(mainWindow));

        Object[] titles = {"Código", "Nombre"};
        model = new DefaultTableModel(titles, 1);
        students = new JTable(model);

    }

    public String getCode(){
        return code.getText();
    }

    public String getName() {
        return name.getText();
    }

    public void addRow(Object [] data){
        model.addRow(data);
    }

    public void cleanFields(){
        code.setText("");
        name.setText("");
    }

}
