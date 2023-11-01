package  classes;
import java.lang.*;

public class LoginInfo
{
	private String inputSearch;
    private String inputSearch2;
	
	public void GetinputUserName(String inputSearch){
        this.inputSearch=inputSearch;
    }
    public String ReturnInputUserName(){
        return inputSearch;
    }
    public void GetinputPass(String inputSearch2){
        this.inputSearch2=inputSearch2;
    }
    public String ReturnInputPass(){
        return inputSearch2;
    }
    
}