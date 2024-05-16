import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        ArrayList<Civilizations> array = new ArrayList<>();
        int [] boardList = new int[100];
        array.add(new Civilizations(69, 0, 0, 255, board, boardList, 1));
        array.add(new Civilizations(9, 0, 255, 0, board, boardList, 2));
        array.add(new Civilizations(90, 255, 0, 0, board, boardList, 3));
        array.add(new Civilizations(99, 200, 50, 50, board, boardList, 4));
    }
    //hehe
}
