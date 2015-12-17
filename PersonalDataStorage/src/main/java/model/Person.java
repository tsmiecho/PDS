package model;

/**
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public class Person {

	private String name;

	private String msisdn;

	private String email;

	private String comment;

	private String photoUrl;

	private String city;

	private String street;

	private String streetNumber;

	private String flatNumber;;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", email=");
		builder.append(email);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", photoUrl=");
		builder.append(photoUrl);
		builder.append(", city=");
		builder.append(city);
		builder.append(", street=");
		builder.append(street);
		builder.append(", streetNumber=");
		builder.append(streetNumber);
		builder.append(", flatNumber=");
		builder.append(flatNumber);
		builder.append("]");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

}
