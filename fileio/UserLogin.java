package fileio;
import java.io.*;
import interfaces.*;
import classes.*;

public class UserLogin implements ILogin{
    private BufferedReader br;
    LoginInfo lI = new LoginInfo();
    private String line = "";
    private Boolean x=false;
    private Boolean y=false;
    private Boolean logKey=false;
   
    
    public void UserLoginCheck(LoginInfo lI){
        try {
            br = new BufferedReader(new FileReader("fileio/SUN.txt"));
            while((line = br.readLine()) != null){
                String[] words = line.split(" ");
                for (String word : words){
                  if (word.equals(lI.ReturnInputUserName())){  
                   x=true;
                  }
                }
                for (String word : words){
                  if (word.equals(lI.ReturnInputPass())){
                   y=true;
                  }
                }    
            }
            br.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
         if(x && y){
            logKey=true;
        }
        
    }
    public void GetKey(Boolean logKey){
        this.logKey=logKey;

    }
    public Boolean ReturnLogKey(){
        return logKey;
    }
}
