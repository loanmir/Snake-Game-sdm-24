import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class GameWindow extends JFrame implements ActionListener{
    private final SnakeMovement snakeMovement;
    private final Board board;
    // Class extending JPanel for the game interface
    private final GamePanel gamePanel;

    // Jpanel for the menu interface
    JPanel menuPanel;

    // Buttons needed
    JButton newGameButton;
    JButton exitGameButton;

    public GameWindow(SnakeMovement snakeMovement, Board board) {
        this.snakeMovement = snakeMovement;
        this.board = board;
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Default exit operation
        this.setLayout(new BorderLayout());
        this.gamePanel = new GamePanel(snakeMovement, board); // snakeMovement works as controller
        this.menuPanel = setMenu();
        this.add(menuPanel);
        this.setVisible(true);
        this.setSize(650, 650);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
    }

    public JPanel setMenu() {
        JPanel menuPanel = new JPanel();
        // Setting grid layout of 4 rows and 1 column
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 250));
        menuPanel.setBackground(Color.RED); // Set background color
        newGameButton = createStyledButton("New Game");
        newGameButton.addActionListener(this);
        exitGameButton = createStyledButton("Exit Game");
        exitGameButton.addActionListener(this);

        //Adding buttons to panel
        menuPanel.add(newGameButton);
        menuPanel.add(exitGameButton);

        return menuPanel;
    }


    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Set font
        button.setForeground(Color.WHITE); // Set text color
        button.setBackground(Color.BLUE); // Set background color
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding
        button.setPreferredSize(new Dimension(250, 75));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor on hover
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == newGameButton){
            GamePlay gameplay = new GamePlay(this);
            gameplay.start();
            //System.out.println("new game!!!!");
        } else if(e.getSource() == exitGameButton){
            this.dispose();
        } else {
            throw new IllegalStateException("Unexpected value: " + e.getSource());
        }
    }

    static class GamePanel extends JPanel {
        private final SnakeMovement snakeMovement;
        private final Board board;


        public GamePanel(SnakeMovement snakeMovement, Board board){
            this.snakeMovement = snakeMovement;
            //Cell[][] board = snakeMovement.getBoardState();
            //this.setBoard(board);
            this.board = board;
        }// constructor


        /*public GamePanel(Cell[][] Board){
            this.board = board;
            Cell[][] board = snakeMovement.getBoardState();
            this.setBoard(board);
        }// constructor*/

        /*public void setBoard(Cell[][] board) {
            this.board = board;
            repaint(); // Request the panel to be repainted
        }//setting up board*/

        @Override
        protected void paintComponent(Graphics g){
            //super.paintComponent(g);
            if(board != null){

                int cellSize = 20;


                for (int i = 0; i < board.getBoardSize();i++){
                    //System.out.println(board[i].getBoardSize());
                    for(int j = 0; j < board.getBoardSize(); j++){
                        //System.out.println(board[i].length);
                        int x = j * cellSize; // Horizontal position of the cell
                        int y = i * cellSize; // Vertical position of the cell

                        switch(board.getCell(i,j)){
                            case BLANK:
                                g.setColor(Color.WHITE);
                                break;
                            case WALL:
                                g.setColor(Color.BLACK);
                                break;
                            case FOOD:
                                g.setColor(Color.RED);
                                break;
                            case BODY:
                                g.setColor(Color.GREEN);
                                break;
                            case HEAD:
                                g.setColor(Color.BLUE);
                                break;
                            default:
                                throw new RuntimeException("Draw game error out of bounds");
                        }//switch
                        if (i==0 && j==0) {g.setColor(Color.YELLOW);}
                        if (i==board.getBoardSize()-1 && j==board.getBoardSize()-1) {g.setColor(Color.magenta);}
                        g.fillRect(x, y, cellSize, cellSize);
                    }
                }
                g.setColor(Color.BLACK);
            }// if statement

        }

    }// GamePanel class

    class GamePlay extends Thread{
        private final JFrame frame;

        public GamePlay(JFrame frame){
            this.frame = frame;
        }

        @Override
        public void run(){
            frame.remove(menuPanel);
            frame.add(gamePanel,BorderLayout.CENTER);
            frame.setFocusable(true);

            frame.setSize(616,639);

            Cell[][] board = snakeMovement.getBoardState();
            //gamePanel.setBoard(board);

            frame.setVisible(true);


        }
    }//GamePlay class


}// GameWindow class
