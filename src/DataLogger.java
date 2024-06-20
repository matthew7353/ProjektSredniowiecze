import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataLogger {
    public static void logData(String fileName, ArrayList<Civilizations> civilizationsInPlay){
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data(civilizationsInPlay));
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String data(ArrayList<Civilizations> civilizationsInPlay){
        String conqueredTiles;
        String[] temp = new String[civilizationsInPlay.size()];

        for(Civilizations civ : civilizationsInPlay){
            temp[civ.getId() - 1] = String.valueOf(civ.getConqueredTiles().size());
        }

        System.out.println(temp[0]);
        return conqueredTiles = String.join("\n", temp);
    }
}
