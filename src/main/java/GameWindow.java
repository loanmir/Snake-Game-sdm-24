import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class GameWindow extends JFrame implements ActionListener{
    private final SnakeMovement snakeMovement;
    private Direction keyEvent;
    //private final Board board;
    // Class extending JPanel for the game interface
    private final GamePanel gamePanel;

    // Jpanel for the menu interface
    JPanel menuPanel;

    // Buttons needed
    JButton newGameButton;
    JButton exitGameButton;

    public GameWindow(SnakeMovement snakeMovement) {
        this.snakeMovement = snakeMovement;
        //this.board = board;
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Default exit operation
        this.setLayout(new BorderLayout());
        this.gamePanel = new GamePanel(snakeMovement); // snakeMovement works as controller
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
        menuPanel.setBackground(Color.darkGray); // Set background color
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
        button.setFont(new Font("Calibri", Font.BOLD, 17)); // Set font
        button.setForeground(Color.WHITE); // Set text color
        button.setBackground(new Color(0x2dce98)); // Set background color
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding
        button.setPreferredSize(new Dimension(150, 45));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor on hover
        button.setUI(new StyledButton());
        return button;
    }

    class StyledButton extends BasicButtonUI{
        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(5, 15, 5, 15));

        }

        @Override
        public void paint (Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }

        private void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
        }

    }// StyledButton

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
        private Cell[][] board;


        public GamePanel(SnakeMovement snakeMovement){
            this.snakeMovement = snakeMovement;
            Cell[][] board = snakeMovement.getBoardState();
            this.setBoard(board);
            //this.board = board;
        }// constructor


        /*public GamePanel(Cell[][] Board){
            this.board = board;
            Cell[][] board = snakeMovement.getBoardState();
            this.setBoard(board);
        }// constructor*/

        public void setBoard(Cell[][] board) {
            this.board = board;
            repaint(); // Request the panel to be repainted
        }//setting up board

        @Override
        protected void paintComponent(Graphics g){
            //super.paintComponent(g);
            if(board != null){

                int cellSize = 20;


                for (int i = 0; i < board.length;i++){
                    //System.out.println(board[i].getBoardSize());
                    for(int j = 0; j < board[i].length; j++){
                        //System.out.println(board[i].length);
                        int x = j * cellSize; // Horizontal position of the cell
                        int y = i * cellSize; // Vertical position of the cell

                        switch(board[i][j]){
                            case BLANK:
                                g.setColor(Color.WHITE);
                                g.fillRect(x, y, cellSize, cellSize);
                                break;
                            case WALL:
                                g.setColor(Color.BLACK);
                                g.fillRect(x, y, cellSize, cellSize);
                                break;
                            case FOOD:
                                g.setColor(Color.RED);
                                g.fillOval(x, y, cellSize, cellSize);
                                break;
                            case SNAKE: //both body and head are green
                                g.setColor(Color.GREEN);
                                g.fillOval(x, y, cellSize, cellSize);
                                break;
                            default:
                                throw new RuntimeException("Draw game error out of bounds");
                        }//switch
                        g.fillOval(x, y, cellSize, cellSize);
                        /*if(i != 0 && i != board.length - 1 && j != 0 && j != board[i].length - 1 ){
                            g.setColor(Color.LIGHT_GRAY);
                            g.drawRect(x, y, cellSize, cellSize);
                        }*/
                    }
                }
                String scoreText = "Score: " + snakeMovement.getScore();
                g.setColor(Color.WHITE);
                g.drawString(scoreText, 10, getHeight() - 5);
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
            // Removing the menu panel and adding the GamePanel to the window
            frame.remove(menuPanel);
            frame.add(gamePanel,BorderLayout.CENTER);
            frame.setFocusable(true);
            frame.setFocusTraversalKeysEnabled(false);
            frame.addKeyListener(new ArrowKeyListener()); // Adding KeyListener for arrow keys
            frame.setSize(616,639);
            keyEvent = Direction.NULL;

            Cell[][] board = snakeMovement.getBoardState();
            gamePanel.setBoard(board);

            SwingUtilities.invokeLater(() -> {
                frame.setVisible(true); // Making the frame visible
                frame.requestFocusInWindow(); // Request focus
            });

            // Main game loop!
            while(true){
                try{

                    int speed = snakeMovement.getSpeed();
                    int sleepTime = 300 - speed;

                    if(sleepTime < 100){
                        sleepTime = 100; // Minimum sleep -> Not quicker than this
                    }

                    Thread.sleep(sleepTime);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                } // catch
                // snakeMovement.setCurrentDirection(keyEvent);  // this was the movement problem :^)
                Direction newDirection = keyEvent;
                snakeMovement.moveSnake(keyEvent);
                if(snakeMovement.isGameOver()){
                    break;
                }
                board = snakeMovement.getBoardState();
                gamePanel.setBoard(board);

            } // end While

            frame.remove(gamePanel);
            JLabel finalOutput;
            Cell[][] boardSize = snakeMovement.getBoardState();
            int max_length = (boardSize.length - 2)*(boardSize.length - 2);
            if(snakeMovement.isGameOver()){
                finalOutput = new JLabel("Game Over!!!");
            } else if (snakeMovement.getSnake().getCoordSnake().size() >= max_length){
                finalOutput = new JLabel("You won!!");
            } else{
                finalOutput = new JLabel("Provaaaa");
            }

            finalPanel(finalOutput);
        } // run method

        public void finalPanel(JLabel label){
            JPanel finalPanel = new JPanel();

            finalPanel.add(label);
            frame.add(finalPanel, BorderLayout.CENTER);

            frame.revalidate();
            frame.repaint();
        } //finalPanel

        class ArrowKeyListener extends KeyAdapter{
            @Override
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                switch(key){
                    case (KeyEvent.VK_LEFT):
                        keyEvent = Direction.LEFT;
                        break;
                    case (KeyEvent.VK_RIGHT):
                        keyEvent = Direction.RIGHT;
                        break;
                    case (KeyEvent.VK_UP):
                        keyEvent = Direction.UP;
                        break;
                    case (KeyEvent.VK_DOWN):
                        keyEvent = Direction.DOWN;
                        break;
                }
            }
        }//ArrowKeyListener
    }//GamePlay class


}// GameWindow class
