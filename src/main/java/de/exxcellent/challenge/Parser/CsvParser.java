package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.util.ArrayList;
import java.util.List;


public class CsvParser implements DataParser{

    @Override
    public List<Record> parse(String filename, RecordType type) {

        File file = new File(filename);
        if (!file.exists()) {
            System.err.println(filename + " does not exist.");
            return null;
        }

        List<Record> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine();
            if (header == null) {
                System.err.println("Empty file");
                return null;
            }

            int expectedColumns = header.split(",").length;

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != expectedColumns) {
                    System.err.println("Expected line " + (records.size() + 1) + " to have " + expectedColumns + " entries, but got " + parts.length + " entries");
                    return null;
                }

                Record record = parseRecordAccordingToType(parts, type);
                    
                if (record != null) {
                    records.add(record);
                }
                else{
                    System.err.println("Creating an instance of " + type + " from line " + (records.size() + 1) + " caused an Exception. Recheck line or recordtype for file");
                    return null;
                }
            }
            return records;
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    public Record parseRecordAccordingToType(String[] parts, RecordType type){
        try {
            switch (type) {
                case FOOTBALL:
                    return new FootballRecord(parts);
                case WEATHER:
                    return new WeatherRecord(parts);
                default:
                    throw new Exception("Unsupported record type: " + type);
            }
        } catch (Exception e) {
            return null;
        }
    }

}
