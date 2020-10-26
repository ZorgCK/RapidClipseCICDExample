
package com.company.cicd_jndi_docker_example.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import com.company.cicd_jndi_docker_example.dal.CityDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * City
 */
@DAO(CityDAO.class)
@Caption("{%city}")
@Entity
@Cacheable(true)
@Table(name = "city", catalog = "sakila")
public class City implements java.io.Serializable
{
	
	private Short        cityId;
	private Country      country;
	private String       city;
	private Date         lastUpdate;
	private Set<Address> addresses = new HashSet<Address>(0);
	
	public City()
	{
	}
	
	@Caption("CityId")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "city_id", unique = true, nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Short getCityId()
	{
		return this.cityId;
	}
	
	public void setCityId(Short cityId)
	{
		this.cityId = cityId;
	}
	
	@Caption("Country")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Country getCountry()
	{
		return this.country;
	}
	
	public void setCountry(Country country)
	{
		this.country = country;
	}
	
	@Caption("City")
	@Column(name = "city", nullable = false, columnDefinition = "VARCHAR", length = 50)
	public String getCity()
	{
		return this.city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	@Caption("LastUpdate")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP", length = 26)
	public Date getLastUpdate()
	{
		return this.lastUpdate;
	}
	
	public void setLastUpdate(Date lastUpdate)
	{
		this.lastUpdate = lastUpdate;
	}
	
	@Caption("Addresses")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Address> getAddresses()
	{
		return this.addresses;
	}
	
	public void setAddresses(Set<Address> addresses)
	{
		this.addresses = addresses;
	}
	
}
