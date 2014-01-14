package com.caatrin.hello;

import java.util.UUID;

import android.util.Log;

public class Artist {
	
	private String name;
	private String description;
	
	// Add a Unique ID number for each person
	private UUID idNumber;
	
	public Artist(){
		// Generates a type 4 pseudo randomly generated UUID
		// Wiki : 1 billion UUIDs every second for the next 
		// 100 years, the probability of creating just one 
		// duplicate would be about 50%
		idNumber = UUID.randomUUID();
	}
	

	public Artist(String name, String description) {
		this.name = name;
		this.description = description;
		idNumber = UUID.randomUUID();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		Log.e("HELLO", "NAME CHANGED TO " + name);
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		Log.e("HELLO", "DESCRIPTION CHANGED TO " + description);
		this.description = description;
	}

	public UUID getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(UUID idNumber) {
		this.idNumber = idNumber;
	}
	
}