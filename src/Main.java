import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    int numOfTiles = 10;
    int timerDelay = 100;
    public static void main(String[] args) {
        // LICZBA PÓL PLANSZY W JEDNYM RZĘDZIE
        Main mainObject = new Main();

        Board board = new Board(mainObject.numOfTiles);
        ArrayList<Civilizations> civilizationsInPlay = new ArrayList<>();
        int [] boardList = new int[mainObject.numOfTiles * mainObject.numOfTiles];

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Saving data before exit...");
            DataLogger.logData("SimulationData", civilizationsInPlay);
        }));
        Timer[] timer = new Timer[1];
        timer[0] = new Timer(mainObject.timerDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Civilizations x: civilizationsInPlay){
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
            int n = rand.nextInt(mainObject.numOfTiles * mainObject.numOfTiles);
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


        civilizationsInPlay.add(new CivilizationCircle(pozycje.get(0), Color.RED, board, boardList, 1, mainObject.numOfTiles, 90, 10, 1));
        civilizationsInPlay.add(new CivilizationCircle(pozycje.get(1), Color.GREEN, board, boardList, 2, mainObject.numOfTiles, 50, 50, 2));
        civilizationsInPlay.add(new CivilizationNext(pozycje.get(2), Color.BLUE, board, boardList, 3, mainObject.numOfTiles, 40, 80, 3));

        for (Civilizations civ : civilizationsInPlay) {
            civ.setAllCivilizations(civilizationsInPlay);
        }

        timer[0].start();
    }

}
