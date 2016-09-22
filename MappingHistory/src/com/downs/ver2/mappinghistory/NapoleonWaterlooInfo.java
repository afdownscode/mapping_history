package com.downs.ver2.mappinghistory;

import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class NapoleonWaterlooInfo extends MapEventInfo {

	GoogleMap map;
	TextView tv;
	int slideShowUpper;

	public NapoleonWaterlooInfo() {

	}

	public NapoleonWaterlooInfo(GoogleMap _map, TextView _tv) {
		this.map = _map;
		this.tv = _tv;
		slideShowUpper = 0;
		initMap();

	}

	@Override
	public void initMap() {
		map.clear();
		LatLng initLL = new LatLng(46.0377297,2.5567154);
		map.moveCamera(CameraUpdateFactory.newLatLng(initLL));
		map.moveCamera(CameraUpdateFactory.zoomTo(6));
		tv.setText("In March of 1815, Europe was in an uproar. Napoleon had just arrived in France " +
				"after escaping from exile on the island of Elba. The army that had been sent to detain " +
				"him had embraced him as the rightful emperor of France. Napoleon was back.");

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

	@Override
	public int getSlideShowUpper() {
		return slideShowUpper;
	}

}
