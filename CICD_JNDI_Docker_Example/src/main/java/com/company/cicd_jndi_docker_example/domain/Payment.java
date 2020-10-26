
package com.company.cicd_jndi_docker_example.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import com.company.cicd_jndi_docker_example.dal.PaymentDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Payment
 */
@DAO(PaymentDAO.class)
@Caption("{%paymentId}")
@Entity
@Cacheable(true)
@Table(name = "payment", catalog = "sakila")
public class Payment implements java.io.Serializable
{
	
	private Short      paymentId;
	private Customer   customer;
	private Rental     rental;
	private Staff      staff;
	private BigDecimal amount;
	private Date       paymentDate;
	private Date       lastUpdate;
	
	public Payment()
	{
	}
	
	@Caption("PaymentId")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "payment_id", unique = true, nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Short getPaymentId()
	{
		return this.paymentId;
	}
	
	public void setPaymentId(Short paymentId)
	{
		this.paymentId = paymentId;
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
	
	@Caption("Rental")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rental_id", columnDefinition = "INT")
	public Rental getRental()
	{
		return this.rental;
	}
	
	public void setRental(Rental rental)
	{
		this.rental = rental;
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
	
	@Caption("Amount")
	@Column(name = "amount", nullable = false, columnDefinition = "DECIMAL", precision = 5)
	public BigDecimal getAmount()
	{
		return this.amount;
	}
	
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}
	
	@Caption("PaymentDate")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_date", nullable = false, columnDefinition = "DATETIME", length = 26)
	public Date getPaymentDate()
	{
		return this.paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate)
	{
		this.paymentDate = paymentDate;
	}
	
	@Caption("LastUpdate")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", columnDefinition = "TIMESTAMP", length = 26)
	public Date getLastUpdate()
	{
		return this.lastUpdate;
	}
	
	public void setLastUpdate(Date lastUpdate)
	{
		this.lastUpdate = lastUpdate;
	}
	
}
