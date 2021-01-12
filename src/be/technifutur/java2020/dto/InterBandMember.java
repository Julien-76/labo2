package be.technifutur.java2020.dto;

import java.util.Objects;

public class InterBandMember {

	int id_Member;
	String band;
	
	
	public int getId_Member() {
		return id_Member;
	}
	public void setId_Member(int id_Member) {
		this.id_Member = id_Member;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InterBandMember [id_Member=");
		builder.append(id_Member);
		builder.append(", band=");
		builder.append(band);
		builder.append("]");
		return builder.toString();
	}
	
	 @Override
	    public int hashCode() {
	        return Objects.hash(band, id_Member);
	    }

	
	
	
}
