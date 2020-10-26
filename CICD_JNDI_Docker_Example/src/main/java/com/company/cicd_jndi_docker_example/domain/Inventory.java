
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

import com.company.cicd_jndi_docker_example.dal.InventoryDAO;
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
 * Inventory
 */
@DAO(InventoryDAO.class)
@Caption("{%inventoryId}")
@Entity
@Cacheable(true)
@Table(name = "inventory", catalog = "sakila")
public class Inventory implements java.io.Serializable
{
	
	private int         inventoryId;
	private Film        film;
	private Store       store;
	private Date        lastUpdate;
	private Set<Rental> rentals = new HashSet<Rental>(0);
	
	public Inventory()
	{
	}
	
	@Caption("InventoryId")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "inventory_id", unique = true, nullable = false, columnDefinition = "MEDIUMINT UNSIGNED")
	public int getInventoryId()
	{
		return this.inventoryId;
	}
	
	public void setInventoryId(int inventoryId)
	{
		this.inventoryId = inventoryId;
	}
	
	@Caption("Film")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "film_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Film getFilm()
	{
		return this.film;
	}
	
	public void setFilm(Film film)
	{
		this.film = film;
	}
	
	@Caption("Store")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "store_id", nullable = false, columnDefinition = "TINYINT UNSIGNED")
	public Store getStore()
	{
		return this.store;
	}
	
	public void setStore(Store store)
	{
		this.store = store;
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
	
	@Caption("Rentals")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory")
	public Set<Rental> getRentals()
	{
		return this.rentals;
	}
	
	public void setRentals(Set<Rental> rentals)
	{
		this.rentals = rentals;
	}
	
}
