
package com.company.cicd_jndi_docker_example.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import com.company.cicd_jndi_docker_example.dal.LanguageDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Language
 */
@DAO(LanguageDAO.class)
@Caption("{%name}")
@Entity
@Cacheable(true)
@Table(name = "language", catalog = "sakila")
public class Language implements java.io.Serializable
{
	
	private short     languageId;
	private String    name;
	private Date      lastUpdate;
	private Set<Film> filmsForLanguageId         = new HashSet<Film>(0);
	private Set<Film> filmsForOriginalLanguageId = new HashSet<Film>(0);
	
	public Language()
	{
	}
	
	@Caption("LanguageId")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "language_id", unique = true, nullable = false, columnDefinition = "TINYINT UNSIGNED")
	public short getLanguageId()
	{
		return this.languageId;
	}
	
	public void setLanguageId(short languageId)
	{
		this.languageId = languageId;
	}
	
	@Caption("Name")
	@Column(name = "name", nullable = false, columnDefinition = "CHAR", length = 20)
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Caption("LastUpdate")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP", length = 26)
	public Date getLastUpdate()
	{
		return this.lastUpdate;
	}
	
	public void setLastUpdate(Date lastUpdate)
	{
		this.lastUpdate = lastUpdate;
	}
	
	@Caption("FilmsForLanguageId")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "languageByLanguageId")
	public Set<Film> getFilmsForLanguageId()
	{
		return this.filmsForLanguageId;
	}
	
	public void setFilmsForLanguageId(Set<Film> filmsForLanguageId)
	{
		this.filmsForLanguageId = filmsForLanguageId;
	}
	
	@Caption("FilmsForOriginalLanguageId")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "languageByOriginalLanguageId")
	public Set<Film> getFilmsForOriginalLanguageId()
	{
		return this.filmsForOriginalLanguageId;
	}
	
	public void setFilmsForOriginalLanguageId(Set<Film> filmsForOriginalLanguageId)
	{
		this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
	}
	
}
