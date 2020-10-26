
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

import com.company.cicd_jndi_docker_example.dal.CountryDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Country
 */
@DAO(CountryDAO.class)
@Caption("{%country}")
@Entity
@Cacheable(true)
@Table(name = "country", catalog = "sakila")
public class Country implements java.io.Serializable
{
	
	private Short     countryId;
	private String    country;
	private Date      lastUpdate;
	private Set<City> cities = new HashSet<City>(0);
	
	public Country()
	{
	}
	
	@Caption("CountryId")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "country_id", unique = true, nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Short getCountryId()
	{
		return this.countryId;
	}
	
	public void setCountryId(Short countryId)
	{
		this.countryId = countryId;
	}
	
	@Caption("Country")
	@Column(name = "country", nullable = false, columnDefinition = "VARCHAR", length = 50)
	public String getCountry()
	{
		return this.country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
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
	
	@Caption("Cities")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<City> getCities()
	{
		return this.cities;
	}
	
	public void setCities(Set<City> cities)
	{
		this.cities = cities;
	}
	
}
