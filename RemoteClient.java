import java.io.*;
import java.net.*;
public class RemoteClient
{ 
	public static void main(String args[])throws IOException
	{ 
		try
		{ 

			Socket s=new Socket("localhost",8081);
		
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);

			String cmd;

			DataInputStream in=new DataInputStream(System.in);
				
			BufferedReader inp=new BufferedReader(new InputStreamReader(s.getInputStream()));

			System.out.println("Enter the command to execute on server : ");

			cmd=in.readLine();

			out.println(cmd);
			
			String str;

			while((str=inp.readLine())!=null)
			{

				System.out.println(str);

			} 

		}
		
		catch(Exception e)
		{ 	

			System.out.println(e);
		}
	
	} 

}   


