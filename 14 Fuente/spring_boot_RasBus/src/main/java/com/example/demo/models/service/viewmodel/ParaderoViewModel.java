package com.example.demo.models.service.viewmodel;

import com.example.demo.models.entity.Paradero;

public class ParaderoViewModel{
	public Paradero paradero;
	public boolean match;
	protected ParaderoViewModel() {
	}
	public ParaderoViewModel(Paradero paradero, boolean match) {
		this.paradero = paradero;
		this.match = match;
	}
	public Paradero getParadero() {
		return paradero;
	}
	public void setParadero(Paradero paradero) {
		this.paradero = paradero;
	}
	public boolean isMatch() {
		return match;
	}
	public void setMatch(boolean match) {
		this.match = match;
	}
	
}
