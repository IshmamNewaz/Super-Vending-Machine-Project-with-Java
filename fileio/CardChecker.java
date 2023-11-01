package fileio;
import java.util.*;
import java.lang.*;
import java.io.*;
import interfaces.*;

public class CardChecker {

	private BufferedReader br;
    private String line = "";
    private Boolean x=false;
    private Boolean logKey=false;
    
    public void userCardCheck(String cardNum){
        try {
            br = new BufferedReader(new FileReader("fileio/TRAN.txt"));
            while((line = br.readLine()) != null){
                String[] words = line.split(" ");
                for (String word : words){
                  if (word.equals(cardNum)){  
                   x=true;
                  }
                } 
            }
            br.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
         if(x){
            logKey=true;
        }
        
    }
    public void GetCardKey(Boolean logKey){
        this.logKey=logKey;

    }
    public Boolean ReturnCardKey(){
        return logKey;
    }



}