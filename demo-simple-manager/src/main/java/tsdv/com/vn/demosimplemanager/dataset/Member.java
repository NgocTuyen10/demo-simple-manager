package tsdv.com.vn.demosimplemanager.dataset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Member {
	@Id
	@NotNull(message = "userid not null")
	private String userid;

	@Pattern(regexp = "^[0-9]{4}-[01]?[0-9]-[0123]?[0-9]$", message = "Enter the right format datetime")
	private String birhdate;
	private String email;

	public Member() {

	}

	public Member(String userid, String birthdate, String email) {
		this.userid = userid;
		this.setBirhdate(birthdate);
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBirhdate() {
		return birhdate;
	}

	public void setBirhdate(String birhdate) {
		this.birhdate = birhdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
