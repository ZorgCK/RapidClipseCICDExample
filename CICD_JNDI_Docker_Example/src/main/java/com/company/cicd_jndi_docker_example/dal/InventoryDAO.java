
package com.company.cicd_jndi_docker_example.dal;

import com.company.cicd_jndi_docker_example.domain.Inventory;
import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;


/**
 * Home object for domain model class Inventory.
 * 
 * @see Inventory
 */
public class InventoryDAO extends JpaDataAccessObject.Default<Inventory, Integer>
{
	public final static InventoryDAO INSTANCE = new InventoryDAO();
	
	public InventoryDAO()
	{
		super(Inventory.class);
	}
}
