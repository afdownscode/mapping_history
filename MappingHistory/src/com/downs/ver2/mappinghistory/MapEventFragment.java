package com.downs.ver2.mappinghistory;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.Marker;



public class MapEventFragment extends Fragment {
	
	// the main map fragment that displays the other classes
	
	private static final String TAG = "MAP_FRAG";
	GoogleMap mMap;
	TextView drawerText;
	ImageButton nextButton;
	//ImageButton prevButton;
	int mapIndex;
	MapEventInfo selectedMapEvent;
	int userSelection;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		drawerText = (TextView) getActivity().findViewById(R.id.content);
		nextButton = (ImageButton) getActivity().findViewById(R.id.next_button);
		//prevButton = (ImageButton) getActivity().findViewById(R.id.prev_button);
		mapIndex = 0;
		
		
		Log.i(TAG,"onActivtyCreated called");
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_map, container,
				false);
		Log.i(TAG, "oncreateView called");
		
		return rootView;	
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Log.i(TAG, "onAttach called");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Bundle args = getArguments();
		if (args != null && args.containsKey("selection")){
			userSelection = args.getInt("selection");
		}
		else 
			userSelection = 0;
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate called userSelection = " + userSelection);	
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		// this is to get rid of the marker info after it has been clicked
		// and to keep it from centering the map on marker clicks
		mMap.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker arg0) {
				if (arg0.isInfoWindowShown())
					arg0.hideInfoWindow();
				else
					arg0.showInfoWindow();
				return true;
			}
		});
		
		
		// the MapEventInfo that will be displayed
		selectedMapEvent = getWhichMapEvent(userSelection);
		
		
		
		nextButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mapIndex >= selectedMapEvent.getSlideShowUpper()) {
					mapIndex = selectedMapEvent.getSlideShowUpper();
				} else {
					mapIndex++;
				}
				
				selectedMapEvent.mapSlideShow(mapIndex);
			}
		});
		
		/*
		 * work in progress on getting the action bar
		 * title to change based on fragment showing
		// Set title bar
	    ((MainActivity) getActivity())
	            .setActionBarTitle("Fragment Title");
	    */
	    
		Log.i(TAG, "onStart called");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "onResume called");
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		
		
		// if you don't add this, when you go back to main menu and then come to
		// this fragment = crash
		Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
		FragmentTransaction ft = getActivity().getFragmentManager()
				.beginTransaction();
		ft.remove(fragment);
		ft.commit();
		
		Log.i(TAG, "onDestroy called");

	}

	public MapEventFragment() {
		
	}

	// this is for getting which mapInfo to show
	public MapEventInfo getWhichMapEvent(int userChoice) {
		MapEventInfo mapEvent;
		switch (userChoice) {
		case 0:
			mapEvent = new AlexanderInfo(mMap, drawerText);
			break;
		case 1:
			mapEvent = new AgeOfExplorationInfo(mMap, drawerText);
			break;
		case 2:
			mapEvent = new NapoleonWaterlooInfo(mMap, drawerText);
			break;
		case 3:
			mapEvent = new BattleOfSaratogaInfo(mMap, drawerText);
			break;
		default:
			mapEvent = new FirstBullRunInfo(mMap, drawerText);
			break;
		}
		return mapEvent;
	}

}
