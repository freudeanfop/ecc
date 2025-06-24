package de.exxcellent.challenge;

import java.util.List;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/*
*   Parser Interface declaring method for parsing
*   All Parsers should implement this interface
*/
public interface DataParser {
    List<Record> parseFileContainingRecordType(String filename, RecordType type);
}


