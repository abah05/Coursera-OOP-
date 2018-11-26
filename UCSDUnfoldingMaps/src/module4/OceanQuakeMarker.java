package module4;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Ammar Diallo
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	private int side = 3;
	private final double MaxMag = 5;
	private final double MinMag = 4;
	
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	

	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		// Drawing a centered square for Ocean earthquakes
		// DO NOT set the fill color.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered square.
		
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		
		// TODO: Implement this method
		pg.pushStyle();
		if((getMagnitude() > MinMag) && (getMagnitude() < MaxMag)) {
			pg.rect(x, y, 3*side, 3*side);
		}
		if(getMagnitude() > MaxMag) {
			pg.rect(x,y,4*side,4*side);
		}
		if(getMagnitude() < MinMag) {
			pg.rect(x, y, 2*side, 2*side);
		}
		pg.popStyle();
		
	}

}
