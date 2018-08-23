package arek.nauka.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean
{
	private @QueryParam("year")int year;
	private @QueryParam("start")int start;
	private @QueryParam("size")int size;
	// jeżeli jest zapytanie w przeglądarce messages?year=2018 na przykład
	//to Jersey wie, że ma połączyć przez year z inną metodą a nie getallmessages
	// w przypadku zapytania messages?start=2&size=1 wywołaj inną metode w service
	
	public int getYear()
	{
		return year;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public int getStart()
	{
		return start;
	}
	public void setStart(int start)
	{
		this.start = start;
	}
	public int getSize()
	{
		return size;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	
	

}
