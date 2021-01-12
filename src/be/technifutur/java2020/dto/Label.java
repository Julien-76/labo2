package be.technifutur.java2020.dto;

import java.util.Objects;

public class Label {

	private String name, nationality;
	private int creation;
	
	public Label(String name, String nationality, int creation) {
		this.name = name;
		this.nationality = nationality;
		this.creation = creation;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getCreation() {
		return creation;
	}
	public void setCreation(int creation) {
		this.creation = creation;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Label [name=");
		builder.append(name);
		builder.append(", nationality=");
		builder.append(nationality);
		builder.append(", creation=");
		builder.append(creation);
		builder.append("]");
		return builder.toString();
	}
	
	 @Override
	    public int hashCode() {
	        return Objects.hash(name, nationality, creation);
	    }

	
	
}
