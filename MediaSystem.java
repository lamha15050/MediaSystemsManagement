/**
 * 
 * @author Lamha Goel 2015050
 * 
*/

import java.util.*;
import java.io.*;

public class MediaSystem {
	private List<Movie> movies=new ArrayList<Movie>();
	private List<Song> songs=new ArrayList<Song>();
	private int numOfSongs=0;
	private int numOfMovies=0;
	private Map<String,ArrayList<Song>> songsByGenre= new HashMap<String,ArrayList<Song>>();
	private Map<String,ArrayList<Song>> songsByMovie= new HashMap<String,ArrayList<Song>>();
	private Map<String,ArrayList<Movie>> moviesByDirector= new HashMap<String,ArrayList<Movie>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MediaSystem mediaSystem1=new MediaSystem();
		mediaSystem1.initialise();
		mediaSystem1.serialize();	//Initialize the .dat files
		Scanner input=new Scanner(System.in);
		while(true)
		{
			mediaSystem1.printMenu();
			int ch;
			ch=input.nextInt();
			switch(ch)
			{
			case 1: mediaSystem1.serialize();
					break;
			case 2: mediaSystem1.deserialize();
					break;
			case 3:mediaSystem1.listAllMovies();
					break;
			case 4:mediaSystem1.listAllSongs();
					break;
			case 5:mediaSystem1.topKMovies();
					break;
			case 6:mediaSystem1.topKSongs();
					break;
			case 7:mediaSystem1.displaySongsByGenre();
					break;
			case 8:mediaSystem1.displayMoviesByDirector();
					break;
			case 9:mediaSystem1.editRatingSong();	//Should also call serialise to update changes
					break;
			case 10:mediaSystem1.editRatingMovie();	//Should also call serialise to update changes
					break;
			case 11:mediaSystem1.displayCounts();
					break;
			case 12:mediaSystem1.displaySongsByMovie();
					break;
			case 13:input.close();
					System.exit(0);
					break;
			default:System.out.println("Wrong input, Enter again");
					break;
			}
		}
	}
	
	public void serialize()
	{
		serializeMovies();
		serializeSongs();
	}
	private void serializeMovies()
	{
		FileOutputStream out=null;
		EncryptOutputStream encOut=null;
		ObjectOutputStream objOut=null;
		try
		{
			out=new FileOutputStream("movies.dat");
			encOut=new EncryptOutputStream(out);
			objOut=new ObjectOutputStream(encOut);
			for(Movie m:movies)
			{
				objOut.writeObject(m);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				objOut.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				encOut.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				out.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
	private void serializeSongs()
	{
		FileOutputStream out=null;
		EncryptOutputStream encOut=null;
		ObjectOutputStream objOut=null;
		try
		{
			out=new FileOutputStream("songs.dat");
			encOut=new EncryptOutputStream(out);
			objOut=new ObjectOutputStream(encOut);
			for(Song s:songs)
			{
				objOut.writeObject(s);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				objOut.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				encOut.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				out.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
	public void displaySongsByMovie()
	{
		Scanner input=new Scanner(System.in);
		String m=input.nextLine();
		/*for(Song s:songs)
		{
			if(s.getMovie().equals(m))
			{
				s.print();
			}
		}*/
		ArrayList<Song> temp = songsByMovie.get(m);
		if(temp!=null && temp.size()>0)
		{
			for(Song s : temp)
			{
				System.out.println(s);
			}
		}
		else
		{
			System.out.println("No song of this movie");
		}
	}
	public void displayCounts()
	{
		System.out.println("Number of songs in the library: " + numOfSongs);
		System.out.println("Number of movies in the library: " + numOfMovies);
	}
	public void editRatingMovie()
	{
		Scanner input=new Scanner(System.in);
		int r;
		String s;
		System.out.println("Enter movie name:");
		s=input.nextLine();
		Movie temp=new Movie(s,"",0,"",0.0,0,"","","",'A');
		int index=movies.indexOf(temp);
		if(index!=-1)
		{
			System.out.println("Enter rating");
			r=input.nextInt();
			movies.get(index).setRating(r);
			serialize();
		}
		else
		{
			System.out.println("Movie not found");
		}
	}	
	public void editRatingSong()
	{
		Scanner input=new Scanner(System.in);
		int r;
		String s;
		System.out.println("Enter song name:");
		s=input.nextLine();
		Song temp=new Song(s,"",0,"",0.0,0,"","");
		int index=songs.indexOf(temp);
		if(index!=-1)
		{
			System.out.println("Enter rating");
			r=input.nextInt();
			songs.get(index).setRating(r);
			serialize();
		}
		else
		{
			System.out.println("Song not found");
		}
	}
	public void displayMoviesByDirector()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter name of director:");
		String d=input.nextLine();
		/*for(Movie m:movies)
		{
			if(m.getDirector().equals(d))
			{
				m.print();
			}
		}*/
		ArrayList<Movie> temp=moviesByDirector.get(d);
		if(temp!=null && temp.size()>0)
		{
			for(Movie m : temp)
			{
				System.out.println(m);
			}
		}
		else
		{
			System.out.println("No movie by this director");
		}
	}
	public void displaySongsByGenre()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter genre:");
		String g=input.nextLine();
		/*for(Song s:songs)
		{
			if(s.getGenre().equals(g))
			{
				s.print();
			}
		}*/
		ArrayList<Song> temp=songsByGenre.get(g);
		if(temp!=null && temp.size()>0)
		{
			for(Song s: temp)
			{
				System.out.println(s);
			}
		}
		else
		{
			System.out.println("No song for this genre");
		}
	}
	public void topKMovies()
	{
		ArrayList<Movie> m=new ArrayList<Movie>(movies);
		Collections.sort(m);
		Scanner input=new Scanner(System.in);
		System.out.println("Enter k");
		int k=input.nextInt();
		if(k>m.size())
		{
			k=m.size();
			System.out.println("k is greater than number of movies in database, displaying all movies in descending order of rating");
		}
		System.out.println("Movie\tRating");
		for(int i=0;i<k;i++)
		{
			System.out.println(m.get(i).getTitle() + "\t" + m.get(i).getRating());
		}
	}
	public void topKSongs()
	{
		ArrayList<Song> s=new ArrayList<Song>(songs);
		Collections.sort(s);
		Scanner input=new Scanner(System.in);
		System.out.println("Enter k");
		int k=input.nextInt();
		if(k>s.size())
		{
			k=s.size();
			System.out.println("k is greater than number of songs in database, displaying all songs in descending order of rating");
		}
		System.out.println("Song\tRating");
		for(int i=0;i<k;i++)
		{
			System.out.println(s.get(i).getTitle() + "\t" + s.get(i).getRating());
		}
	}
	public void deserialize()
	{
		songsByGenre= new HashMap<String,ArrayList<Song>>();
		songsByMovie= new HashMap<String,ArrayList<Song>>();
		moviesByDirector= new HashMap<String,ArrayList<Movie>>();
		songs=new ArrayList<Song>();
		movies=new ArrayList<Movie>();
		numOfSongs=0;
		numOfMovies=0;
		deserializeMovies();
		deserializeSongs();
	}
	public void listAllSongs()
	{
		System.out.println("Songs:");
		System.out.println();
		for(Song s:songs)
		{
			System.out.println(s);
		}
		System.out.println();
	}
	public void listAllMovies()
	{
		System.out.println("Movies:");
		System.out.println();
		for(Movie m:movies)
		{
			System.out.println(m);
		}
		System.out.println();
	}
	public void printMenu()
	{
		System.out.println();
		System.out.println("1.Serialize");
		System.out.println("2.Deserialize");
		System.out.println("3.View information of all the movies in the library.");
		System.out.println("4.View information of all the songs in the library.");
		System.out.println("5.List top K movies");
		System.out.println("6.List top K songs");
		System.out.println("7.Display songs by Genre");
		System.out.println("8.Display movies by Director");
		System.out.println("9.Edit rating for a song");
		System.out.println("10.Edit rating for a movie");
		System.out.println("11.Display counts of movies and songs in database");
		System.out.println("12.Display all songs of a movie");
		System.out.println("13. Exit");
		System.out.println();
		
	}
	public void initialise()
	{
		File file=new File("movies.dat");
		if(file.exists() && file.isFile())
		{
			deserializeMovies();
		}
		else
		{
			readMoviesFromtxt();
		}
		file=new File("songs.dat");
		if(file.exists() && file.isFile())
		{
			deserializeSongs();
		}
		else
		{
			readSongsFromtxt();
		}
	}
	private void deserializeMovies()
	{
		FileInputStream in=null;
		DecryptInputStream decIn=null;
		ObjectInputStream objIn=null;
		try
		{
			in = new FileInputStream("movies.dat");
			decIn = new DecryptInputStream(in); 
			objIn=new ObjectInputStream(decIn);
			Object o = objIn.readObject();
			Movie temp;
			while(o!=null)
			{
				temp=(Movie)o;
				movies.add(temp);
				numOfMovies++;
				if(moviesByDirector.containsKey(temp.getDirector()))
				{
					moviesByDirector.get(temp.getDirector()).add(temp);
				}
				else
				{
					moviesByDirector.put(temp.getDirector(), new ArrayList<Movie>());
					moviesByDirector.get(temp.getDirector()).add(temp);
				}
				o=objIn.readObject();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				objIn.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				decIn.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				in.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
	private void deserializeSongs()
	{
		FileInputStream in=null;
		DecryptInputStream decIn=null;
		ObjectInputStream objIn=null;
		try
		{
			in = new FileInputStream("songs.dat");
			decIn=new DecryptInputStream(in);
			objIn=new ObjectInputStream(decIn);
			Object o = objIn.readObject();
			Song temp;
			while(o!=null)
			{
				temp=(Song)o;
				songs.add((Song)o);
				numOfSongs++;
				if(songsByGenre.containsKey(temp.getGenre()))
				{
					songsByGenre.get(temp.getGenre()).add(temp);
				}
				else
				{
					songsByGenre.put(temp.getGenre(), new ArrayList<Song>());
					songsByGenre.get(temp.getGenre()).add(temp);
				}
				if(songsByMovie.containsKey(temp.getMovie()))
				{
					songsByMovie.get(temp.getMovie()).add(temp);
				}
				else
				{
					songsByMovie.put(temp.getMovie(), new ArrayList<Song>());
					songsByMovie.get(temp.getMovie()).add(temp);
				}
				o=objIn.readObject();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				objIn.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				decIn.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				in.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
	private void readSongsFromtxt()
	{
		FileInputStream in = null;
		InputStreamReader input = null;
		BufferedReader reader= null;
		try
		{
			in = new FileInputStream("song.txt");
			input = new InputStreamReader(in);
			reader = new BufferedReader(input);
			Song temp=null;
			String songinfo;
			songinfo=reader.readLine();
			songinfo=reader.readLine();
			while(songinfo!=null)
			{
				temp=new Song(songinfo.split(","));
				songs.add(temp);
				numOfSongs++;
				if(songsByGenre.containsKey(temp.getGenre()))
				{
					songsByGenre.get(temp.getGenre()).add(temp);
				}
				else
				{
					songsByGenre.put(temp.getGenre(), new ArrayList<Song>());
					songsByGenre.get(temp.getGenre()).add(temp);
				}
				if(songsByMovie.containsKey(temp.getMovie()))
				{
					songsByMovie.get(temp.getMovie()).add(temp);
				}
				else
				{
					songsByMovie.put(temp.getMovie(), new ArrayList<Song>());
					songsByMovie.get(temp.getMovie()).add(temp);
				}
				songinfo=reader.readLine();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				reader.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				input.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				in.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
	private void readMoviesFromtxt()
	{
		FileInputStream in = null;
		InputStreamReader input = null;
		BufferedReader reader= null;
		try
		{
			in = new FileInputStream("movie.txt");
			input = new InputStreamReader(in);
			reader = new BufferedReader(input);
			Movie temp=null;
			String movieinfo;
			movieinfo=reader.readLine();
			movieinfo=reader.readLine();
			while(movieinfo!=null)
			{
				temp=new Movie(movieinfo.split(","));
				movies.add(temp);
				numOfMovies++;
				if(moviesByDirector.containsKey(temp.getDirector()))
				{
					moviesByDirector.get(temp.getDirector()).add(temp);
				}
				else
				{
					moviesByDirector.put(temp.getDirector(), new ArrayList<Movie>());
					moviesByDirector.get(temp.getDirector()).add(temp);
				}
				movieinfo=reader.readLine();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				reader.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				input.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				in.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
}

