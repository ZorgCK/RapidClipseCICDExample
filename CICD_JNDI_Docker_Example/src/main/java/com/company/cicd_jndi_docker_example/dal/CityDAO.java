
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.City;


/**
 * Home object for domain model class City.
 * 
 * @see City
 */
public class CityDAO extends JpaDataAccessObject.Default<City, Short>
{
	public final static CityDAO INSTANCE = new CityDAO();
	
	public CityDAO()
	{
		super(City.class);
	}
}
