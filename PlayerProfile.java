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
	
	public PlayerProfile(String fname,String lName,String username,String pass)
	{
		this.fName = fname;
		this.lName = lName;
		this.username = username;
		this.pass = pass;
		xCoord = 1;                                 //Change this later
		yCoord = 1;		                            //Change this later
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
	}
	
	public void setYCoord(int newY)
	{
		yCoord = newY;
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
	
}
