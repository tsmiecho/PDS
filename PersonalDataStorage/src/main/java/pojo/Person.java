package pojo;

/**
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public class Person {

	private String name;

	private String msisdn;

	private String mail;

	private String comment;

	private String photoUrl;

	public Person(String name, String msisdn, String mail, String comment, String photoUrl) {
		this.name = name;
		this.msisdn = msisdn;
		this.mail = mail;
		this.comment = comment;
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", photoUrl=");
		builder.append(photoUrl);
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

}
