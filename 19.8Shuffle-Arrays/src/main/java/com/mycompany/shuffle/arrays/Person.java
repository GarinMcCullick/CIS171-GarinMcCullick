/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shuffle.arrays;
import java.util.ArrayList;// allows us to use arraylist
import java.util.Collections;//collections is an import to be able to shuffle our array list
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
        ArrayList<Person> people = Person.Load();//loading Person
        for (Person person : people) { //for loop goes through each person object (name, address, phone, email) in the people array list and calls back to get functions which just returns the object in the array list ex person.getName returns name
            System.out.println(person.getName() + " " + person.getAddress() + " " + person.getPhoneNumber() + " " + person.getEmailAddress());
        }
        Collections.shuffle(people);//collections.shuffle just shuffles the array list of people. this can also be done through a callback function however for this I decided to throw it into my main method so I needed collections in place of a callback function.
        System.out.println("\nShuffled people array:");//notifying that the array has been shuffled
        for (Person person : people) {//same as above for loop
            System.out.println(person.getName() + " " + person.getAddress() + " " + person.getPhoneNumber() + " " + person.getEmailAddress());
        }
    }
    
}