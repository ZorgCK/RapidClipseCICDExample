
package com.company.cicd_jndi_docker_example.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.company.cicd_jndi_docker_example.domain.Language;


/**
 * Home object for domain model class Language.
 * 
 * @see Language
 */
public class LanguageDAO extends JpaDataAccessObject.Default<Language, Short>
{
	public final static LanguageDAO INSTANCE = new LanguageDAO();
	
	public LanguageDAO()
	{
		super(Language.class);
	}
}
