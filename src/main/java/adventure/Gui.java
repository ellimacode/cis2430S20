package adventure;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui extends JFrame {

    private Game game;

    //dimensions
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;

    private Container contentPane;
    private BorderLayout layout;
    private JLabel label;
    private JTextField item1;
    private JTextField item2;


    /**
     * constructor
     * @param g
     */
    public Gui(Game myGame) {
        super("ADVENTURE GAME");
        game = myGame;
        setupSize();

        layout = new BorderLayout();
        layout.setHgap(10);
        layout.setVgap(10);

        setLayout(layout);

        label = new JLabel("LABEL");
        label.setToolTipText("This is gonna show up on hover");
        add(label);

        item1 = new JTextField(10);
        add(item1, BorderLayout.LINE_START);

        item2 = new JTextField("enter text here");
        add(item2, BorderLayout.CENTER);

        item1.addActionListener(e->JOptionPane.showMessageDialog(null, "Handled Lambda Listener!"));


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