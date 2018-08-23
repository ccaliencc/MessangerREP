package arek.nauka.messenger.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name="Message")
public class Message
{
	@Id 
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="message")
	private String message;
	@Column(name="created")
	private Date created;
	@Column(name="author")
	private String author;

	public Message()
	{

	}

	public Message(long id, String message, String author)
	{
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(Date created)
	{
		this.created = created;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

}
