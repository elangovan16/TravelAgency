package travelagency.dto;

public class Place {
	private String name;
	private String about;

	public Place() {
		// TODO Auto-generated constructor stub
	}

	public Place(String name, String about) {
		this.name = name;
		this.about = about;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
