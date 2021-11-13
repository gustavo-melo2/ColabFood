package br.com.fiap.gswebapp.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GS_DONATION")
@IdClass(DonationPK.class)
public class Donation {
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_advertising")
	private Advertising advertising;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_user")
	private User user;
	
	@Temporal(TemporalType.DATE)
	private Calendar dateDonation;
	
	private String status;

	public Donation() {
		super();
	}


	public Donation( Advertising advertising, User user, Calendar dateDonation, String status) {
		super();
		this.advertising = advertising;
		this.user = user;
		this.dateDonation = dateDonation;
		this.status = status;
	}

	

	public Advertising getAdvertising() {
		return advertising;
	}

	public void setAdvertising(Advertising advertising) {
		this.advertising = advertising;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Calendar getDateDonation() {
		return dateDonation;
	}

	public void setDateDonation(Calendar dateDonation) {
		this.dateDonation = dateDonation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

	
	
	
}
