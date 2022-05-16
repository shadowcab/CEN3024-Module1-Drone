package com.musersoft.v3;
/**
* Program Name: Lee_DroneProgram
* Purpose: Drone simulation using reusable drone and controller classes
* @author James Lee
* @since 5/15/2022
*/

public class Lee_DroneProgram {

	public static void main(String[] args) {
		
		//Instantiate first DroneController by providing name of drone and it's orientation in degrees
		
	    Lee_DroneController studentDrone = new Lee_DroneController("Student_Drone", 0);
	    studentDrone.run();
	    
		//Instantiate a second DroneController called "Drone_4" with an initial orientation heading of 337 degrees NorthWest

	    Lee_DroneController drone4 = new Lee_DroneController("Drone_4", 337);
	    drone4.run();
	    
	    System.out.println("\nHave a nice day!");
	    
	}

}
