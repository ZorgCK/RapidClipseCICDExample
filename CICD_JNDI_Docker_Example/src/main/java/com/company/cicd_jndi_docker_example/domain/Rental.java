
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

import com.company.cicd_jndi_docker_example.dal.RentalDAO;
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
 * Rental
 */
@DAO(RentalDAO.class)
@Caption("{%rentalId}")
@Entity
@Cacheable(true)
@Table(name = "rental", catalog = "sakila", uniqueConstraints = @UniqueConstraint(columnNames = {"rental_date",
	"inventory_id", "customer_id"}))
public class Rental implements java.io.Serializable
{
	
	private int          rentalId;
	private Customer     customer;
	private Inventory    inventory;
	private Staff        staff;
	private Date         rentalDate;
	private Date         returnDate;
	private Date         lastUpdate;
	private Set<Payment> payments = new HashSet<Payment>(0);
	
	public Rental()
	{
	}
	
	@Caption("RentalId")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "rental_id", unique = true, nullable = false, columnDefinition = "INT")
	public int getRentalId()
	{
		return this.rentalId;
	}
	
	public void setRentalId(int rentalId)
	{
		this.rentalId = rentalId;
	}
	
	@Caption("Customer")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Customer getCustomer()
	{
		return this.customer;
	}
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	@Caption("Inventory")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inventory_id", nullable = false, columnDefinition = "MEDIUMINT UNSIGNED")
	public Inventory getInventory()
	{
		return this.inventory;
	}
	
	public void setInventory(Inventory inventory)
	{
		this.inventory = inventory;
	}
	
	@Caption("Staff")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "staff_id", nullable = false, columnDefinition = "TINYINT UNSIGNED")
	public Staff getStaff()
	{
		return this.staff;
	}
	
	public void setStaff(Staff staff)
	{
		this.staff = staff;
	}
	
	@Caption("RentalDate")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rental_date", nullable = false, columnDefinition = "DATETIME", length = 26)
	public Date getRentalDate()
	{
		return this.rentalDate;
	}
	
	public void setRentalDate(Date rentalDate)
	{
		this.rentalDate = rentalDate;
	}
	
	@Caption("ReturnDate")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "return_date", columnDefinition = "DATETIME", length = 26)
	public Date getReturnDate()
	{
		return this.returnDate;
	}
	
	public void setReturnDate(Date returnDate)
	{
		this.returnDate = returnDate;
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
	
	@Caption("Payments")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rental")
	public Set<Payment> getPayments()
	{
		return this.payments;
	}
	
	public void setPayments(Set<Payment> payments)
	{
		this.payments = payments;
	}
	
}
