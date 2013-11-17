public class MovementController 
{
	int newXCoord;
	int newYCoord; 
	PlayerProfile player;
	
    public MovementController()
    {
    	//this.player = player;
    	//newXCoord = xcoord;
    	//newYCoord = ycoord;
    }
    
    
    public void checkIfValid()
    {
    	//TODO
    	//check board to see if move is valid
    	//POSSIBLITY: wrap the board(i.e from max size back to 0 and vice versa)
    	//Possible: Maybe let this class accept some parameters to 
    	
    }
    
    public void move(PlayerProfile player,Direction d)
    {
    	switch(d)
    	{
    	    case RIGHT:
    		   player.setXCoord(player.getXCoord() + 5);
    	    case LEFT:
    	       player.setXCoord(player.getXCoord() - 5);
    	       //board.redraw
    	    case UP:
    	    	player.setYCoord(player.getYCoord() + 5);
    	    	//board.redraw
    	    case DOWN:	
    	    	player.setYCoord(player.getYCoord() - 5);
    	    	//board.redraw
    	}
    }
    
    public void moveRight()
    { 
    	//if(player.getXCoord() + 1 >= getHeight())
    	//{
    	   player.setXCoord(0);
    	//}   
    	
    	//board.redraw
    }
    
    public void moveLeft()
    { 
    	
    }
    
    public void moveUp()
    { 
    	player.setYCoord(player.getYCoord() + 5);
    	//board.redraw
    }
    
    public void moveDown()
    { 
    	player.setYCoord(player.getYCoord() - 5);
    	//board.redraw
    }
   
}
