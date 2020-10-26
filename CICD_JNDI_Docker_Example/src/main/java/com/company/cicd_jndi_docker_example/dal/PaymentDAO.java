
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.Payment;


/**
 * Home object for domain model class Payment.
 * 
 * @see Payment
 */
public class PaymentDAO extends JpaDataAccessObject.Default<Payment, Short>
{
	public final static PaymentDAO INSTANCE = new PaymentDAO();
	
	public PaymentDAO()
	{
		super(Payment.class);
	}
}
