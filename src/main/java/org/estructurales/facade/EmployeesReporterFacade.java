package org.estructurales.facade;

public class EmployeesReporterFacade {

    public void downloadReport() {
        DatabaseConnector db = new DatabaseConnector();
        QueryCommands query = new QueryCommands();
        FileConverter export = new FileConverter();
        
        db.connect();
        query.executeEmployeesQuery(db);
        export.exportToPDF(query.data);
    }
    
}