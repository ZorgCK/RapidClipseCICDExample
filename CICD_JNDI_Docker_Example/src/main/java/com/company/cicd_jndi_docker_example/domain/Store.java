
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

import com.company.cicd_jndi_docker_example.dal.StoreDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


/**
 * Store
 */
@DAO(StoreDAO.class)
@Caption("{%storeId}")
@Entity
@Cacheable(true)
@Table(name = "store", catalog = "sakila", uniqueConstraints = @UniqueConstraint(columnNames = "manager_staff_id"))
public class Store implements java.io.Serializable
{
	
	private short          storeId;
	private Address        address;
	private Staff          staff;
	private Date           lastUpdate;
	private Set<Staff>     staffs      = new HashSet<Staff>(0);
	private Set<Inventory> inventories = new HashSet<Inventory>(0);
	private Set<Customer>  customers   = new HashSet<Customer>(0);
	
	public Store()
	{
	}
	
	@Caption("StoreId")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "store_id", unique = true, nullable = false, columnDefinition = "TINYINT UNSIGNED")
	public short getStoreId()
	{
		return this.storeId;
	}
	
	public void setStoreId(short storeId)
	{
		this.storeId = storeId;
	}
	
	@Caption("Address")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Address getAddress()
	{
		return this.address;
	}
	
	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	@Caption("Staff")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_staff_id", unique = true, nullable = false, columnDefinition = "TINYINT UNSIGNED")
	public Staff getStaff()
	{
		return this.staff;
	}
	
	public void setStaff(Staff staff)
	{
		this.staff = staff;
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
	
	@Caption("Staffs")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	public Set<Staff> getStaffs()
	{
		return this.staffs;
	}
	
	public void setStaffs(Set<Staff> staffs)
	{
		this.staffs = staffs;
	}
	
	@Caption("Inventories")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	public Set<Inventory> getInventories()
	{
		return this.inventories;
	}
	
	public void setInventories(Set<Inventory> inventories)
	{
		this.inventories = inventories;
	}
	
	@Caption("Customers")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	public Set<Customer> getCustomers()
	{
		return this.customers;
	}
	
	public void setCustomers(Set<Customer> customers)
	{
		this.customers = customers;
	}
	
}
