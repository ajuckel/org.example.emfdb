package org.example.emfdb.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Car {
	public Car() {
		this.make = "Honda";
		this.model = "Accord";
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		String oldMake = this.make;
		this.make = make;
		if( ! stringEquals(oldMake, make) ) {
			this.pcs.firePropertyChange("make", oldMake, make);
		}
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		String oldModel = this.model;
		this.model = model;
		if( ! stringEquals(oldModel, model) ) {
			this.pcs.firePropertyChange("model", oldModel, model);
		}
	}
	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		int oldDoors = this.doors;
		this.doors = doors;
		if( oldDoors != doors ) {
			this.pcs.firePropertyChange("doors", oldDoors, doors);
		}
	}

	private String make;
	private String model;
	private int doors;
	
	protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	public PropertyChangeListener[] getPropertyChangeListeners() {
		return pcs.getPropertyChangeListeners();
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(propertyName, listener);
	}

	public PropertyChangeListener[] getPropertyChangeListeners(
			String propertyName) {
		return pcs.getPropertyChangeListeners(propertyName);
	}

	public boolean hasListeners(String propertyName) {
		return pcs.hasListeners(propertyName);
	}

	private boolean stringEquals(String a, String b) {
		if( a == null && b == null ) {
			return true;
		} else if( a == null || b == null ) {
			return false;
		} else {
			return a.equals(b);
		}
	}
	
}
