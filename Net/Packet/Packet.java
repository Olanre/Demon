/*
 * Packet class is used to handle data sent between
 * Client and Server
 */

package Net.Packet;

import Net.GameClient;
import Net.GameServer;

public abstract class Packet 
{
        
    public abstract byte[] getData();
    
    public abstract void writeData(GameServer server);
    
    public abstract void writeData(GameClient client);
    
    //Parse data to prepare it for reading
    public String[] readData(byte[] data)
    {
        String dataString = new String(data);
        //Data is in the form of (DATA1)#(DATA2)#(DATA3)#(DATA4)
        String[] splitData = dataString.trim().split("#");
        return splitData;
    }
    
    //Prepare data in a parseable format by packets
    //GOOD DESIGN INCASE WE EVER WANTED TO CHANGE THE WAY 
    //DATA IS STRUNG TOGETHER TO BE PARSED
    public byte[] compileData(String ...data)
    {
        String toCompile = data[0];
        for(int i = 1; i < data.length; i++)
        {
           toCompile = toCompile + "#"+ data[i]; 
        }
        return toCompile.getBytes();
    }
}
