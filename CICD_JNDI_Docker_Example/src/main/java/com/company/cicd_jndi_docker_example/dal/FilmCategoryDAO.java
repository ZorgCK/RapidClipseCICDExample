
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.FilmCategoryId;
import com.company.cicd_jndi_docker_example.domain.FilmCategory;


/**
 * Home object for domain model class FilmCategory.
 * 
 * @see FilmCategory
 */
public class FilmCategoryDAO extends JpaDataAccessObject.Default<FilmCategory, FilmCategoryId>
{
	public final static FilmCategoryDAO INSTANCE = new FilmCategoryDAO();
	
	public FilmCategoryDAO()
	{
		super(FilmCategory.class);
	}
}
