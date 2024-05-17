import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    public static void main(String[] args) {
        // LICZBA PÓL PLANSZY W JEDNYM RZĘDZIE
        int numOfTiles = 40;

        Board board = new Board(numOfTiles);
        ArrayList<Civilizations> array = new ArrayList<>();
        int [] boardList = new int[numOfTiles * numOfTiles];
        Timer[] timer = new Timer[1];
        timer[0] = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Civilizations x: array){
                    x.conquer();
                }
                timer[0].restart();
            }
        });

        //Losowanie koorydnatów
        int w1 = 0;
        ArrayList<Integer> pozycje = new ArrayList<>();
        while (w1<4) {
            Random rand = new Random();
            int n = rand.nextInt(numOfTiles*numOfTiles);
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


        array.add(new CivilizationUp(pozycje.get(0), 0, 0, 255, board, boardList, 1, numOfTiles));
        array.add(new CivilizationUp(pozycje.get(1), 0, 255, 0, board, boardList, 2, numOfTiles));
        array.add(new CivilizationLeft(pozycje.get(2), 255, 0, 0, board, boardList, 3, numOfTiles));
        array.add(new CivilizationLeft(pozycje.get(3), 255, 255, 0, board, boardList, 4, numOfTiles));

        timer[0].start();
    }

}
