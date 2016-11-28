package Inheritance;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.SteeringHandle = steeringHandle;
	}

}
