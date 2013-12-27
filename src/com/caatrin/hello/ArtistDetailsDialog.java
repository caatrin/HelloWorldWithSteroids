package com.caatrin.hello;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ArtistDetailsDialog extends DialogFragment {
	
//	private TextView artistNameTextView;
	private TextView artistDescriptionTextView;
	
	private String artistName;
	private String artistDescription;
	

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistDescription() {
		return artistDescription;
	}

	public void setArtistDescription(String artistDescription) {
		this.artistDescription = artistDescription;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_dialog_artist_details, container);
		getDialog().setTitle(getArtistName());
		artistDescriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
		artistDescriptionTextView.setText(getArtistDescription());
		
		Button okButton = (Button) view.findViewById(R.id.okButton);
		okButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		
		return view;
	}


	
	
	
	
	
	
	

}
