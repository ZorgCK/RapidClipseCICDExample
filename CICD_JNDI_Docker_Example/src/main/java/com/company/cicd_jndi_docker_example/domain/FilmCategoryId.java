
package com.company.cicd_jndi_docker_example.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * FilmCategoryId
 */
@Embeddable
public class FilmCategoryId implements java.io.Serializable
{
	
	private short filmId;
	private short categoryId;
	
	public FilmCategoryId()
	{
	}
	
	@Column(name = "film_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	public short getFilmId()
	{
		return this.filmId;
	}
	
	public void setFilmId(short filmId)
	{
		this.filmId = filmId;
	}
	
	@Column(name = "category_id", nullable = false, columnDefinition = "TINYINT UNSIGNED")
	public short getCategoryId()
	{
		return this.categoryId;
	}
	
	public void setCategoryId(short categoryId)
	{
		this.categoryId = categoryId;
	}
	
	public boolean equals(Object other)
	{
		if((this == other))
			return true;
		if((other == null))
			return false;
		if(!(other instanceof FilmCategoryId))
			return false;
		FilmCategoryId castOther = (FilmCategoryId)other;
		
		return (this.getFilmId() == castOther.getFilmId())
			&& (this.getCategoryId() == castOther.getCategoryId());
	}
	
	public int hashCode()
	{
		int result = 17;
		
		result = 37 * result + this.getFilmId();
		result = 37 * result + this.getCategoryId();
		return result;
	}
	
}
