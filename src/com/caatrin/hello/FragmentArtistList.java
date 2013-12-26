package com.caatrin.hello;

import java.util.ArrayList;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

// The ListFragment displays a list of items in a 
// ListView, by binding to our ArrayList using an
// ArrayAdapter in this situation.

public class FragmentArtistList extends ListFragment {

	// Stores the list of Contacts

	private ArrayList<Artist> artistList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Change the title for the current Activity
		//getActivity().setTitle(R.string.fragment_contact_list_title);

		// Get the ArrayList from AllContacts
		artistList = AllArtists.get(getActivity()).getContactList();
		ArtistAdapter contactAdapter = new ArtistAdapter(artistList);

		// Provides the data for the ListView by setting the Adapter 
		setListAdapter(contactAdapter);
	}
	

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		Log.e("HELLO", "LIST ITEM CLICKED");
	//	Artist clickedArtist = ((ArtistAdapter) getListAdapter()).getItem(position);

		FragmentManager fm = getFragmentManager();
        ArtistDetailsDialog artistDetailsDialog = new ArtistDetailsDialog();
        
       // artistDetailsDialog.getDialog().setTitle("Hello World");
        
      //  artistDetailsDialog.setT
        artistDetailsDialog.show(fm, "fragment_dialog_artist_details");
	}
	


	private class ArtistAdapter extends ArrayAdapter<Artist> {
		
		 // references to our images
	    private Integer[] masterpieceIds = {
	            R.drawable.ic_launcher,
	            R.drawable.ic_launcher,
	            R.drawable.ic_launcher
	    };

		public ArtistAdapter(ArrayList<Artist> contacts) {

			// An Adapter acts as a bridge between an AdapterView and the 
			// data for that view. The Adapter also makes a View for each 
			// item in the data set. (Each list item in our ListView)

			// The constructor gets a Context so it can use the 
			// resource being the simple_list_item and the ArrayList
			// android.R.layout.simple_list_item_1 is a predefined 
			// layout provided by Android that stands in as a default

			super(getActivity(), android.R.layout.simple_list_item_1, contacts);
		}

		// getView is called each time it needs to display a new list item
		// on the screen because of scrolling for example.
		// The Adapter is asked for the new list row and getView provides
		// it.
		// position represents the position in the Array from which we will 
		// be pulling data.
		// convertView is a pre-created list item that will be reconfigured 
		// in the code that follows.
		// ViewGroup is our ListView

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			// Check if this is a recycled list item and if not we inflate it

			if(convertView == null){

				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_artist, null);

			}

			// Find the right data to put in the list item

			Artist theArtist = getItem(position);

			// Put the right data into the right components

			TextView artistNameTextView = (TextView)convertView.findViewById(R.id.artist_name);
			artistNameTextView.setText(theArtist.getName());

			TextView artistDescriptionTextView = (TextView)convertView.findViewById(R.id.artist_description);
			artistDescriptionTextView.setText(theArtist.getDescription().substring(0, 30) + "...");

			ImageView masterpieceImageView = (ImageView) convertView.findViewById(R.id.masterpieceImageView);
			masterpieceImageView.setImageResource(masterpieceIds[position]);

			// Return the finished list item for display
			return convertView;

		}


	}

}
