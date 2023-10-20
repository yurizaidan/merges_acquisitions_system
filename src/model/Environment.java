package model;

public class Environment {

    public static void loadEnvironment(){

        //Departments
        Department technology = new Department("Tech",50_000);
        Department marketing = new Department("Marketing", 12_000);
        Department design = new Department("UI/UX", 20_000);
        Department sales = new Department("Sales", 50_000);
        Department finance = new Department("FP&A", 15_000);
        Department business = new Department("Business Development",5_000);
