package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;


public class CsvParser implements DataParser{

    @Override
    public List<Record> parse(String filename, RecordType type) {

        List<Record> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine();
            if (header == null) {
                throw new Exception("Empty file");
            }

            int expectedColumns = header.split(",").length;

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != expectedColumns) {
                    throw new Exception("Expected line " + (records.size() + 1) + " to have " + expectedColumns + " entries, but got " + parts.length + " entries");
                }

                Record record = parseRecordAccordingToType(parts, type);
                
                if (record != null) {
                    records.add(record);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return records;
    }

    public Record parseRecordAccordingToType(String[] parts, RecordType type) throws Exception{
        switch (type) {
            case FOOTBALL:
                return new FootballRecord(parts);
            case WEATHER:
                return new WeatherRecord(parts);
            default:
                throw new Exception("Unsupported record type: " + type);
        }
    }
}
