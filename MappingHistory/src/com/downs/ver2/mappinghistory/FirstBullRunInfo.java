package com.downs.ver2.mappinghistory;

import java.util.ArrayList;
import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class FirstBullRunInfo extends MapEventInfo {
	
	GoogleMap map;
	TextView tv;
	
	private int slideShowUpper;
	
	
	public int getSlideShowUpper() {
		return slideShowUpper;
	}

	private Marker unionOne;
	private Marker unionTwo;
	private Marker unionThree;
	private Marker confedOne;
	private Marker confedTwo;
	private Marker confedThree;
	private Marker clashOne;
	private Marker clashTwo;
	private Marker clashThree;
	private Marker clashFour;
	private Polyline rebJ18;
	private Polyline unionTroopMoveOne;
	private Polyline unionTroopMoveTwo;
	private Polyline rebelTroopMoveOne;
	private Polyline rebelTroopMoveTwo;
	private GroundOverlay groundOverlayMcDowell;
	private GroundOverlay groundOverlay_ConFed_advance;
	private GroundOverlay groundOverlay_UnionRet_one;
	private GroundOverlay groundOverlay_UnionRet_two;
	

	public FirstBullRunInfo() {
		
	}
	
	public FirstBullRunInfo(GoogleMap _map, TextView _tv) {
		this.map = _map;
		this.tv = _tv;
		slideShowUpper = 11;
		initMap();
	}
	
	public void initMap() {
		LatLng initLL = new LatLng(34.171065,-86.5990365);
		map.moveCamera(CameraUpdateFactory.newLatLng(initLL));
		tv.setText("In April of 1861, President Lincoln calls for 75,000 volunteers to put " +
				"put down the rebellion after Ft. Sumter in Charlseton, South Carolina was " +
				"bombarded into submission. Five days later, Virginia secedes from the Union. " +
				"By June, Arkansas, North Carolina, and Tennessee had seceded. Most Americans " +
				"thought the Civil War would be a short, one battle adventure. A month later, " +
				"on the fields around Bull Run Creek in northern Virginia, the war would become " +
				"a bloody reality.");
		
	}
	
	public void mapSlideShow(int index) {

		switch (index) {
		case 0:
			initMap();
			break;
		case 1:
			moveToVirginia_One();
			break;
		case 2:
			mcDowellMovesToCenterville_Two();
			break;
		case 3:
			troopsOnJuly18_Three();
			break;
		case 4:
			skirmishBlackburnFord_Four();
			break;
		case 5:
			july21Movement_Five();
			break;
		case 6:
			evansMovesToMeet_Six();
			break;
		case 7:
			battle1130AM_Seven();
			break;
		case 8:
			rebelCollapseNoon_Eight();
			break;
		case 9:
			theTideturns_Nine();
			break;
		case 10:
			theRebelPush_Ten();
			break;
		case 11:
			aftermath_Eleven();
			break;
		default:
			break;
		}

	}
	
	public void moveToVirginia_One() {
		LatLng virginiaOverView = new LatLng(39.022676, -77.494306);
		CameraPosition virginiaFromTop = new CameraPosition(virginiaOverView, 9, 90, 0);
		CameraUpdate moveToVaTheatre = CameraUpdateFactory.newCameraPosition(virginiaFromTop);
		map.animateCamera(moveToVaTheatre, 4000, onFinish());
		unionOne = map.addMarker(new MarkerOptions().position(new LatLng(38.8935965,-77.014576))
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.usflag200))
				.title("McDowell").snippet("35,000 troops in Washington DC"));
		confedOne = map.addMarker(new MarkerOptions().position(new LatLng(38.691838,-77.49452))
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.rebelflag200))
				.title("Beauregard").snippet("20,000 troops in Manassas"));
		unionTwo = map.addMarker(new MarkerOptions().position(new LatLng(39.268101, -78.062091))
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.usflag200))
				.title("Patterson").snippet("18,000 troops in the Shenendoah Valley"));
		confedTwo = map.addMarker(new MarkerOptions().position(new LatLng(39.182994, -78.188433))
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.rebelflag200))
				.title("Johnston").snippet("12,000 troops in Winchester"));
		
		String message = 
				"In May, the Confederate government moves its capitol from Mobile, AL to Richmond, VA." +
				"By July, Confederate general P.G.T. Beauregard has 20000 troops in Manassas, VA; 30 miles from Washington DC." +
				"Lincoln orders Union General McDowell, commanding 35000 troops in DC to remove the threat.";
		tv.setText(message);
		
		Log.i("moveToVirginia", "called");	
		
	}
	
	public void mcDowellMovesToCenterville_Two() {
		unionTroopMoveOne = map.addPolyline(new PolylineOptions().add(new LatLng(38.837464, -77.434265))
				.add(new LatLng(38.8935965,-77.014576)).color(Color.BLUE).width(10).visible(true));
		unionTroopMoveOne.setVisible(false);
		BitmapDescriptor mcDowellMoveCenterville = BitmapDescriptorFactory.fromResource(R.drawable.blue_left_arrow);
		LatLngBounds bounds = new LatLngBounds(new LatLng(38.847625, -77.389376), new LatLng(38.905891, -77.107851));
		groundOverlayMcDowell = map.addGroundOverlay(new GroundOverlayOptions()
	     .image(mcDowellMoveCenterville)
	     .positionFromBounds(bounds)
	     .transparency(0f)
	     .bearing(0f));
		
		String message = "McDowell moves to Centerville, VA on July 18. " +
				"Meanwhile, in Winchester, Confederate general Johnston slips away from Union general Patterson, commanding 18000 troops. " +
				"He loads his 12,000 troops on to rail cars to move to Manassas. " +
				"It is the first time in history that railroads are used to move troops into combat.";
		tv.setText(message);		
		Log.i("mcDowellMovesToCenterville", "called");	
	}
	
	public void troopsOnJuly18_Three() {
		groundOverlayMcDowell.setVisible(false);
		unionTwo.setVisible(false);
		confedTwo.setVisible(false);
		
		CameraPosition troopsJuly18 = new CameraPosition(new LatLng(38.811983,-77.4562607), 14, 45, 0);
		CameraUpdate moveToTroopViewJuly18 = CameraUpdateFactory.newCameraPosition(troopsJuly18);
		map.animateCamera(moveToTroopViewJuly18, 3000, onFinish());
		map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
		LatLng pgtBinMan = new LatLng(38.789081, -77.444931);
		confedOne.setPosition(pgtBinMan);
		PolylineOptions rebJ18Options = new PolylineOptions()
				.add(new LatLng(38.797509, -77.439806))
				.add(new LatLng(38.802459, -77.443583))
				.add(new LatLng(38.802191, -77.449762))
				.add(new LatLng(38.796706, -77.450277))
				.add(new LatLng(38.795502, -77.456972)).color(Color.RED);
		rebJ18 = map.addPolyline(rebJ18Options);
		unionOne.setPosition(new LatLng(38.839964, -77.434265));
		unionOne.setSnippet("31,000 troops in Centerville");
		
		String message = "Beauregard takes up defensive positions across Bull Run Creek, south of Centerville.";
		tv.setText(message);
		Log.i("troopsOnJuly18", "called");
	}
	
	public void skirmishBlackburnFord_Four() {
		ArrayList<LatLng> blackBurnMove = new ArrayList<LatLng>();
		blackBurnMove.add(new LatLng(38.837884, -77.431159));
		blackBurnMove.add(new LatLng(38.832669, -77.432532));
		blackBurnMove.add(new LatLng(38.812207, -77.447810));
		blackBurnMove.add(new LatLng(38.803378, -77.449355));
		unionTroopMoveOne.setPoints(blackBurnMove);
		unionTroopMoveOne.setVisible(true);
		clashOne = map.addMarker(new MarkerOptions()
				.position(new LatLng(38.803378, -77.449355))
				.title("BlackBurn Fords")
				.snippet("")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.explosion)).draggable(false));

		String message = "On July 18th, McDowell sends a small force to reconnoiter Blackburn Fords to the south.\n"
				+ "The force meets heavy resistance from James Longstreet's division.";
		tv.setText(message);
		Log.i("skirmishBlackburnFord", "called");
	}
	
public void july21Movement_Five() {
		
		CameraPosition july21EightAM = new CameraPosition(new LatLng(38.805849, -77.500478), 13, 35, 0);
		CameraUpdate moveTojuly21EightAM = CameraUpdateFactory.newCameraPosition(july21EightAM);
		map.animateCamera(moveTojuly21EightAM, 4000, onFinish());
		
		ArrayList<LatLng> july21Move = new ArrayList<LatLng>();
		july21Move.add(new LatLng(38.838619, -77.431073));
		july21Move.add(new LatLng(38.838352, -77.441716));
		july21Move.add(new LatLng(38.830463, -77.476048));
		july21Move.add(new LatLng(38.851321, -77.487206));
		july21Move.add(new LatLng(38.844235, -77.538018));
		july21Move.add(new LatLng(38.829125, -77.531151));
		unionTroopMoveOne.setPoints(july21Move);
		unionTroopMoveTwo = map.addPolyline(new PolylineOptions().add(new LatLng(38.830463, -77.476048)).add(new LatLng(38.824044, -77.503686))
				.color(Color.BLUE).width(10).visible(true));
		
		clashOne.setPosition(new LatLng(38.823044, -77.503686));
		clashOne.setTitle("the Stone Bridge");
		String message = "At 2:30AM on July 21th, McDowell sends 12000 exhausted and inexperienced troops " +
				"on a flanking mission to the northwest of the confederate position " +
				"while sending a diversionary force to the Stone Bridge due west.";
		tv.setText(message);
		Log.i("july21Movement", "called");	
	}

	public void evansMovesToMeet_Six() {
		
		rebelTroopMoveOne = map.addPolyline(new PolylineOptions()
				.add(new LatLng(38.823993, -77.504308)).add(new LatLng(38.822054, -77.513105)).add(new LatLng(38.828340, -77.528598))
				.color(Color.RED).width(10).visible(true));
		rebelTroopMoveTwo = map.addPolyline(new PolylineOptions()
		.add(new LatLng(38.784296, -77.454483)).add(new LatLng(38.789113, -77.514565)).add(new LatLng(38.812658, -77.524178))
		.color(Color.RED).width(10).visible(true));
		
		unionTwo.setPosition(new LatLng(38.837397, -77.544214));
		unionTwo.setTitle("Burnside");
		unionTwo.setSnippet("12,000 troops in columns...");
		unionTwo.setVisible(true);
		
		confedTwo.setPosition(new LatLng(38.824158, -77.516749));
		confedTwo.setTitle("Evans");
		confedTwo.setSnippet("900 troops");
		confedTwo.setVisible(true);
		
		confedThree = map.addMarker(new MarkerOptions().position(new LatLng(38.809178, -77.515032))
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.rebelflag200))
				.title("Reinforcements").snippet("Bartow, Bee, and Jackson's brigades..."));
		
		
		String message = "After being alerted to the Union movements by signal flag, " +
				"Confederate Colonel Evans at the Stone Bridge calls for reinforcements " +
				"and takes 900 men to meet the Union troops under Burnside crossing " +
				"to the northwest. Three Confederate brigades under Bartow, Bee, " +
				"and Jackson rush northwest to support.";
		tv.setText(message);
		Log.i("evansMovesToMeet", "called");
		
	}
	
public void battle1130AM_Seven() {
		// need more info and markers here
		CameraPosition july21ElevenAM = new CameraPosition(new LatLng(38.824729, -77.529714), 14, 25, 0);
		CameraUpdate moveTojuly21ElevenAM = CameraUpdateFactory.newCameraPosition(july21ElevenAM);
		map.animateCamera(moveTojuly21ElevenAM, 3000, onFinish());
		
		confedTwo.setPosition(new LatLng(38.827635, -77.524817));
		confedTwo.setTitle("Evans, Bartow, and Bee");
		confedTwo.setSnippet("");
		confedTwo.setVisible(true);
		
		confedThree.setTitle("Jackson");
		confedThree.setSnippet("");
		
		unionThree = map.addMarker(new MarkerOptions().position(new LatLng(38.831647, -77.516405))
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.usflag200))
				.title("Sherman").snippet("crosses behind the Confederates..."));
		
		ArrayList<LatLng> unionPosAt1130 = new ArrayList<LatLng>();
		unionPosAt1130.add(new LatLng(38.834023, -77.530958));
		unionPosAt1130.add(new LatLng(38.826869, -77.536838));
		unionTroopMoveOne.setPoints(unionPosAt1130);
		
		ArrayList<LatLng> rebPosAt1130 = new ArrayList<LatLng>();
		rebPosAt1130.add(new LatLng(38.831014, -77.525723));
		rebPosAt1130.add(new LatLng(38.825030, -77.531559));
		rebelTroopMoveOne.setPoints(rebPosAt1130);
		
		ArrayList<LatLng> shermanAttack = new ArrayList<LatLng>();
		shermanAttack.add(new LatLng(38.830647, -77.475855));
		shermanAttack.add(new LatLng(38.832385, -77.493279));
		shermanAttack.add(new LatLng(38.828373, -77.511818));
		shermanAttack.add(new LatLng(38.830112, -77.519028));
		unionTroopMoveTwo.setPoints(shermanAttack);
		
		clashOne.setPosition(new LatLng(38.827136, -77.533576));
		clashOne.setTitle("");
				
		clashTwo = map.addMarker(new MarkerOptions()
				.position(new LatLng(38.830680, -77.528812))
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.explosion)).draggable(false));
		clashThree = map.addMarker(new MarkerOptions()
				.position(new LatLng(38.831683, -77.521045))
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.explosion)).draggable(false));
		
		String message = "Evans attacks the lead Union troops which gives " +
				"Bartow and Bee time to extend his lines to the northeast. " +
				"As the fighting intensifies, Col. William T. Sherman's " +
				"brigade crosses the Bull Run to the east and suprises Bartow " +
				"and Bee... the Confederate line crumbles.";
		tv.setText(message);
		Log.i("battle1130AM", "called");	
	}

	public void rebelCollapseNoon_Eight() {

		CameraPosition july21Noon = new CameraPosition(new LatLng(38.812729,
				-77.515714), 15, 25, 0);
		CameraUpdate moveTojuly21Noon = CameraUpdateFactory
				.newCameraPosition(july21Noon);
		map.animateCamera(moveTojuly21Noon, 3000, onFinish());
		
		confedTwo.setPosition(new LatLng(38.814094, -77.510955));
		confedTwo.setTitle("Bartow, Bee, and Evans");
		confedTwo.setSnippet("the remnants try to regroup here...");
		confedTwo.setVisible(true);
		
		unionTwo.setPosition(new LatLng(38.815766, -77.522843));
		unionTwo.setTitle("Burnside delays");
		unionTwo.setSnippet("...trying to get all his troops in position");
		unionTwo.setVisible(true);
		
		unionThree.setVisible(false);

		ArrayList<LatLng> unionPosNoon = new ArrayList<LatLng>();
		unionPosNoon.add(new LatLng(38.810384, -77.523191));
		unionPosNoon.add(new LatLng(38.811087, -77.521731));
		unionPosNoon.add(new LatLng(38.818142, -77.518470));
		// unionPosNoon.add(new LatLng());
		unionTroopMoveOne.setPoints(unionPosNoon);
		unionTroopMoveTwo.setVisible(false);

		ArrayList<LatLng> jacksonPosNoon = new ArrayList<LatLng>();
		jacksonPosNoon.add(new LatLng(38.818477, -77.513878));
		jacksonPosNoon.add(new LatLng(38.808545, -77.519886));
		jacksonPosNoon.add(new LatLng(38.808010, -77.521989));
		// jacksonPosNoon.add(new LatLng());
		rebelTroopMoveOne.setPoints(jacksonPosNoon);
		rebelTroopMoveTwo.setVisible(false);

		clashOne.setPosition(new LatLng(38.808952, -77.521474));
		clashTwo.setPosition(new LatLng(38.811053, -77.520315));
		clashThree.setPosition(new LatLng(38.813394, -77.518641));
		clashFour = map.addMarker(new MarkerOptions()
				.position(new LatLng(38.809919, -77.520229))
				.title("Artillery Duel")
				.snippet("Attacks and counterattacks here...")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.explosion)).draggable(false));

		String message = "The Confederates collapse south to a position behind Henry Hill, "
				+ "the Union troops organize for a final assault. "
				+ "Confederate general Thomas Jackson deploys artillery to slow the Union advance. "
				+ "It is here that Thomas Jackson earns the nickname \"Stonewall\" for holding "
				+ "up the Union advance. An artillery duel commences while reinforcements arrive.";
		tv.setText(message);
		Log.i("rebelCollapseNoon", "called");

	}
	
public void theTideturns_Nine() {
		
		CameraPosition july212PM = new CameraPosition(new LatLng(38.812729, -77.515714), 14, 90, 30);
		CameraUpdate moveTojuly212PM = CameraUpdateFactory.newCameraPosition(july212PM);
		map.animateCamera(moveTojuly212PM, 3000, onFinish());
		
		rebJ18.setVisible(false);
		ArrayList<LatLng> unionPushToChin = new ArrayList<LatLng>();
		unionPushToChin.add(new LatLng(38.824395, -77.533190));
		unionPushToChin.add(new LatLng(38.816771, -77.529284));
		unionPushToChin.add(new LatLng(38.812759, -77.530658));
		unionTroopMoveTwo.setPoints(unionPushToChin);
		unionTroopMoveTwo.setVisible(true);
		
		ArrayList<LatLng> rebelPosOnChin = new ArrayList<LatLng>();
		rebelPosOnChin.add(new LatLng(38.808445, -77.522976));
		rebelPosOnChin.add(new LatLng(38.808044, -77.526366));
		rebelPosOnChin.add(new LatLng(38.805937, -77.535722));
		rebelPosOnChin.add(new LatLng(38.808980, -77.537181));
		rebelTroopMoveTwo.setPoints(rebelPosOnChin);
		rebelTroopMoveTwo.setVisible(true);
		
		String message = "After a fierce back and forth, in which Jackson's brigade takes " +
				"out a Union artillery battery trying to flank the Confederate left; " +
				"Union troops deploy down Chinn ridge only to find the Confederates are " +
				"already there. The Union position becomes untenable.";
		tv.setText(message);
		Log.i("theTideturns", "called");
		
	}

	public void theRebelPush_Ten() {
		
		CameraUpdate zoomOut = CameraUpdateFactory.zoomTo(13);
		map.animateCamera(zoomOut, 2000, onFinish());
		
		clashOne.setVisible(false);
		clashTwo.setVisible(false);
		clashThree.setVisible(false);
		clashFour.setVisible(false);
		
		confedTwo.setVisible(false);
		confedThree.setVisible(false);
		unionTwo.setVisible(false);
		
		unionOne.setTitle("Panic!!");
		unionOne.setSnippet("Civilians and troops jam up...");
		
		BitmapDescriptor confedAdvance = BitmapDescriptorFactory.fromResource(R.drawable.red_arrow);
		LatLngBounds bounds = new LatLngBounds(new LatLng(38.805033, -77.538984), new LatLng(38.821620, -77.524478));
		groundOverlay_ConFed_advance = map.addGroundOverlay(new GroundOverlayOptions()
	     .image(confedAdvance)
	     .positionFromBounds(bounds)
	     .transparency(0f)
	     .bearing(100f));
		
		BitmapDescriptor unionRetreat_one = BitmapDescriptorFactory.fromResource(R.drawable.blue_down_arrow);
		LatLngBounds boundsUR_one = new LatLngBounds(new LatLng(38.822831, -77.512762), new LatLng(38.828649, -77.501175));
		groundOverlay_UnionRet_one = map.addGroundOverlay(new GroundOverlayOptions()
	     .image(unionRetreat_one)
	     .positionFromBounds(boundsUR_one)
	     .transparency(0f)
	     .bearing(270f));
		
		BitmapDescriptor unionRetreat_two = BitmapDescriptorFactory.fromResource(R.drawable.blue_down_arrow);
		LatLngBounds boundsUR_two = new LatLngBounds(new LatLng(38.825773, -77.536451), new LatLng(38.836337, -77.531816));
		groundOverlay_UnionRet_two = map.addGroundOverlay(new GroundOverlayOptions()
	     .image(unionRetreat_two)
	     .positionFromBounds(boundsUR_two)
	     .transparency(0f)
	     .bearing(180f));
		
		String message = "The Confederates advance on all fronts. " +
				"The Union troops retreat north the way they came and " +
				"to the east back towards Centerville, where they get mixed " +
				"in with onlookers from Washington who had come for a picnic " +
				"and to watch the show. The retreat turns into a panic stricken rout. " +
				"The Confederates are just as disorganized and cannot give chase.";
		tv.setText(message);
		Log.i("theRebelPush", "called");
		
	}
	
	public void aftermath_Eleven() {
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		unionTroopMoveOne.setVisible(false);
		unionTroopMoveTwo.setVisible(false);
		rebelTroopMoveOne.setVisible(false);
		rebelTroopMoveTwo.setVisible(false);
		
		confedOne.setVisible(false);
		unionOne.setVisible(false);
		groundOverlay_ConFed_advance.setVisible(false);
		groundOverlay_UnionRet_one.setVisible(false);
		groundOverlay_UnionRet_two.setVisible(false);
		
		CameraPosition aftermath = new CameraPosition(new LatLng(39.2202833,-77.2802468), 9, 0, 0);
		CameraUpdate moveTo_aftermath = CameraUpdateFactory.newCameraPosition(aftermath);
		map.animateCamera(moveTo_aftermath, 3000, onFinish());
		
		clashOne.setPosition(new LatLng(39.474032, -77.738497));
		clashOne.setTitle("Antietam");
		clashOne.setSnippet("Sept. 17, 1862");
		clashOne.setVisible(true);
		clashTwo.setPosition(new LatLng(38.830279, -77.532503));
		clashTwo.setTitle("Second Bull Run");
		clashTwo.setSnippet("Aug. 28-30, 1862");
		clashTwo.setVisible(true);
		clashThree.setPosition(new LatLng(39.816578, -77.240250));
		clashThree.setTitle("Gettysburg");
		clashThree.setSnippet("July 1-3, 1863");
		clashThree.setVisible(true);
		
		String message = "The First Battle of Bull Run made the nation realize how serious " +
				"the war would become. It was the bloodiest battle in the nation's history " +
				"up to that point. 3,282 men were killed or wounded. These numbers would " +
				"soon be small compared to Second Bull Run(18,300), Antietam(20946), " +
				"or Gettysburg(35,087). The final tally of military casualities would be " +
				"over 620,000 by the end of the war.";
		tv.setText(message);
		Log.i("aftermath", "called");
		
	}

	private CancelableCallback onFinish() {
		// TODO Auto-generated method stub
		return null;
	}

}
