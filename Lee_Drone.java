package com.musersoft.v3;
/**
* Program Name: Lee_DroneProgram
* Purpose: Drone class
* @author James Lee
* @since 5/15/2022
*/

public class Lee_Drone {
	
	private int x_pos;				//East-West position
	private int y_pos;				//North-South position
	private int z_pos;				//Altitude position
	private boolean ready = false;	//Drone "Ready" status

	public Lee_Drone(int x, int y, int z, boolean ready) {
		super();
		this.x_pos = x;
		this.y_pos = y;
		this.z_pos = z;
		this.ready = checkStatus();
	}
	
	
	public int getX_pos() {
		return x_pos;
	}


	public void setX_pos(int x_pos) {
		this.x_pos = x_pos;
	}


	public int getY_pos() {
		return y_pos;
	}


	public void setY_pos(int y_pos) {
		this.y_pos = y_pos;
	}


	public int getZ_pos() {
		return z_pos;
	}


	public void setZ_pos(int z_pos) {
		this.z_pos = z_pos;
	}


	public boolean isReady() {
		return ready;
	}


	public void setReady(boolean ready) {
		this.ready = ready;
	}


	private boolean checkStatus() {
		ready = true;	//drone power, motors, GPS, controllers are OK
		return ready;
	}

	//Process moveUp() navigation command
	public boolean moveUp() {
		if (ready) {
			z_pos++;
			return true;
		}
		else return false;
	}

	//Process moveDown() navigation command
	public boolean moveDown() {
		if (ready) {
			z_pos--;
			return true;
		}
		else return false;
	}

	public boolean moveForward() {
		if (ready) {
			y_pos++;
			return true;
		}
		else return false;
	}
	
	public boolean moveBackward() {
		if (ready) {
			y_pos--;
			return true;
		}
		else return false;
	}

	public boolean moveLeft() {
		if (ready) {
			x_pos--;
			return true;
		}
		else return false;
	}
	
	public boolean moveRight() {
		if (ready) {
			x_pos++;
			return true;
		}
		else return false;
	}

	public boolean yawLeft() {
		if (ready) {			//Heading is maintained by the controller.
			return true;		//This is a placeholder for the turn servo processing.
		}
		else return false;
	}

	public boolean yawRight() {
		if (ready) {			//Heading is maintained by the controller.
			return true;		//This is a placeholder for the turn servo processing.
		}
		else return false;
	}

}
