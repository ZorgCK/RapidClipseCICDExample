
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.Staff;


/**
 * Home object for domain model class Staff.
 * 
 * @see Staff
 */
public class StaffDAO extends JpaDataAccessObject.Default<Staff, Short>
{
	public final static StaffDAO INSTANCE = new StaffDAO();
	
	public StaffDAO()
	{
		super(Staff.class);
	}
}
