package com.caatrin.hello;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class AllArtists {

	// This class will only have one instance that will
	// contain an arraylist with all contacts in it.
	// Singleton

	private static AllArtists allArtists;

	// By creating a Context you gain access to the 
	// current state of the complete application.
	// With it you can get information about all the Activitys
	// in the app among other things.

	// By accessing the Context you control every part of
	// the application along with everything that app
	// is allowed to access on the device.

	private Context applicationContext;

	// This ArrayList will hold all the Contacts

	private ArrayList<Artist> artistList;

	private AllArtists(Context applicationContext){

		this.applicationContext = applicationContext;

		artistList = new ArrayList<Artist>();

		// TODO
		// This goes away when app is ready

		Artist vanGogh = new Artist();
		vanGogh.setName("Vincent van Gogh");
		vanGogh.setDescription("Vincent Willem van Gogh was a post-Impressionist painter " +
				"of Dutch origin whose work, notable for its rough beauty, emotional honesty " +
				"and bold color, had a far-reaching influence on 20th-century art.");
		artistList.add(vanGogh);
		
		Artist picasso = new Artist();
		picasso.setName("Pablo Picasso");
		picasso.setDescription("Pablo Ruiz y Picasso, known as Pablo Picasso was a " +
				"Spanish painter, sculptor, printmaker, ceramicist, and stage designer " +
				"who spent most of his adult life in France.");
		artistList.add(picasso);
		
		Artist daVinci = new Artist();
		daVinci.setName("Leonardo da Vinci");
		daVinci.setDescription("Leonardo di ser Piero da Vinci was " +
				"an Italian Renaissance polymath: painter, sculptor, architect, musician, " +
				"mathematician, engineer, inventor, anatomist, geologist, cartographer, botanist, and writer.");
		artistList.add(daVinci);

	}

	// Checks if an instance of allContacts exists. If it does
	// the one instance is returned. Otherwise the instance is
	// created.

	public static AllArtists get(Context context){

		if(allArtists == null){

			// getApplicationContext returns the global Application object
			// This Context is global to every part of the application

			allArtists = new AllArtists(context.getApplicationContext());

		}

		return allArtists;

	}

	public ArrayList<Artist> getContactList(){

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
