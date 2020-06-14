package adventure;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Gui extends JFrame {

    private Game myGame;

    //dimensions
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int FSIZE = 18;

    public static final int C_WIDTH = 700;
    public static final int W_SIZE = 200;
    public static final int S_HEIGHT = 50;
    public static final int E_HEIGHT = 500;

    public static final String[] OPTIONS = { "Change Player Name", "Load JSON file",
            "Load Saved Game", "Save"};

    private JTextArea textArea;
    private JTextField commandLine;
    private JList<String> list;
    private JComboBox<String> menuBox;
    private JLabel inventory;
    private JLabel player;
    private JScrollPane listScroller;

    private JPanel southPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel center;


    /**
     * constructor
     * @param g
     */
    public Gui(Game g) {
        super("ADVENTURE GAME");
        setupSize();
        myGame = g;

        player = new JLabel("PLAYER NAME", JLabel.LEFT);
        menuBox = createMenu();
        westPanel = createWest();
        westPanel.add(player, BorderLayout.NORTH);
        westPanel.add(menuBox, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);


        textArea = createText();
        center = createCenter();
        center.add(textArea,BorderLayout.CENTER);
        add(center, BorderLayout.CENTER);

        inventory = new JLabel("INVENTORY", JLabel.RIGHT);
        String[] listItems = {"item1", "item2", "item3"};
        list = createList(listItems);
        listScroller = new JScrollPane(list);
        eastPanel = createEast();
        eastPanel.add(inventory,BorderLayout.NORTH);
        eastPanel.add(listScroller,BorderLayout.CENTER);
        add(eastPanel,BorderLayout.EAST);


        commandLine = createCommand();
        southPanel = createSouth();
        southPanel.add(commandLine, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);

    }

    /**
     * create panel on left side of window
     * @return westPanel
     */
    private JPanel createWest() {
        westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(W_SIZE,HEIGHT));
        westPanel.setBackground(Color.lightGray);
        return westPanel;
    }

    /**
     * create text area
     * @return textArea
     */
    private JTextArea createText() {
        textArea = new JTextArea("Description is here...");
        textArea.setPreferredSize(new Dimension(W_SIZE,HEIGHT));
        Font font = new Font("Times New Roman", Font.PLAIN, FSIZE);
        textArea.setFont(font);
        return textArea;
    }

    /**
     * create center panel
     * @return center
     */
    private JPanel createCenter() {
        center = new JPanel();
        center.setPreferredSize(new Dimension(W_SIZE,HEIGHT));
        center.setBackground(Color.white);
        return center;
    }

    /**
     * create east panel
     * @return eastPanel
     */
    private JPanel createEast() {
        eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(W_SIZE,E_HEIGHT));
        eastPanel.setBackground(Color.LIGHT_GRAY);
        return eastPanel;
    }

    /**
     * create south panel
     * @return southPanel
     */
    private JPanel createSouth() {
        southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(WIDTH,S_HEIGHT));
        southPanel.setBackground(Color.DARK_GRAY);
        return southPanel;
    }


    /** 
     * create command line for user input
     * @return commandLine
     */ 
    private JTextField createCommand() {
        commandLine = new JTextField("Type commands here...");
        commandLine.setEditable(true);
        commandLine.setPreferredSize(new Dimension(C_WIDTH,S_HEIGHT));
        return commandLine;
    }


    /** 
     * create single menu
     * @return menuBox
     */ 
    private JComboBox<String> createMenu() {
        menuBox = new JComboBox<String>(OPTIONS);
        menuBox.setEditable(false);
        menuBox.addActionListener(e-> {
            Object choice = menuBox.getSelectedItem();
            if (choice.toString().equals(OPTIONS[0])) {
                textArea.setText("You have chosen " + OPTIONS[0] + "\n");
            } else if (choice.toString().equals(OPTIONS[1])) {
                textArea.setText("You have chosen " + OPTIONS[1]);
            } else if (choice.toString().equals(OPTIONS[2])) {
                textArea.setText("You have chosen " + OPTIONS[2]);
            } else if (choice.toString().equals(OPTIONS[2+1])) {
                textArea.setText("You have chosen " + OPTIONS[2+1]);
            }
        });
        return menuBox;
    }
    
    
    /**
     * create list of
     * @param items
     * @return list
     */
   private JList<String> createList(String[] items) {
       list = new JList(items);
       list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       list.setLayoutOrientation(JList.VERTICAL);
       return list;
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
