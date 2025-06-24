package de.exxcellent.challenge;

/*
* Abstract interface of records, all implementation of records should extend this interface 
*/
public interface Record {
    void printRecordIdentifier();
    int computeRankingValue();
}