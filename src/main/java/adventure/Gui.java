package adventure;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui extends JFrame {

    private Game myGame;

    //dimensions
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final String[] options = {
            "Change Player Name", "Load JSON file", "Load Saved Game", "Save"
    };

    private JTextArea textArea;
    private JTextField commandLine;
    private JList<String> list;
    private JComboBox<String> menuBox;
    private JLabel inventory;
    private JLabel player;

    private JPanel southPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel center;


    /**
     * constructor
     * @param g
     */
    public Gui(Game g) {
        super();
        setTitle("ADVENTURE GAME");
        setupSize();
        
        myGame = g; 



        player = new JLabel("PLAYER NAME", JLabel.LEFT);
        menuBox = createMenu();
        menuBox.addActionListener(e-> {
            Object choice = menuBox.getSelectedItem();
            if (choice.toString().equals(options[0])) {
                textArea.setText("You have chosen " + options[0]);

            } else if (choice.toString().equals(options[1])) {
                textArea.setText("You have chosen " + options[1]);

            } else if (choice.toString().equals(options[2])) {
                textArea.setText("You have chosen " + options[2]);

            } else if (choice.toString().equals(options[3])) {
                textArea.setText("You have chosen " + options[3]);

            }
        });

        westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(200,500));
        westPanel.setBackground(Color.lightGray);
        westPanel.add(player, BorderLayout.NORTH);
        westPanel.add(menuBox, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);


        textArea = new JTextArea("Description is here...");
        textArea.setSize(400,600);
        center = new JPanel();
        center.setPreferredSize(new Dimension(200,600));
        center.add(textArea,BorderLayout.CENTER);
        add(center, BorderLayout.CENTER);

        inventory = new JLabel("INVENTORY", JLabel.RIGHT);
        String[] listItems = { "item1", "item2", "item3", "item4"};
        list = new JList<String>(listItems);
        eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(200,500));
        eastPanel.setBackground(Color.LIGHT_GRAY);
        eastPanel.add(inventory,BorderLayout.NORTH);
        eastPanel.add(list,BorderLayout.CENTER);
        add(eastPanel,BorderLayout.EAST);


        commandLine = createCommand();
        southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(800,50));
        southPanel.setBackground(Color.LIGHT_GRAY);
        southPanel.add(commandLine, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);
     

    }



    /** 
     * create command line for user input 
     */ 
    private JTextField createCommand() {
        commandLine = new JTextField("Type commands here...");
        commandLine.setEditable(true);
        commandLine.setPreferredSize(new Dimension(700,40));
        return commandLine;
    }


    /** 
     * create single menu
     */ 
    private JComboBox<String> createMenu() {
        menuBox = new JComboBox<String>(options);
        menuBox.setEditable(false);
        menuBox.setMaximumSize(menuBox.getPreferredSize());
        return menuBox;
    }

    /**
     * set up window of GUI
     */
    private void setupSize() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }


    public static void main(String[] args) {
		Game g = new Game();
        Gui gui = new Gui(g);
        gui.setVisible(true);
    }



}
