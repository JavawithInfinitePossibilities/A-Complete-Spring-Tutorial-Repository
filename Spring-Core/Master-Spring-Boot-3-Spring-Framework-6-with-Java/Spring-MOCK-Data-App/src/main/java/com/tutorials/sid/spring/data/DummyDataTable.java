package com.tutorials.sid.spring.data;


import com.tutorials.sid.spring.data.module.Employee;
import com.tutorials.sid.spring.data.module.SoftwareEngineer;

import java.util.*;

/**
 * @author kunmu On 22-04-2026
 */
public class DummyDataTable {


    public static int[] intArrayData() {
        int[] intDataArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        return intDataArray;
    }

    public static String[] stringArrayData() {
        String[] stringDataArray = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
                "Gujarat", "Haryana", "Himachal", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra",
                "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu",
                "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
        return stringDataArray;
    }

    public static Map<String, String> stringMapData() {
        Map<String, String> map = new HashMap<>();
        map.put("Andhra Pradesh", "Hyderabad (Proposed Capital Amaravati)");
        map.put("Arunachal Pradesh", "Itanagar");
        map.put("Assam", "Dispur");
        map.put("Bihar", "Patna");
        map.put("Chhattisgarh", "Raipur");
        map.put("Goa", "Panaji");
        map.put("Gujarat", "Gandhinagar");
        map.put("Haryana", "Chandigarh");
        map.put("Himachal Pradesh", "Shimla");
        map.put("Jharkhand", "Ranchi");
        map.put("Karnataka", "Bengaluru (formerly Bangalore)");
        map.put("Kerala", "Thiruvananthapuram");
        map.put("Madhya Pradesh", "Bhopal");
        map.put("Maharashtra", "Mumbai");
        map.put("Manipur", "Imphal");
        map.put("Meghalaya", "Shillong");
        map.put("Mizoram", "Aizawl");
        map.put("Nagaland", "Kohima");
        map.put("Odisha", "Bhubaneswar");
        map.put("Punjab", "Chandigarh");
        map.put("Rajasthan", "Jaipur");
        map.put("Sikkim", "Gangtok");
        map.put("Tamil Nadu", "Chennai");
        map.put("Telangana", "Hyderabad");
        map.put("Tripura", "Agartala");
        map.put("Uttar Pradesh", "Lucknow");
        map.put("Uttarakhand", "Dehradun (Winter)Gairsain (Summer)");
        map.put("West Bengal", "Kolkata");
        return map;
    }

    public static List<SoftwareEngineer> getSoftwareEngineer() {
        SoftwareEngineer[] list = {SoftwareEngineer.builder().name("Durga").age(60).isHavingGf(false).build(),
                SoftwareEngineer.builder().name("Sunil").age(25).isHavingGf(true).build(),
                SoftwareEngineer.builder().name("Sayan").age(26).isHavingGf(true).build(),
                SoftwareEngineer.builder().name("Subbu").age(28).isHavingGf(false).build(),
                SoftwareEngineer.builder().name("Ravi").age(17).isHavingGf(true).build()};
        return Arrays.asList(list);
    }

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(Employee.builder().name("Durga").designation("CEO").salary(30000).city("Hyderabad").build());
        list.add(Employee.builder().name("Sunny").designation("Manager").salary(20000).city("Hyderabad").build());
        list.add(Employee.builder().name("Mallika").designation("Manager").salary(20000).city("Bangalore").build());
        list.add(Employee.builder().name("Kareena").designation("Lead").salary(15000).city("Hyderabad").build());
        list.add(Employee.builder().name("Katrina").designation("Lead").salary(15000).city("Bangalore").build());
        list.add(Employee.builder().name("Anushka").designation("Developer").salary(10000).city("Hyderabad").build());
        list.add(Employee.builder().name("Kanushka").designation("Developer").salary(10000).city("Hyderabad").build());
        list.add(Employee.builder().name("Sowmya").designation("Developer").salary(10000).city("Bangalore").build());
        return list;
    }
}
