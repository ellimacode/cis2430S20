package adventure;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui extends JFrame {

    private Game game;

    //dimensions
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;

    /**
     * constructor
     * @param g
     */
    public Gui(Game myGame) {
        super();
        game = myGame;
        setSize(WIDTH, HEIGHT);
        setTitle("ADVENTURE GAME");

        //to close window and exit program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        //create a label
        JLabel label = new JLabel("Label");
        contentPane.add(label);

        //create a panel, type of container
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        //create a second label, add to panel
        JLabel label1 = new JLabel("Lambda Listeners");
        panel.add(label1);
        //create a text field, add to panel
        TextField text = new TextField("This is a text field.");
        panel.add(text);

        //add panel to container
        contentPane.add(panel);

    }

    public static void main(String[] args) {
        Game game = new Game();
        Gui gui = new Gui(game);
        gui.setVisible(true);
    }



}