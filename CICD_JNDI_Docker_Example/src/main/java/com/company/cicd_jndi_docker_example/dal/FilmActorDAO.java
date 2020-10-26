
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.FilmActor;
import com.company.cicd_jndi_docker_example.domain.FilmActorId;


/**
 * Home object for domain model class FilmActor.
 * 
 * @see FilmActor
 */
public class FilmActorDAO extends JpaDataAccessObject.Default<FilmActor, FilmActorId>
{
	public final static FilmActorDAO INSTANCE = new FilmActorDAO();
	
	public FilmActorDAO()
	{
		super(FilmActor.class);
	}
}
