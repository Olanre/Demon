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
	int xCoord = 100;
	int yCoord = 376;
        int[] co = {xCoord,yCoord};
        public final PlayerSprite icon;
	
	public PlayerProfile(String username, String pass, String fname, String lName)
	{
		this.fName = fname;
		this.lName = lName;
		this.username = username;
		this.pass = pass;		                            
                icon = new PlayerSprite( xCoord, yCoord, 20, 20);  
                
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
		co[0] = xCoord = newX;
                icon.move(xCoord, yCoord);
	}
	
	/**
     *
     * @param newY
     */
    public void setYCoord(int newY)
	{
		co[1] = yCoord = newY;
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
