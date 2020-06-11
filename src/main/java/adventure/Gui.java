package adventure;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui extends JFrame {

    private Game game;

    //dimensions
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public static final String[] options = {
            "Change Player Name", "Load JSON file", "Load Saved Game", "Save"
    };

    private Container contentPane;
    private BorderLayout layout;
    private JLabel label;

    private JComboBox<String> menuBox;
    private JTextArea textArea;
    private JTextField commandLine;


    /**
     * constructor
     * @param g
     */
    public Gui(Game myGame) {
        super("ADVENTURE GAME");
        setupSize();

        layout = new BorderLayout();
        layout.setHgap(10);
        layout.setVgap(10);

        setLayout(layout);

        label = new JLabel("LABEL");
        add(label);

        menuBox = createMenu();
        add(menuBox, BorderLayout.LINE_START);

        textArea = new JTextArea("Description is here...");
        textArea.setSize(100,50);
        add(textArea, BorderLayout.CENTER);
        menuBox.addActionListener(e->JOptionPane.showMessageDialog(null, "Handled Lambda Listener!"));


        commandLine = createCommand();
        add(commandLine, BorderLayout.SOUTH);


    }



    //create command line for user input
    private JTextField createCommand() {
        commandLine = new JTextField("Type commands here...");
        commandLine.setEditable(true);
        return commandLine;
    }


    //create single menu
    private JComboBox<String> createMenu() {
        menuBox = new JComboBox<String>(options);
        menuBox.setMaximumSize(menuBox.getPreferredSize());
        return menuBox;
    }

    //set up size of window
    private void setupSize() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    //launcher
    public static void main(String[] args) {
        Game game = new Game();
        Gui gui = new Gui(game);
        gui.setVisible(true);
    }



}