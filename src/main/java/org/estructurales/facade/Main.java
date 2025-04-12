package org.estructurales.facade;

public class Main {

    public static void main(String[] args) {
        EmployeesReporterFacade facade = new EmployeesReporterFacade();
        facade.downloadReport();
    }
}