
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.Address;


/**
 * Home object for domain model class Address.
 * 
 * @see Address
 */
public class AddressDAO extends JpaDataAccessObject.Default<Address, Short>
{
	public final static AddressDAO INSTANCE = new AddressDAO();
	
	public AddressDAO()
	{
		super(Address.class);
	}
}
