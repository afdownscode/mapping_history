package com.downs.ver2.mappinghistory;

import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class AgeOfExplorationInfo extends MapEventInfo{

	GoogleMap map;
	TextView tv;
	private int slideShowUpper;

	public AgeOfExplorationInfo() {

	}

	public AgeOfExplorationInfo(GoogleMap _map, TextView _tv) {
		this.map = _map;
		this.tv = _tv;
		slideShowUpper = 0;
		initMap();

	}

	public int getSlideShowUpper() {
		return slideShowUpper;
	}

	public void initMap() {
		map.clear();
		LatLng initLL = new LatLng(16.049441,58.5320575);
		map.moveCamera(CameraUpdateFactory.newLatLng(initLL));
		map.moveCamera(CameraUpdateFactory.zoomTo(3));
		tv.setText("The roots of the Age of Exploration extend back to the time of Alexander. " +
				"The fantastical stories and mystery surrounding the far East were the stuff " +
				"of legend. But it was the exotic goods (mostly silk and spices) that were " +
				"traded on the overland \"Spice Road\" that spurred the need to connect with " +
				"the Far East. With the Pax Mongolia, the Italian maritime states of Genoa " +
				"and Venice became fabulously wealthy dealing with the Arab and Jewish traders.");
	}

	public void mapSlideShow(int index) {

		switch (index) {
		case 0:
			initMap();
			break;
		default:
			break;
		}

	}

}
