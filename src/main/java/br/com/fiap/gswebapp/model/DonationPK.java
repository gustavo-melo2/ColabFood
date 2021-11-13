package br.com.fiap.gswebapp.model;

import java.io.Serializable;

public class DonationPK implements Serializable{

	
	private Long advertising;
	
	private Long user;


	
	
	public DonationPK() {
		super();
	}



	public DonationPK(Long advertising, Long user) {
		super();
		this.advertising = advertising;
		this.user = user;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advertising == null) ? 0 : advertising.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonationPK other = (DonationPK) obj;
		if (advertising == null) {
			if (other.advertising != null)
				return false;
		} else if (!advertising.equals(other.advertising))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



	public Long getAdvertising() {
		return advertising;
	}



	public void setAdvertising(Long advertising) {
		this.advertising = advertising;
	}



	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	
	
	
	
	
}
