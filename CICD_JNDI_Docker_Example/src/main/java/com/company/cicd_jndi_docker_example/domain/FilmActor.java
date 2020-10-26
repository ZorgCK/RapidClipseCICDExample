
package com.company.cicd_jndi_docker_example.domain;

import com.company.cicd_jndi_docker_example.dal.FilmActorDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * FilmActor
 */
@DAO(FilmActorDAO.class)
@Caption("{%id}")
@Entity
@Cacheable(true)
@Table(name = "film_actor", catalog = "sakila")
public class FilmActor implements java.io.Serializable
{
	
	private FilmActorId id;
	private Actor       actor;
	private Film        film;
	private Date        lastUpdate;
	
	public FilmActor()
	{
	}
	
	@Caption("Id")
	@EmbeddedId
	
	@AttributeOverrides({
		@AttributeOverride(name = "actorId", column = @Column(name = "actor_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")),
		@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED"))})
	public FilmActorId getId()
	{
		return this.id;
	}
	
	public void setId(FilmActorId id)
	{
		this.id = id;
	}
	
	@Caption("Actor")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "actor_id", nullable = false, insertable = false, updatable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Actor getActor()
	{
		return this.actor;
	}
	
	public void setActor(Actor actor)
	{
		this.actor = actor;
	}
	
	@Caption("Film")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Film getFilm()
	{
		return this.film;
	}
	
	public void setFilm(Film film)
	{
		this.film = film;
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
	
}
