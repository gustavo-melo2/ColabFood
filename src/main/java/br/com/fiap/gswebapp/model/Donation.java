package br.com.fiap.gswebapp.model;

import java.util.Calendar;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GS_DONATION")
public class Donation {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Calendar dateDonation;
	
	private String status;

	
	public Donation() {
		super();
	}

	public Donation(Calendar dateDonation, String status) {
		super();
		this.dateDonation = dateDonation;
		this.status = status;
	}

	public Donation(Long id, Calendar dateDonation, String status) {
		super();
		this.id = id;
		this.dateDonation = dateDonation;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
