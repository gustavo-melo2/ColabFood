package br.com.fiap.gswebapp.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "GS_ADVERTISING")
public class Advertising implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	@NotBlank(message = "{advertising.title.blank}")
	private String title;

	@Min(value = 1, message = "{advertising.quantity.min}")
	private int quantity;
	
	private int remainingQuantity;

	@NotBlank(message = "{advertising.description.blank}")
	private String description;

	@NotBlank(message = "{advertising.address.blank}")
	private String address;

	@NotBlank(message = "{advertising.city.blank}")
	private String city;

	@NotBlank(message = "{advertising.state.blank}")
	private String state;

	@NotBlank(message = "{advertising.country.blank}")
	private String country;

	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	public Advertising() {
		super();
	}
	
	public Advertising(String title, int quantity, int remainingQuantity, String description, String address,
			String city, String state, String country) {
		super();
		this.title = title;
		this.quantity = quantity;
		this.remainingQuantity = remainingQuantity;
		this.description = description;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}


	public Advertising(Long id, String title, int quantity, int remainingQuantity, String description, String address,
			String city, String state, String country) {
		super();
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.remainingQuantity = remainingQuantity;
		this.description = description;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
