package br.com.fiap.gswebapp.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "GS_USER")
public class User implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String documentNumber;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private Type type;
	
	private String phoneNumber;
	
	private String country;
	
	private String address;
	
	private String city;
	
	private String state;

	public User() {
		super();
	}

	
	public User(String documentNumber, String name, String password, Type type, String phoneNumber, String email,
			String country, String address, String city, String state) {
		super();
		this.documentNumber = documentNumber;
		this.name = name;
		this.password = password;
		this.type = type;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.country = country;
		this.address = address;
		this.city = city;
		this.state = state;
	}


	public User(Long id, String documentNumber, String name, String password, Type type, String phoneNumber,
			String email, String country, String address, String city, String state) {
		super();
		this.id = id;
		this.documentNumber = documentNumber;
		this.name = name;
		this.password = password;
		this.type = type;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.country = country;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}


	@Override
	public String getUsername() {
		return this.email;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
	
	
}
