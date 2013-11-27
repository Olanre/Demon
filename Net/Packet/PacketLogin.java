/*
 * Extract data from a packet ment to log a player in.
 * HOW TO USE THIS CLASS:
 * THIS CLASS CAN BE USED TO INITIALIZE A STRING OF DATA TO BE 
 * PASSED TO THE SERVER. THE CLASS ACCEPTS THE DATA AS A BYTE PARAMETER FOR
 * EASY PASRSING AND ACCESS OR IT CAN ACCEPT DATA TO TRANSFORM INTO 
 * A BYTE STRING TO BE READY TO SEND TO THE SERVER
 */
package Net.Packet;

import Net.GameClient;
import Net.GameServer;

public class PacketLogin extends Packet{
    
    public String userName;
    public int xCoord = 0;
    public int yCoord = 0;
    public String territory;
    
    public PacketLogin(byte[] data)
    {
        
        String[] toRead = this.readData(data);
        this.userName = toRead[1];
        this.xCoord = Integer.parseInt(toRead[2]);
        this.yCoord = Integer.parseInt(toRead[3]);
        this.territory = toRead[4];
    }
    
    //Initiate Packet with these parameters
    public PacketLogin(String username, int xCoord, int yCoord, String territory) 
    {
        this.userName = username;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.territory = territory;
    }
    
    public String getUserName()
    {
        return this.userName;
    }    
    public int getXCoord()
    {
        return this.xCoord;
    }    
    public int getYCoord()
    {
        return this.yCoord;
    }       
    public String getTerritory()
    {
        return this.territory;
    }
    
    //Returns data in the form of bytes
    @Override
    public byte[] getData()
    {
        return this.compileData("1", this.userName, Integer.toString(this.xCoord), Integer.toString(this.yCoord), this.territory);
    }

    //Used in server to send off data to clients
    @Override
    public void writeData(GameServer server) 
    {
        server.sendDataAll(getData());
    }

    //Used by client to send off data to server
    @Override
    public void writeData(GameClient client) 
    {
        client.sendData(getData());
    }
}
