import javax.swing.*;
import java.awt.*;
public class Board extends JFrame {
    private JPanel[][] gridPanels;
    public Board(int n) {
        createUI(n);
    }
    public void createUI(int n){
        setTitle("Board");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new GridLayout(n, n));
        setLocationRelativeTo(null);
        setVisible(true);

        gridPanels = new JPanel[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                JPanel cellPanel = new JPanel();
                cellPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                add(cellPanel);
                gridPanels[i][j] = cellPanel;
            }
        }
    }
    public void updateCell(int x, int y, Color color) {
        gridPanels[x][y].setBackground(color);
    }
}
