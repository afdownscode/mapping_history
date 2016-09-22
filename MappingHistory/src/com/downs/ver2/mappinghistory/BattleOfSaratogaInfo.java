package com.downs.ver2.mappinghistory;

import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class BattleOfSaratogaInfo extends MapEventInfo{

	GoogleMap map;
	TextView tv;

	private int slideShowUpper;

	public BattleOfSaratogaInfo() {

	}

	public BattleOfSaratogaInfo(GoogleMap _map, TextView _tv) {
		this.map = _map;
		this.tv = _tv;
		slideShowUpper = 0;
		initMap();
	}

	public int getSlideShowUpper() {
		return slideShowUpper;
	}

	@Override
	public void initMap() {
		map.clear();
		LatLng initLL = new LatLng(42.4067395,-73.2926043);
		map.moveCamera(CameraUpdateFactory.newLatLng(initLL));
		map.moveCamera(CameraUpdateFactory.zoomTo(6));
		tv.setText("In autumn of 1777, the newly independant colonies were in bad shape. Support " +
				"for the rebellion was waning, the British army was moving at will, and without " +
				"a military victory; France would not aid the colonies in their struggle. " +
				"All that changed on October 17, when British general John Burgoyne surrendered " +
				"his entire army to Horatio Gates in upstate New York near the small town of " +
				"Saratoga.");
		
	}

	@Override
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
