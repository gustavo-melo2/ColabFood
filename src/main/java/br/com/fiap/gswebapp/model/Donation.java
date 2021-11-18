package br.com.fiap.gswebapp.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "GS_DONATION")
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_advertising")
	private Advertising advertising;

	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@Temporal(TemporalType.DATE)
	private Calendar dateDonation;
	
	private String status;

	public Donation() {
		super();
	}


	public Donation( Advertising advertising, Calendar dateDonation, String status) {
		super();
		this.advertising = advertising;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Donation donation = (Donation) o;
		return Objects.equals(id, donation.id) && Objects.equals(advertising, donation.advertising) && Objects.equals(user, donation.user) && Objects.equals(dateDonation, donation.dateDonation) && Objects.equals(status, donation.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, advertising, user, dateDonation, status);
	}
}
