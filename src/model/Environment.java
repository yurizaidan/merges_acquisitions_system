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

	//Users
        Manager m001 = new Manager("Al", "Puchala", 2023001, business);
        Session.addUser(m001);

        Manager m002 = new Manager("Gus", "Spathis", 2023002, business);
        Session.addUser(m002);

        Employee e001 = new Employee("Landon", "Johnson",2023003, marketing);
        Session.addUser(e001);

        Employee e002 = new Employee("Jonathan", "Ewert", 2023004, business);
        Session.addUser(e002);

        Employee e003 = new Employee("Jon", "Eisenstein", 2023005, finance);
        Session.addUser(e003);

        Employee e004 = new Employee("Jarmal", "Riley", 2023006, sales);
        Session.addUser(e004);

        Employee e005 = new Employee("Suzanne", "Smyth", 2023007, business);
        Session.addUser(e005);

        Employee e006 = new Employee("Peter", "Shawn", 2023008, sales);
        Session.addUser(e006);

        Employee e007 = new Employee("Jivka", "Bojilova", 2023009, technology);
        Session.addUser(e007);

        Employee e008 = new Employee("Emre", "Aybey", 20230010, technology);
        Session.addUser(e008);

        Employee e009 = new Employee("Jesus", "Fernandez", 2023011, technology);
        Session.addUser(e009);

        Employee e010 = new Employee("Milan", "Antolic", 2023012, design);
        Session.addUser(e010);

        Employee e011 = new Employee("Tedy", "Hristova", 2023013 , design);
        Session.addUser(e011);

        Employee e012 = new Employee("Marigona", "Muli", 2023014, technology);
        Session.addUser(e012);

        Employee e013 = new Employee("Andreas", "Spathis", 2023015, finance);
        Session.addUser(e013);
