/**
 * 
 * @author Lamha Goel 2015050
 * 
*/

import java.io.*;

public class DecryptInputStream extends FilterInputStream {
	public DecryptInputStream(InputStream o)
	{
		super(o);
	}
	public int read() throws IOException
	{
		int x;
		x=in.read();
		if(x==-1)
		{
			return -1;
		}
		if(x==0)
		{
			return 255;
		}
		else
		{
			return --x;
		}
	}
	public int read(byte[] b) throws IOException
	{
		return read(b,0,b.length);
	}
	public int read(byte[] b, int off, int len) throws IOException
	{
		len+=off;
		int temp;
		for(int i=off;i<len;i++)
		{
			temp=read();
			if(temp==-1)
			{
				return -1;
			}
			else
			{
				b[i]=(byte)temp;
			}
		}
		return len;
	}
}
