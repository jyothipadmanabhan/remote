import java.io.*;
import java.net.*;
import java.lang.Runtime;

public class RemoteServer
{ 

	public static void main(String args[])throws IOException

        {

		ServerSocket ss=new ServerSocket(8081);

		Socket s=ss.accept();
	

		BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
	
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
                         
		//cmd=in.readLine();
		
		String cmd[]=new String[3];

		cmd[0]="/bin/sh";
	
		cmd[1]="-c";

		cmd[2]=in.readLine();
 			 
		Runtime r=Runtime.getRuntime();
			 
		Process p=null;

		try

		{   

			p=r.exec(cmd);

			System.out.println("Executing command : "+cmd[2]);
				
			BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
				
			String line;
				
			String k="";
				
			while((line=br.readLine())!=null)
			
			{

				k=k+line+"\n";

			} 

			System.out.println(k);
			
			out.println(k);
		}

		catch(Exception e)

		{ 

			System.out.println("Error"+e);

		}

		s.close();

	} 

}  


