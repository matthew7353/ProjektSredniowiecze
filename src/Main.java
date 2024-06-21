import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {

    int numOfTiles = 20;
    int timerDelay = 10;
    int turn = 0;

    public static void main(String[] args) {
        Main mainObject = new Main();

        Board board = new Board(mainObject.numOfTiles);
        ArrayList<Civilizations> civilizationsInPlay = new ArrayList<>();
        int [] boardList = new int[mainObject.numOfTiles * mainObject.numOfTiles];

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Saving data before exit...");
            DataLogger.logData("SimulationData", civilizationsInPlay, mainObject.turn);
        }));

        // clock for simulation flow
        Timer[] timer = new Timer[1];
        timer[0] = new Timer(mainObject.timerDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Civilizations x: civilizationsInPlay){
                    x.conquer();
                }
                mainObject.turn++;
                timer[0].restart();
            }
        });

        //randomizing spawn points of civilizations
        int w1 = 0;
        ArrayList<Integer> positions = new ArrayList<>();
        while (w1<20) {
            Random rand = new Random();
            int n = rand.nextInt(mainObject.numOfTiles * mainObject.numOfTiles);
            int i = 0;

            for(Integer x : positions){
                if(n == x){
                    i++;
                }
            }
            if(i==0){
                positions.add(n);
                w1++;
            }

        }


        civilizationsInPlay.add(new CivilizationCircle(positions.get(0), Color.RED, board, boardList, 1, mainObject.numOfTiles, 55, 30, 3));
        civilizationsInPlay.add(new CivilizationCircle(positions.get(1), Color.GREEN, board, boardList, 2, mainObject.numOfTiles, 50, 50, 3));
        civilizationsInPlay.add(new CivilizationNext(positions.get(2), Color.BLUE, board, boardList, 3, mainObject.numOfTiles, 40, 80, 5));
        civilizationsInPlay.add(new CivilizationNext(positions.get(3), Color.YELLOW, board, boardList, 4, mainObject.numOfTiles, 30, 30, 1));
        civilizationsInPlay.add(new CivilizationCircle(positions.get(4), Color.CYAN, board, boardList, 5, mainObject.numOfTiles, 35, 100, 3));
        civilizationsInPlay.add(new CivilizationNext(positions.get(5), Color.PINK, board, boardList, 6, mainObject.numOfTiles, 75, 75, 4));
        civilizationsInPlay.add(new CivilizationCircle(positions.get(6), Color.MAGENTA, board, boardList, 7, mainObject.numOfTiles, 60, 45, 2));

        for (Civilizations civ : civilizationsInPlay) {
            civ.setAllCivilizations(civilizationsInPlay);
        }

        timer[0].start();
    }

}
