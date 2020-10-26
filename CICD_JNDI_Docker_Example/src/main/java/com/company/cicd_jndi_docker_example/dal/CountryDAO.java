
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.Country;


/**
 * Home object for domain model class Country.
 * 
 * @see Country
 */
public class CountryDAO extends JpaDataAccessObject.Default<Country, Short>
{
	public final static CountryDAO INSTANCE = new CountryDAO();
	
	public CountryDAO()
	{
		super(Country.class);
	}
}
