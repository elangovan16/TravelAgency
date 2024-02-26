package travelagency.dto;

import java.util.List;

public class Location {

	private String locationName;
	private int day;
	private int night;
	private int price;
	private List<Place> places;

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getNight() {
		return night;
	}

	public void setNight(int night) {
		this.night = night;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}
}
