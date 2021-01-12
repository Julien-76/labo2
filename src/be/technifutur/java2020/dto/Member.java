package be.technifutur.java2020.dto;

import java.sql.Date;
import java.util.Objects;

public class Member {

	private String name, first_Name, origin;
	private Date birthdate;
	private Role role, second_Role;
	private int id_Member;
	
	public Member(String name, String first_Name, Role role, Date birthdate, String origin, int id_Member, Role second_Role) {
		
		this.name = name;
		this.first_Name = first_Name;
		this.origin = origin;
		this.birthdate = birthdate;
		this.role = role;
		this.id_Member = id_Member;
		this.second_Role = second_Role;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public int getId_Member() {
		return id_Member;
	}
	public void setId_Member(int id_Member) {
		this.id_Member = id_Member;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Role getSecond_Role() {
		return second_Role;
	}
	public void setSecond_Role(Role second_Role) {
		this.second_Role = second_Role;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [name=");
		builder.append(name);
		builder.append(", first_Name=");
		builder.append(first_Name);
		builder.append(", origin=");
		builder.append(origin);
		builder.append(", birthdate=");
		builder.append(birthdate);
		builder.append(", role=");
		builder.append(role);
		builder.append(", second_Role=");
		builder.append(second_Role);
		builder.append(", id_Member=");
		builder.append(id_Member);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, first_Name, role, birthdate, origin, id_Member, second_Role);
	}
	
	
	
}
