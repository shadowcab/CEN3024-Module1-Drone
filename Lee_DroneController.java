package com.musersoft.v3;
/**
* Program Name: Lee_DroneProgram
* Purpose: Drone controller class
* @author James Lee
* @since 5/15/2022
*/

import java.util.Scanner;

public class Lee_DroneController {
	
	private String name;								//name of drone
	private String orientation;							//orientation e.g. North, NorthEast, etc.
	private int heading;								//compass heading in degrees
	private boolean done = false;						//quit flag
	private Scanner scanner = new Scanner(System.in);
	private Lee_Drone drone = new Lee_Drone(0, 0, 0, true);		//Instantiate drone object at x_pos=0, y_pos=0, z_pos=0, ready=true
	
	public Lee_DroneController(String name, int heading) {		//drone controller constructor
		super();
		this.name = name;								//Since drone is paired with its controller, they share the same name
		this.heading = heading;							//Initial heading of drone
		updateOrientation(0);							//Initial orientation of drone is based on heading
		System.out.println("\nLaunching \"" + name + "\"...");
	}

	//User Interface
	public void run() {
		scanner = new Scanner(System.in);
		while (!done) {
			System.out.println("Which direction would you like to move the drone?");
			System.out.println(" 1 - Move Up");
			System.out.println(" 2 - Move Down");
			System.out.println(" 3 - Move Forward");
			System.out.println(" 4 - Move Backward");
			System.out.println(" 5 - Move Left");
			System.out.println(" 6 - Move Right");
			System.out.println(" 7 - Yaw Left");
			System.out.println(" 8 - Yaw Right");
			System.out.println(" 9 - Display Position");
			System.out.println("10 - Exit Navigation");
			
			int menuNum = scanner.nextInt();
			processCommand(menuNum);
		}
	}
	
	//Process navigation commands from UI
	private void processCommand(int cnum) {
		switch (cnum) {
		case 1:
			if(drone.moveUp()) {
				System.out.println("You have moved up");
			}
			else System.out.println("Warning: " + name + " did not move up!");
			break;
		case 2:
			if(drone.moveDown()) {
				System.out.println("You have moved down");
			}
			else System.out.println("Warning: " + name + " did not move down!");
			break;
		case 3:
			if(drone.moveForward()) {
				System.out.println("You have moved forward");
			}
			else System.out.println("Warning: " + name + " did not move forward");
			break;
		case 4:
			if(drone.moveBackward()) {
				System.out.println("You have moved backward");
			}
			else System.out.println("Warning: " + name + " did not move backward");
			break;
		case 5:
			if(drone.moveLeft()) {
				System.out.println("You have moved forward");
			}
			else System.out.println("Warning: " + name + " did not move forward");
			break;
		case 6:
			if(drone.moveRight()) {
				System.out.println("You have moved backward");
			}
			else System.out.println("Warning: " + name + " did not move backward");
			break;
		case 7:
			if(drone.yawLeft()) {
				System.out.println("You have turned left");
				this.updateOrientation(-1);
			}
			else System.out.println("Warning: " + name + " did not turn left");
			break;
		case 8:
			if(drone.yawRight()) {
				System.out.println("You have turned right");
				this.updateOrientation(1);
			}
			else System.out.println("Warning: " + name + " did not turn right");
			break;
		case 9:
			// System.out.println("Display Position of Drone...");
			System.out.println(name + " [x_pos=" + drone.getX_pos() 
									+ ", y_pos=" + drone.getY_pos() 
									+ ", z_pos=" + drone.getZ_pos() 
									+ ", orientation=" + orientation + "/" + this.heading + "\u00B0]");
			break;
		case 10:
			quit();
			//System.exit(0);
			break;
		default:
			System.out.println("Error in DroneController()...");
		}// end switch
	}

	private void quit() {
		done = true;
		System.out.println("\"" + this.name + "\" has landed safely.");
	}

	//Update drone "heading" orientation after every move. 
	private void updateOrientation(int turn) {
		
		//Calculate new heading
		this.heading = this.heading + turn;
		
		//Correct for negative headings and headings greater than 360 degrees
		if (this.heading < 0) this.heading = this.heading + 360;
		if (this.heading >= 360) this.heading = this.heading - 360;
		
		if ((this.heading > 337) || (this.heading <= 23)) this.orientation = "North";
		else if ((this.heading > 23)  && (this.heading <= 68)) this.orientation = "NorthEast";
		else if ((this.heading > 68)  && (this.heading <= 113)) this.orientation = "East";
		else if ((this.heading > 113) && (this.heading <= 158)) this.orientation = "SouthEast";
		else if ((this.heading > 158) && (this.heading <= 203)) this.orientation = "South";
		else if ((this.heading > 203) && (this.heading <= 248)) this.orientation = "SouthWest";
		else if ((this.heading > 248) && (this.heading <= 293)) this.orientation = "West";
		else if ((this.heading > 293) && (this.heading <= 337)) this.orientation = "NorthWest";
		else this.orientation = "Error";
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}


	public int getHeading() {
		return heading;
	}


	public void setHeading(int heading) {
		this.heading = heading;
	}


}
