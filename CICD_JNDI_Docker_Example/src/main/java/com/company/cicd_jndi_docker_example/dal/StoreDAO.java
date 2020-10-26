
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.Store;


/**
 * Home object for domain model class Store.
 * 
 * @see Store
 */
public class StoreDAO extends JpaDataAccessObject.Default<Store, Short>
{
	public final static StoreDAO INSTANCE = new StoreDAO();
	
	public StoreDAO()
	{
		super(Store.class);
	}
}
