import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PlantData {

    public static void main(String[] args) {


        ArrayList<Plant> listOfPlants = new ArrayList<>();



        System.out.println();

//        File dataFile = new File("F:\\Programy JAVA\\lekce_5_du\\kvetiny.txt");
//
//        Scanner scanner = new Scanner(dataFile);
////přepsat znovu
//        while (scanner.hasNextLine()) {
//            String record = scanner.nextLine();
//            listOfPlants.add(Plant.parsePlant(record));
//            // System.out.println(record);
//        }
//
//        public static Plant parsePlant(String data) {
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
//
//            String[] items = data.split("   ");
//            String name = LocalDate.parse(items[0]);
//            BigDecimal price = new BigDecimal(items[1]);
//            String category = items[2];
//            String description = items[3];
//
//            Plant result = new Plant(description, category, price, purchaseDate);
//            return result;
//
       }

}

