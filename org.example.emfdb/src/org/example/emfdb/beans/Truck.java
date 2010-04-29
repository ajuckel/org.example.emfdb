package org.example.emfdb.beans;

public class Truck extends Car {
	public Truck() {
		super();
		this.loadCapacity = 1000;
	}
	public int getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(int loadCapacity) {
		int oldLoadCapacity = this.loadCapacity;
		this.loadCapacity = loadCapacity;
		if( oldLoadCapacity != loadCapacity ) {
			this.pcs.firePropertyChange("loadCapacity", oldLoadCapacity, loadCapacity);
		}
	}

	private int loadCapacity;
}
