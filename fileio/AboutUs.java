package fileio;
import java.io.*;
public class AboutUs{
	public void aboutUsMethod(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("fileio/output.txt"));
			String s;
			while((s = br.readLine()) !=null){
				System.out.println(s);
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}