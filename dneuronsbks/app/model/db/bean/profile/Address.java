package model.db.bean.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@PersistenceUnit(name = "profile")
@Table(name = "address")
public class Address extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer addressId;
	private String address1;
	private String address2;
	private String city;
	private String stateProvince;
	private String country;
	private String postalCode;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email1;
	private String email2;
	private String email3;
	private String contactPersonName1;
	private String contactPersonName2;
	private String contactPersonName3;
	private String fax;
	
	@Id
	@GeneratedValue
	@Column(name = "address_id")
	public Integer getAddressId() {
		return addressId;
	}

	@Id
	@GeneratedValue
	@Column(name = "address_id")
	public void setAddressId(Integer accountId) {
		this.addressId = accountId;
	}

	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}

	@Column(name = "address1")
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}

	@Column(name = "address2")
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}

	@Column(name = "city")
	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state_provice")
	public String getStateProvince() {
		return stateProvince;
	}

	@Column(name = "state_provice")
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	@Column(name = "country")
	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "postal_code")
	public String getPostalCode() {
		return postalCode;
	}

	@Column(name = "postal_code")
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "phone1")
	public String getPhone1() {
		return phone1;
	}

	@Column(name = "phone1")
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	@Column(name = "phone2")
	public String getPhone2() {
		return phone2;
	}

	@Column(name = "phone2")
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	@Column(name = "phone3")
	public String getPhone3() {
		return phone3;
	}

	@Column(name = "phone3")
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	@Column(name = "email1")
	public String getEmail1() {
		return email1;
	}

	@Column(name = "email1")
	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	@Column(name = "email2")
	public String getEmail2() {
		return email2;
	}

	@Column(name = "email2")
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	@Column(name = "email3")
	public String getEmail3() {
		return email3;
	}

	@Column(name = "email3")
	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	@Column(name = "contact_person_name1")
	public String getContactPersonName1() {
		return contactPersonName1;
	}
	
	@Column(name = "contact_person_name1")
	public void setContactPersonName1(String contactPersonName1) {
		this.contactPersonName1 = contactPersonName1;
	}

	@Column(name = "contact_person_name2")
	public String getContactPersonName2() {
		return contactPersonName2;
	}

	@Column(name = "contact_person_name2")
	public void setContactPersonName2(String contactPersonName2) {
		this.contactPersonName2 = contactPersonName2;
	}

	@Column(name = "contact_person_name3")
	public String getContactPersonName3() {
		return contactPersonName3;
	}

	@Column(name = "contact_person_name3")
	public void setContactPersonName3(String contactPersonName3) {
		this.contactPersonName3 = contactPersonName3;
	}

	@Column(name = "fax")
	public String getFax() {
		return fax;
	}

	@Column(name = "fax")
	public void setFax(String fax) {
		this.fax = fax;
	}

	public static Finder<Integer, Address> finder = new Finder<Integer, Address>("profile",
			Integer.class, Address.class);

}
