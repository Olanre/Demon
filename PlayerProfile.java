package Player;
import Board.*;
/**************************
 * Player Profile
 * Project Demon
 * POTENTIAL SHELL CLASS
 * @author Mark 
 *
 */
public class PlayerProfile 
{
	String fName;
	String lName;
	String username;
	String pass;
	int xCoord;
	int yCoord;
        private final PlayerSprite icon;
	
	public PlayerProfile(String username, String pass, String fname, String lName)
	{
		this.fName = fname;
		this.lName = lName;
		this.username = username;
		this.pass = pass;
		xCoord = 1;                                 //Change this later
		yCoord = 1;		                            //Change this later
                icon = new PlayerSprite( 50, 100, 20, 20);  
	}
	
	public void changeName(String newFName,String newLName)
	{
		fName = newFName;
		lName = newLName;
	}
	
	
	public void changePassword(String newPass)
	{
		pass = newPass;
	}

	public void setXCoord(int newX)
	{
		xCoord = newX;
                icon.move(xCoord, yCoord);
	}
	
	/**
     *
     * @param newY
     */
    public void setYCoord(int newY)
	{
		yCoord = newY;
                icon.move(xCoord, yCoord);
	}
	
	public int getXCoord()
	{
		return xCoord;
	}
	
	public int getYCoord()
	{
		return yCoord;
	}
	
	public  int[] getCoords()
	{
		int[] co = {xCoord,yCoord};
		return co;
	}
	/***
	 * Shell methods
	 */
	 public void money(){}
	 public void happiness(){}
         
         public String getUserName(){
             return username;
         }
	
}
