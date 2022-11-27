import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static final String FILENAME = "F:\\Programy JAVA\\lekce_5_du\\kvetiny.txt";
    public static final String OUTPUTFILENAME = "F:\\Programy JAVA\\lekce_5_du\\kvetiny - kopie.txt";


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
            //System.out.println(plant.getName()+" "+ plant.getNotes()+" "+plant.getPlanted()+" "+plant.getWatering()+" "+plant.getFrequencyOfWatering());
           System.out.println(plant.getWateringInfo());
        }

//        listOfplants.remove(2);
//        Plant bazalka = new Plant("Bazalka ", " V kuchyni ",LocalDate.of(2021,4,4),LocalDate.of(2021,9,1), 3);
//       // listOfplants.add(bazalka);


        try {
            list.writePlantsToFile(OUTPUTFILENAME);
        }catch (PlantException e){
            System.err.println("nastala chyba při zápisu do souboru " + e.getLocalizedMessage());
        }








    }



//
//            Plant ruze = new Plant("růže", "test", LocalDate.of(1998,5,11), LocalDate.of(1999,5,11), -11);
//            ArrayList<Plant> listOfPlants = new ArrayList<>();
//            listOfPlants.add(ruze);







    }
}

