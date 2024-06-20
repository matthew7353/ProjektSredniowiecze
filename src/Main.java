import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JFrame {
    public static void main(String[] args) {
        // LICZBA PÓL PLANSZY W JEDNYM RZĘDZIE
        int numOfTiles = 10;


        ArrayList<Civilizations> civilizationsInPlay = new ArrayList<>();
        int[] boardList = new int[numOfTiles * numOfTiles];
        Timer[] timer = new Timer[1];
        Board board = new Board(numOfTiles);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Saving data before exit...");
            DataLogger.logData("SimulationData", civilizationsInPlay);
        }));

        timer[0] = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Civilizations x : civilizationsInPlay) {
                    x.conquer();
                }
                timer[0].restart();
            }
        });

        //Losowanie koorydnatów
        int w1 = 0;
        ArrayList<Integer> positions = new ArrayList<>();
        while (w1 < 4) {
            Random rand = new Random();
            int n = rand.nextInt(numOfTiles * numOfTiles);
            int i = 0;

            for (Integer x : positions) {
                if (n == x) {
                    i++;
                }
            }
            if (i == 0) {
                positions.add(n);
                w1++;
            }

        }


        civilizationsInPlay.add(new CivilizationCircle(positions.get(0), Color.RED, board, boardList, 1, numOfTiles, 99, 10, 1));
        civilizationsInPlay.add(new CivilizationCircle(positions.get(1), Color.GREEN, board, boardList, 2, numOfTiles, 10, 99, 1));
        civilizationsInPlay.add(new CivilizationCircle(positions.get(2), Color.BLUE, board, boardList, 3, numOfTiles, 50, 50, 1));

        for (Civilizations civ : civilizationsInPlay) {
            civ.setAllCivilizations(civilizationsInPlay);
        }

        timer[0].start();
    }
}
