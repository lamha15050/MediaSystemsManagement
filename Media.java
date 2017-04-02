/**
 * 
 * @author Lamha Goel 2015050
 * 
*/

import java.io.*;

public abstract class Media implements Comparable<Media>,Serializable{
	protected String title;
	protected String artist;
	protected int year;
	protected String genre;
	protected double size;
	protected int rating;
	protected String duration;
	
	public Media(String title, String artist, int year, String genre, double size, int rating, String duration)
	{
		this.title=title;		//Assumed to be unique
		this.artist=artist;
		this.year=year;
		this.genre=genre;
		this.size=size;
		if(rating>=1 && rating<=5)
		{
			this.rating=rating;
		}
		else
		{
			this.rating=1;
		}
		this.duration=duration;
	}
	
	public void setRating(int r)
	{
		if(r>=1 && r<=5)
		{
			System.out.println("Rating of " + title + " updated from " + rating + " to " + r);
			rating=r;
		}
		else
		{
			System.out.println("New rating out of range, rating left unchanged");
		}
	}
	public String getGenre()
	{
		return genre;
	}
	public String getTitle()
	{
		return title;
	}
	public int getRating()
	{
		return rating;
	}
	public int compareTo(Media m)
	{
		int r=m.getRating();
		//return positive if rating<r, negative if rating>r, and 0 if rating=r to sort in descending order
		return r-rating;
	}
}