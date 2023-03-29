/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sorting.arrays;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Garin McCullick
 */
public class Person {//Person is my class
    
 private final String name;//defining my strings as private final
    private final String address;
    private final String phoneNumber;
    private final String emailAddress;
    
    public Person(String name, String address, String phoneNumber, String emailAddress) {//this is my constructor for Person and is the layout/defining for creating a new person
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {//function returns name
        return name;
    }

    public String getAddress() {//function returns address
        return address;
    }

    public String getPhoneNumber() {//function returns phone number
        return phoneNumber;
    }

    public String getEmailAddress() {//function returns email
        return emailAddress;
    }

    public static ArrayList<Person> Load() {//loading array list Person where ArrayList<Person> has Person objects (name,address,phonenumber,email)
        ArrayList<Person> people = new ArrayList<>();//arraylist<person> is a generic type that can only hold person objects and then assign the objects to a new arraylist of people making an arraylist of people with person objects
        people.add(new Person("Garin", "100 Main St, springfield, USA", "417-1234", "glmccullick@gmail.com"));//adding person to people array through constructor callback
        people.add(new Person("Jack", "223 Park St, butler, USA", "417-5678", "jack@gmail.com"));//adding person to people array through constructor callback
        people.add(new Person("Danials", "933 Elm St, collins, USA", "417-3559", "danials@gmail.com"));//adding person to people array through constructor callback
        return people;//returing all the persons in the people arraylist
    }

    public static void main(String[] args) {
        ArrayList<Person> people = Person.Load();
        for (Person person : people) {//for loop goes through each person object (name, address, phone, email) in the people array list and calls back to get functions which just returns the object in the array list ex person.getName returns name
            System.out.println(person.getName() + " " + person.getAddress() + " " + person.getPhoneNumber() + " " + person.getEmailAddress());
        }
        
        // here im sorting the people ArrayList by name using a lambda expression (p1, p2) and the .compareTo method that we have used in previous assingments.
        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));//here we are comparing the names and using the collections.sort method to sort the people array by comparing p1 to p2 or getname to get another name
        
        System.out.println("\nSorted people by name:");
        for (Person person : people) {//same for loop as above
            System.out.println(person.getName() + " " + person.getAddress() + " " + person.getPhoneNumber() + " " + person.getEmailAddress());
        }
    }
}
