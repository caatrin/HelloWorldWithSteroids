package com.caatrin.hello;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class ArtistDetailsDialog extends DialogFragment {
	
	private TextView artistNameTextView;
	private TextView artistDescriptionTextView;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_dialog_artist_details, container);
		artistDescriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
		
		
		Button okButton = (Button) view.findViewById(R.id.okButton);
		okButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		//getDialog().setTitle("Hello World");
		
		getDialog().setTitle("Hello World");
		
		return view;
	}


//	@Override
//	public View getView() {
//		// TODO Auto-generated method stub
//		return super.getView();
//	}
	
	
	
	
	
	
	
	
	
	

}
