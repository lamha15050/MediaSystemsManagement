/**
 * 
 * @author Lamha Goel 2015050
 * 
*/

import java.io.*;

public class EncryptOutputStream extends FilterOutputStream {
	public EncryptOutputStream(OutputStream o)
	{
		super(o);
	}
	public void write(int b) throws IOException
	{
		b++;	//Increment b by 1 to encrypt
		out.write(b);
	}
	public void write(byte[] b) throws IOException
	{
		write(b,0,b.length);
	}
	public void write(byte[] b,int off,int len) throws IOException
	{
		len+=off;
		int i;
		for(i=off;i<len;i++)
		{
			write(b[i]);
		}
	}
}
