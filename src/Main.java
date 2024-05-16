import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    /*
    public Main(){
        setTitle("Plansza");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    przeniesione do Board
    */

    public static void main(String[] args) {
        Board board = new Board();
        board.updateCell(0,0, Color.BLUE);
        board.updateCell(9,0, Color.RED);
        board.updateCell(0,9, Color.GREEN);
        board.updateCell(9,9, Color.YELLOW);
    }
    //hehe
}
