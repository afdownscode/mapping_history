package com.downs.ver2.mappinghistory;

import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class AlexanderInfo extends MapEventInfo{
	
	GoogleMap map;
	TextView tv;
	
	private int slideShowUpper;
	
	
	public AlexanderInfo() {
	}
	
	public AlexanderInfo(GoogleMap _map, TextView _tv) {
		this.map = _map;
		this.tv = _tv;
		slideShowUpper = 0;
		initMap();
	}
	
	public int getSlideShowUpper() {
		return slideShowUpper;
	}
	
	
	public void initMap(){
		map.clear();
		LatLng initLL = new LatLng(39.2521937,22.6067633);
		map.moveCamera(CameraUpdateFactory.newLatLng(initLL));
		map.moveCamera(CameraUpdateFactory.zoomTo(5));
		tv.setText("In 336 BCE, Alexander became the King of Macedonia. He was twenty years old. " +
				"Alexander's ambition was only equaled by his self-confidence. From the age of " +
				"sixteen until his death at thirty-two, he was always in a military campaign. " +
				"He never lost a battle and in the twelve years he was king, Alexander conquered " +
				"the known world.");
		
	}
	
	public void mapSlideShow (int index){
		
		switch (index) {
		case 0:
			initMap();
			break;
		default:
			break;
		}
		
	}

}
