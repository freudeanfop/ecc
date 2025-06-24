package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.util.ArrayList;
import java.util.List;

/*
* CSV-Parser class, implementing the DataParser Interface
*/
public class CsvParser implements DataParser{

    /**
     * PArsing method for a given file and RecordType
     * @param filename The name of the CSV file
     * @param type is the RecordType, currently either FOOTBALL or WEATHER
     */
    @Override
    public List<Record> parseFileContainingRecordType(String filename, RecordType type) {

        //checks if the file exists
        File file = new File(filename);
        if (!file.exists()) {
            System.err.println(filename + " does not exist.");
            return null;
        }

        // create List of records 
        List<Record> records = new ArrayList<>();

        //porcess file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            
            //read inital line, defines columns, returns null if null
            String header = br.readLine();
            if (header == null) {
                System.err.println("Empty file");
                return null;
            }
            int expectedColumns = header.split(",").length;

            // Process the actual data, line per line until the end
            String line;
            while ((line = br.readLine()) != null) {

                // Split comma separated values (CSV) into String array
                String[] parts = line.split(",");
                
                //validate length, return null else
                if (parts.length != expectedColumns) {
                    System.err.println("Expected line " + (records.size() + 1) + " to have " + expectedColumns + " entries, but got " + parts.length + " entries");
                    return null;
                }

                // create a Record instance of the respective RecordType
                Record record = parseRecordAccordingToType(parts, type);

                // If creation is successful, add to list, else report error and return null  
                if (record != null) {
                    records.add(record);
                }
                else{
                    System.err.println("Creating an instance of " + type + " from line " + (records.size() + 1) + " caused an Exception. Recheck line or recordtype for file");
                    return null;
                }
            }
            return records;
        } catch (Exception e) { // catch unexpected Exceptions
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }


    /* 
    * Method responsible for converting a CSV line into a specific Record based on RecordType
    * @param parts String array content of line
    * @param type desribes the RecordType
    * Returns null if any exception occurs or the type is unsupported
    */
    // Bonus Note: replace this method with a factory class for when we use more parsers
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
