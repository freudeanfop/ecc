package de.exxcellent.challenge;

import java.util.List;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


/*
*   Abstract Parser Interface declaring method for parsing
*   Parsers should extend this interface
*/
public interface DataParser {
    List<Records> parse(String filename) throws Exception;
}