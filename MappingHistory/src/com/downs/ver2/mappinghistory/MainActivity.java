package com.downs.ver2.mappinghistory;

import com.downs.ver2.mappinghistory.MainMenuFragment.OnEventSelectedListener;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements OnEventSelectedListener{
	
	private final String TAG = "MainActivity"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		if (savedInstanceState == null) {
			MainMenuFragment firstFragment = new MainMenuFragment();
			getFragmentManager().beginTransaction()
					.add(R.id.container, firstFragment).commit();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	
	@Override
	public void onEventSelected(int position) {

		MapEventFragment mapEvent = new MapEventFragment();
		Bundle args = new Bundle();
		args.putInt("selection", position);
		mapEvent.setArguments(args);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.add(R.id.container, mapEvent);
		ft.addToBackStack(null);
		ft.commit();
		Log.i(TAG, "on Event Selected = " + position);

	}
	
	public void setActionBarTitle(String title) {
	    getActionBar().setTitle(title);
	}

	
}
