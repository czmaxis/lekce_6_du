import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Plant implements Comparable<Plant> {


    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;




    public Plant (String name,String notes,LocalDate planted,LocalDate watering,int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
//        this.watering = watering;
        setWatering(watering);
//        this.frequencyOfWatering = frequencyOfWatering;
        setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant (String name, LocalDate planted,int frequencyOfWatering){
        this.name = name;
        this.notes = "  ";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;
    }
    public Plant (String name){
        this.name = name;
        this.notes = "  ";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
    }

//    public static Plant parsePlant(String data)throws PlantException {
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
//
//        String[] items = null;
//        String name = items[0];
//        String notes = items[1];
//        LocalDate planted = LocalDate.parse(items[5]);
//        LocalDate watering = LocalDate.parse(items[4]);
//        int frequencyOfWatering = Integer.parseInt(items[3]);
//
//
//        Plant result = new Plant (name, notes, planted, watering, frequencyOfWatering);
//        return result;
//
//    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering)throws PlantException {
        if (watering.isBefore(planted)){
            throw new PlantException("Datum poslední zálivky je před zasazením rostliny ");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering)throws PlantException {
        if (frequencyOfWatering <= 0) {

            throw new PlantException("frekvence zalévání musí být větší jak 0 dní. " + frequencyOfWatering);
        }
        else {
            this.frequencyOfWatering = frequencyOfWatering;
        }
    }
    public String getWateringInfo(){
//        this.name = name;
//        this.watering = watering;
//        this.frequencyOfWatering  = frequencyOfWatering;

        return getName() + " Datum poslendí zálivky: " + getWatering() + " Frekvence zálivky: " + getFrequencyOfWatering();
    }

    @Override
    public int compareTo(Plant secondPlant){
        int compareNames =
                this.getName().compareTo(secondPlant.getName());
        if (compareNames != 0 ){
            return compareNames;
        }else {
            return this.getName().compareTo(secondPlant.getName());
        }

    }







//    @Override
//        public int compare(Plant first, Plant second) {
//
//            return first.getName().compareTo(second.getName());
//
//        }



}
