package de.exxcellent.challenge;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        //Parse arguments, declaring filename and recordtype
        if (args.length < 2) {
            System.err.println("Please specify the filename of the csv as well as the recordtype");
            System.exit(1);
        }
        
        String currentWorkingDirectory = System.getProperty("user.dir");
        String filename = currentWorkingDirectory + args[0];
        RecordType recordtype = RecordType.valueOf(args[1]);

        CsvParser parser = new CsvParser();

        //Parse file and get records
        List<Record> records = parser.parse(filename, recordtype);

        if (records == null || records.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        // Rank records and get lowest scoring Entry
        Record bestRecord = records.get(0);
        int bestRanking = bestRecord.computeRanking();

        for (Record r : records) {
            int ranking = r.computeRanking();
            if (ranking < bestRanking) {
                bestRanking = ranking;
                bestRecord = r;
            }
        }
        
        bestRecord.printRecord();
    
    }
}
