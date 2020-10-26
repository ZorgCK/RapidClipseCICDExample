
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.Rental;


/**
 * Home object for domain model class Rental.
 * 
 * @see Rental
 */
public class RentalDAO extends JpaDataAccessObject.Default<Rental, Integer>
{
	public final static RentalDAO INSTANCE = new RentalDAO();
	
	public RentalDAO()
	{
		super(Rental.class);
	}
}
