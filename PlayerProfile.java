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
	int[] cor = {0,0};
	private final PlayerSprite icon;
	
	public PlayerProfile(String fname,String lName,String username,String pass)
	{
		this.fName = fname;       //first name
		this.lName = lName;       //last name
		this.username = username; //username
		this.pass = pass;         //password
		icon = new PlayerSprite( 50, 100, 20, 20);
	}
	
	public void changeName(String newFName,String newLName)
	{
		fName = newFName;
		lName = newLName;
	}
	
	public void changeUsername(String newUsername)
	{
		username = newUsername;
	}
	
	
	public void changePassword(String newPass)
	{
		pass = newPass;
	}

	public void setXCoord(int newX)
	{
		xCoord = newX;
		cor[0] = newX;
	}
	
	public void setYCoord(int newY)
	{
		yCoord = newY;
		cor[1] = newY;
	}
	
	public int getXCoord()
	{
		return cor[0];
	}
	
	public int getYCoord()
	{
		return yCoord;
	}
	
	public void  setCoords(int x, int y)       //sets both coordinates at the same time
	{
		xCoord = x;
		cor[0] = xCoord;
		yCoord = y;
		cor[1] = yCoord;
	}
	
	public  int[] getCoords()
	{
		return cor;
	}
	
	/***
	 * Shell methods
	 */
	 public void money(){}
	 public void happiness(){}
}
