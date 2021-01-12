package be.technifutur.java2020.dto;

import java.sql.Date;
import java.util.Objects;

public class Album {
	
	private String name;
	private Label label;
	private Band band;
	private Date release_Date;
	private Style style;
	
	
	public Album(String name, Band band, Label label, Date release_Date2, Style style) {
		this.name = name;
		this.band = band;
		this.label = label;
		this.release_Date = release_Date2;
		this.style = style;
	}
	
	public Album () {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Band getBand() {
		return band;
	}
	public void setBand(Band band) {
		this.band = band;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public String getRelease_Date() {
		return release_Date.toString();
	}
	public void setRelease_Date(Date release_Date) {
		this.release_Date = release_Date;
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
		builder.append("Album [name=");
		builder.append(name);
		builder.append(", band=");
		builder.append(band);
		builder.append(", label=");
		builder.append(label);
		builder.append(", release_Date=");
		builder.append(release_Date);
		builder.append(", style=");
		builder.append(style);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return name == album.name &&
                band == album.band &&
                label == album.label &&
                release_Date == album.release_Date &&
                style == album.style;
    }
	
	 @Override
	    public int hashCode() {
	        return Objects.hash(name, band, label, release_Date, style);
	    }

	
	
	
}
