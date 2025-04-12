package org.estructurales.facade;

import java.util.List;

public class FileConverter {

    public void exportToPDF(List<Object> data) {
        System.out.println("Exporting " + data.size() + "records to PDF...");
    }
    
}