import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static final String FILENAME = "F:\\Programy JAVA\\lekce_5_du\\kvetiny.txt";


    public static void main(String[] args) throws  FileNotFoundException, PlantException {
        PlantData list = new PlantData();
        try {
            list.readPlantsFromFile(FILENAME);
        }catch (PlantException e){
            System.err.println("chyba při čtení souboru: "+ e.getLocalizedMessage());

        }
        List<Plant> listOfplants = list.getListOfPlants();
        System.out.println(listOfplants);
        for (Plant plant : listOfplants){
            System.out.println(plant.getName()+" "+ plant.getNotes()+" "+plant.getPlanted()+" "+plant.getWatering()+" "+plant.getFrequencyOfWatering());
        }




    }



//
//            Plant ruze = new Plant("růže", "test", LocalDate.of(1998,5,11), LocalDate.of(1999,5,11), -11);
//            ArrayList<Plant> listOfPlants = new ArrayList<>();
//            listOfPlants.add(ruze);







    }

