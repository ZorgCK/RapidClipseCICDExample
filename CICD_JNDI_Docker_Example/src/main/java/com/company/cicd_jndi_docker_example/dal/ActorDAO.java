
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.Actor;


/**
 * Home object for domain model class Actor.
 * 
 * @see Actor
 */
public class ActorDAO extends JpaDataAccessObject.Default<Actor, Short>
{
	public final static ActorDAO INSTANCE = new ActorDAO();
	
	public ActorDAO()
	{
		super(Actor.class);
	}
}
