/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.geometricobjects;

/**
 *
 * @author Garin McCullick
 */

public class GeometricObject {
    public static void main(String[] args){
  Circle circles[] = {//circles = an array of circles with different properties. also calling Circle class
  new Circle("circle1", 18),//each circle has two properties a name and an area measurement.
  new Circle("circle2", 20),//you can change these parameters to test the functions in finding the circle with the largest area
  new Circle("circle3", 12)
  }; 
  Circle choice = circles[0];
    for(int x = 1; x < circles.length;x++){//looping through circles array
    if(circles[x].compareTo(choice) > 0){//if statement using compareTo to find greatest area measurement to determine which is bigger. using compareTO method from Circle.java class
    choice = circles[x];
    }
}
    System.out.println();
    System.out.println(choice.getName() + " is the largest with area = " + choice.getArea());//printing out circle name and area that is the largest
    }
}
   


