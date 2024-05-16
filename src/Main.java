import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {




    public static void main(String[] args) {
        Board board = new Board();
        ArrayList<Civilizations> array = new ArrayList<>();
        int [] boardList = new int[100];

        //Losowanie koorydnatów
        int w1 = 0;
        ArrayList<Integer> pozycje = new ArrayList<>();
        while (w1<4) {
            Random rand = new Random();
            int n = rand.nextInt(100);
            int jest = 0;

            for(Integer x : pozycje){
                if(n == x){
                    jest++;
                }
            }
            if(jest==0){
                pozycje.add(n);
                w1++;
            }

        }


        array.add(new Civilizations(pozycje.get(0), 0, 0, 255, board, boardList, 1));
        array.add(new Civilizations(pozycje.get(1), 0, 255, 0, board, boardList, 2));
        array.add(new Civilizations(pozycje.get(2), 255, 0, 0, board, boardList, 3));
        array.add(new Civilizations(pozycje.get(3), 200, 50, 50, board, boardList, 4));
    }

}
