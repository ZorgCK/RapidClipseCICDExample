
package com.company.cicd_jndi_docker_example.domain;

import com.company.cicd_jndi_docker_example.dal.FilmTextDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * FilmText
 */
@DAO(FilmTextDAO.class)
@Caption("{%title}")
@Entity
@Cacheable(true)
@Table(name = "film_text", catalog = "sakila")
public class FilmText implements java.io.Serializable
{
	
	private short  filmId;
	private String title;
	private String description;
	
	public FilmText()
	{
	}
	
	@Caption("FilmId")
	@Id
	
	@Column(name = "film_id", unique = true, nullable = false, columnDefinition = "SMALLINT")
	public short getFilmId()
	{
		return this.filmId;
	}
	
	public void setFilmId(short filmId)
	{
		this.filmId = filmId;
	}
	
	@Caption("Title")
	@Column(name = "title", nullable = false, columnDefinition = "VARCHAR")
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	@Caption("Description")
	@Column(name = "description", columnDefinition = "TEXT", length = 65535)
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
}
