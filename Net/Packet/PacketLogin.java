/*
 * Extract data from a packet ment to log a player in
 */
package Net.Packet;

import Net.GameClient;
import Net.GameServer;

public class PacketLogin extends Packet{
    
    public String userName;
    public int xCoord;
    public int yCoord;
    public String territory;
    
    public PacketLogin(byte[] data){
        String[] toRead = this.readData(data);
        this.userName = toRead[1];
        this.xCoord = Integer.getInteger(toRead[2]);
        this.yCoord = Integer.getInteger(toRead[3]);
        this.territory = toRead[4];
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
    
    public byte[] getData(){
        return this.compileData("1", this.userName, Integer.toString(this.xCoord), Integer.toString(this.yCoord), this.territory);
    }

    @Override
    public void writeData(GameServer server) {
        server.sendDataAll(getData());
    }

    @Override
    public void writeData(GameClient client) {
        client.sendData(getData());
    }
}
