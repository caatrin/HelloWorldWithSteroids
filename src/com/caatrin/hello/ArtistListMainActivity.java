package com.caatrin.hello;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class ArtistListMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_contact_list);

		FragmentManager fragManager = getFragmentManager();

		// Check if the FragmentManager knows about the Fragment id we refer to
		Fragment theFragment = fragManager.findFragmentById(R.id.fragmentContainer);

		// Check if the Fragment was found
		if(theFragment == null){

			// If the Fragment wasn't found then we must create it
			theFragment = new FragmentArtistList();

			// Creates and commits the Fragment transaction
			// Fragment transactions add, attach, detach, replace
			// and remove Fragments.

			// add() gets the location to place the Fragment into and
			// the Fragment itself.
			fragManager.beginTransaction()
			.add(R.id.fragmentContainer, theFragment)
			.commit();
		}

		}


}
