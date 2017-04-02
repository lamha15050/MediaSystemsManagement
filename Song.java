/**
 * 
 * @author Lamha Goel 2015050
 * 
*/

public class Song extends Media{
	private String movie;
	public Song(String title, String artist, int year, String genre, double size, int rating, String duration, String movie)
	{
		super(title,artist,year,genre,size,rating,duration);
		this.movie=movie;
	}
	public Song(String... details)
	{
		super(details[0],details[2],Integer.parseInt(details[3]),details[4],Double.parseDouble(details[5]),Integer.parseInt(details[6]),details[7]);
		movie=details[1];
	}
	public String getMovie()
	{
		return movie;
	}
	public boolean equals(Object o)
	{
		//TODO
		Song s=(Song)o;
		if(this.title.equals(s.getTitle()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	public void print()
	{
		/*System.out.println("Song Title: " + title);
		System.out.println("Movie: " + movie);
		System.out.println("Artist: " + artist);
		System.out.println("Year of Release: " + year);
		System.out.println("Genre: " + genre);
		System.out.println("Size: " + size);
		System.out.println("Rating: " + rating);
		System.out.println("Duration(mins): " + duration);
		System.out.println();*/
		System.out.println(this.toString());
	}
	public String toString()
	{
		String s="";
		s+="Song Title: " + title + "\n";
		s+="Movie: " + movie + "\n";
		s+="Artist: " + artist + "\n";
		s+="Year of Release: " + year + "\n";
		s+="Genre: " + genre + "\n";
		s+="Size: " + size + "\n";
		s+="Rating: " + rating + "\n";
		s+="Duration(mins): " + duration + "\n";
		return s;
	}
}
