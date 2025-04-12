package org.estructurales.facade;

import java.util.List;
import java.util.ArrayList;

public class QueryCommands {

    public List<Object> data;
    
    public void executeEmployeesQuery(DatabaseConnector db) {
        data = new ArrayList<>();
        data.add("Benitez | 49/50 tasks");
        data.add("Marco Aurelio | 30/50 tasks");
        data.add("Lovecraft | 10/50 tasks");
        System.out.println("Executing query to get employees...");
    }

}