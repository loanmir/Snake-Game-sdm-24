import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class GameWindow extends JFrame implements ActionListener{
    JPanel menuPanel;
    JButton newGameButton;
    JButton exitGameButton;

    public GameWindow() {
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Default exit operation
        this.setLayout(new BorderLayout());
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
            System.out.println("new game!!!!");
        } else if(e.getSource() == exitGameButton){
            this.dispose();
        }
    }
}
