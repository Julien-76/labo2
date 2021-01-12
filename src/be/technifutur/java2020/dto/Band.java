package be.technifutur.java2020.dto;

import java.util.Objects;

public class Band {
	
	private String name, nationality;
	private Label label;
	private int creation, members, albums;
	private Style style;
	
	public Band(String name, String nationality, int creation, Style style, Label label, int members, int albums) {
		this.name = name;
		this.nationality = nationality;
		this.creation = creation;
		this.style = style;
		this.label = label;
		this.members = members;
		this.albums = albums;
	}
	
	public Band () {
		
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
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public int getCreation() {
		return creation;
	}
	public void setCreation(int creation) {
		this.creation = creation;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	public int getAlbums() {
		return albums;
	}
	public void setAlbums(int albums) {
		this.albums = albums;
	}
	public String getStyle() {
		return style.toString();
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	
	
	
	 @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Band [name=").append(name).append(", nationality=").append(nationality).append(", label=")
				.append(label).append(", creation=").append(creation).append(", members=").append(members)
				.append(", albums=").append(albums).append(", style=").append(style).append("]");
		return builder.toString();
	}
	 
	 


	@Override
	    public int hashCode() {
	        return Objects.hash(name, nationality, creation, style, label, members, albums);
	    }

	
	
}
