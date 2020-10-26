
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.FilmText;


/**
 * Home object for domain model class FilmText.
 * 
 * @see FilmText
 */
public class FilmTextDAO extends JpaDataAccessObject.Default<FilmText, Short>
{
	public final static FilmTextDAO INSTANCE = new FilmTextDAO();
	
	public FilmTextDAO()
	{
		super(FilmText.class);
	}
}
