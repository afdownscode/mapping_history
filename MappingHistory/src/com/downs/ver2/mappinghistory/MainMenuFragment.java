package com.downs.ver2.mappinghistory;



import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenuFragment extends ListFragment {
	
	// displays a list of events
	
	private final String TAG = "MMF_fragment";
	OnEventSelectedListener mCallback;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		
		// crudely construct a list of historical event options
		 String[] values = new String[] { "Alexander", "The Age of Exploration",
				 "Napoleon - Waterloo","The American Revolution - Saratoga", 
				 "The American Civil War - First Bull Run" };
			    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
			        android.R.layout.simple_list_item_1, values);
			    setListAdapter(adapter);
			    Log.i(TAG,"onActivtyCreated called");
	}
	

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// get the event back to main activity
		mCallback.onEventSelected(position);	
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		 // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnEventSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnEventSelectedListener");
        }
        Log.i(TAG,"onAttach called");
	}
	
	 // Container Activity must implement this interface
    public interface OnEventSelectedListener {
        public void onEventSelected(int position);
    }

}
