import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {
    public static void main(String[] args) {
        Board board = new Board();
        ArrayList<Civilizations> array = new ArrayList<>();
        int [] boardList = new int[100];
        array.add(new Civilizations(69, Color.RED, board, boardList, 1));
        array.add(new Civilizations(9, Color.BLUE, board, boardList, 2));
        array.add(new Civilizations(90, Color.GREEN, board, boardList, 3));
        array.add(new Civilizations(99, Color.YELLOW, board, boardList, 4));
    }
}
