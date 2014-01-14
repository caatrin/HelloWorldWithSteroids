package com.caatrin.hello;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class AllArtists {

	// This class will only have one instance that will
	// contain an arraylist with all artists in it.

	private static AllArtists allArtists;

	// By creating a Context you gain access to the 
	// current state of the complete application.
	// With it you can get information about all the Activities
	// in the app among other things.

	// By accessing the Context you control every part of
	// the application along with everything that app
	// is allowed to access on the device.

	private Context applicationContext;
	private ArrayList<Artist> artistList;

	private AllArtists(Context applicationContext){

		this.applicationContext = applicationContext;
		artistList = new ArrayList<Artist>();
		
		for (int i = 0; i< Ipsum.artistNames.length; i++) {
			artistList.add(new Artist(Ipsum.artistNames[i], Ipsum.artistDescriptions[i]));
		}
	}

	public static AllArtists get(Context context){
		// Checks if an instance of allArtists exists. If it does
		// the one instance is returned. Otherwise the instance is created.
		if(allArtists == null){
			// getApplicationContext returns the global Application object
			// This Context is global to every part of the application
			allArtists = new AllArtists(context.getApplicationContext());
		}
		return allArtists;
	}

	public ArrayList<Artist> getArtistList(){
		return artistList;
	}

	public Artist getArtist(UUID id){
		for(Artist theArtist : artistList){
			if(theArtist.getIdNumber().equals(id)){
				return theArtist;
			}
		}
		return null;
	}

}
