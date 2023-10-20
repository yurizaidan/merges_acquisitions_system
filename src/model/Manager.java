package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Manager extends User {

    public Manager(String first_name, String last_name, int id, Department department) {
        super(first_name, last_name, id, department);
        this.employment_type="Manager";
    }
