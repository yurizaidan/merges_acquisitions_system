package model;

public class Environment {

    public static void loadEnvironment(){

        //Departments
        Department technology = new Department("Engineering",50_000);
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

        //Orders
        Order o001 = new Order (20231001, "08/10/2023",e001, e001.getDepartment());
        e001.addOrder(o001);

        Order o002 = new Order (20231002, "10/10/2023", e002, e002.getDepartment());
        e002.addOrder(o002);

        Order o003 = new Order (20231003, "10/15/2023", e002, e002.getDepartment());
        e002.addOrder(o003);

        Order o004 = new Order (20231004,"10/01/2023", e013, e013.getDepartment());
        e013.addOrder(o004);

        Order o005 = new Order (20231005, "10/08/2023",e008, e008.getDepartment());
        e008.addOrder(o005);

        Order o006 = new Order (20231006, "10/03/2023", e007, e007.getDepartment());
        e007.addOrder(o006);

        Order o007 = new Order (20231007, "10/02/2023", e005, e005.getDepartment());
        e005.addOrder(o007);

        Order o008 = new Order (20231008,"10/01/2023", e013, e013.getDepartment());
        e013.addOrder(o008);

        Order o009 = new Order (20231009, "10/13/2023", e010, e010.getDepartment());
        e010.addOrder(o009);

        Order o010 = new Order (20231010,"10/11/2023", e010, e010.getDepartment());
        e010.addOrder(o010);

        //Setting order total price
        o001.setOrder_total_price(1_500);
        o002.setOrder_total_price(2_500);
        o003.setOrder_total_price(3_000);
        o004.setOrder_total_price(4_000);
        o005.setOrder_total_price(6_500);
        o006.setOrder_total_price(1_500);
        o007.setOrder_total_price(2_300);
        o008.setOrder_total_price(2_450);
        o009.setOrder_total_price(3_500);
        o010.setOrder_total_price(2_800);
    }
}
