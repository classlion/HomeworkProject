package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Jackson", "1234567890", "Ol@gmail.com","Jersy","qa"});
        list.add(new Object[]{"Oliver", "Jackson", "12345678901", "Ol@gmail.com","Jersy","qa"});
        list.add(new Object[]{"Oliver", "Jackson", "123456784902", "Ol@gmail.com","Jersy","qa"});
        list.add(new Object[]{"Oliver", "Jackson", "1234567890433", "Ol@gmail.com","Jersy","qa"});
        return list.iterator();
    }

    @DataProvider
    public  Iterator<Object[]>addNewContactWithCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contactdata.csv"));

        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setPhone(split[2]).setAddress(split[3]).setDescription(split[4])});
            line = reader.readLine();
        }
        return list.iterator();

    }
}
