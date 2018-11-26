package GUIPackage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class ExpectedLife extends PApplet{
	private UnfoldingMap map;
	private Map<String, Float> LifeExpectancy;
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 800, 500, new Google.GoogleMapProvider());
		map.zoomToLevel(2);
		//map.zoomAndPanTo(new Location(37.0902f,95.7129f),2);
		MapUtils.createDefaultEventDispatcher(this, map);
		LifeExpectancy = LifeToExpect("Life.csv");
		
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);
		shadeCountries();
		//map.setZoomRange(4,7);
	}
	private void shadeCountries() {
		// TODO Auto-generated method stub
		for(Marker marker: countryMarkers) {
			String countryID = marker.getId();
			

			if(LifeExpectancy.containsKey(countryID)) {
				float lifeExp = LifeExpectancy.get(countryID);
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
				marker.setColor(color(255-colorLevel,0,colorLevel));
			}
			else {
				marker.setColor(color(150,150,150));
			}
		}
	}
	public void draw() {
		map.draw();
	}
	
	private Map<String, Float> LifeToExpect(String filename){
		Map<String, Float> exp = new HashMap<String, Float>();
		
		String[] rows= loadStrings(filename);
		for(String row:rows) {
			String[] columns = row.split(",");
			float value = Float.parseFloat(columns[1]);
			exp.put(columns[2], value);
		}
		
		return exp;
		
	}

}
