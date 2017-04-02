/**
 * 
 * @author Lamha Goel 2015050
 * 
*/

public class Movie extends Media{
	private String director;
	private String producer;
	private char certification;
	public Movie(String title, String artist, int year, String genre, double size, int rating, String duration, String director, String producer, char certification)
	{
		super(title,artist,year,genre,size,rating,duration);
		this.director=director;
		this.producer=producer;
		this.certification=certification;
	}
	public Movie(String... details)
	{
		super(details[0],details[1],Integer.parseInt(details[2]),details[3],Double.parseDouble(details[4]),Integer.parseInt(details[5]),details[6]);
		director=details[7];
		producer=details[8];
		certification=details[9].charAt(0);
	}
	public String getDirector()
	{
		return director;
	}
	public boolean equals(Object o)
	{
		//TODO
		Movie m=(Movie)o;
		if(this.title.equals(m.getTitle()))
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
		/*System.out.println("Movie name: " + title);
		System.out.println("Artist: " + artist);
		System.out.println("Year of Release: " + year);
		System.out.println("Genre: " + genre);
		System.out.println("Size: " + size);
		System.out.println("Rating: " + rating);
		System.out.println("Duration(hrs): " + duration);
		System.out.println("Director: " + director);
		System.out.println("Producer: " + producer);
		System.out.println("Certification: " + certification);
		System.out.println();*/
		System.out.println(this.toString());
	}
	public String toString()
	{
		String s="";
		s+="Movie name: " + title + "\n";
		s+="Artist: " + artist + "\n";
		s+="Year of Release: " + year + "\n";
		s+="Genre: " + genre + "\n";
		s+="Size: " + size + "\n";
		s+="Rating: " + rating + "\n";
		s+="Duration(hrs): " + duration + "\n";
		s+="Director: " + director + "\n";
		s+="Producer: " + producer + "\n";
		s+="Certification: " + certification + "\n";
		return s;
	}
}
