import javax.swing.*;
import java.awt.*;
public class Board extends JFrame {
    private JPanel[][] gridPanels;
    public Board() {
        createUI();
    }
    public void createUI(){
        setTitle("Board");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new GridLayout(10, 10));
        setLocationRelativeTo(null);
        setVisible(true);

        gridPanels = new JPanel[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
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
