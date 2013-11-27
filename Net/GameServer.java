/*
 * Server class is used to handle all connected
 * clients
 */
package Net;

import Game.GameMain;
import Net.Packet.Packet;
import Net.Packet.PacketLogin;
import Player.PlayerProfile;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameServer extends Thread 
{

    public GameMain mainGame;//Incase we need the game class and it seems we do
    public ArrayList<PlayerProfile> connected = new ArrayList<>();
    public DatagramSocket socket;
    
    public GameServer(GameMain mainGame) 
    {
        this.mainGame = mainGame;

        try{
            this.socket = new DatagramSocket(1331);            
        } 
        catch (SocketException e) 
        {
            System.out.println("Server has been started");
            this.stop();
        }
    }

    @Override
    public void run() 
    {
        //recieves information from client
        while (true) 
        {
            byte[] data = new byte[2048];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            
            try 
            {
                socket.receive(packet);
            } 
            catch (IOException e) 
            {
                e.printStackTrace(); 
            }
            System.out.println("SERVER HAS RECIEVED MESSAGE FROM " + (new String(packet.getData())));
            //Sends data to method to be parse and interpreted 
            this.parseData(packet.getData(), packet.getAddress(), packet.getPort());
        }
    }
    
    //Interprets data from client
    public void parseData(byte[] data, InetAddress ipAddress, int port)
    {
        //extracts packet type
        String type = new String(data).trim().substring(0,1);
        Packet rPacket;
        switch(type){
            case "1":
                PacketLogin logged;
                for(PlayerProfile i: connected )
                {
                    logged = new PacketLogin(i.username,i.getXCoord(),i.getYCoord(),i.territory);
                    System.out.println("Sending data to " +i.username);
                    sendData(logged.getData(), ipAddress, port);
                }      
                rPacket = new PacketLogin(data);
                //((PacketLogin) rPacket).writeData(this);       
                connected.add(new PlayerProfile(((PacketLogin)rPacket).getUserName(),((PacketLogin)rPacket).getXCoord(),((PacketLogin)rPacket).getYCoord(),((PacketLogin)rPacket).getTerritory(),ipAddress,port));
                //SEND LOGIN STRING TO ALL CLIENTS
                this.sendDataAll(rPacket.getData());
                break;
            default:
                System.out.println("CASE 1 WAS NOT MET!");
                break;
        }
    }
    
//if(type.equals("1"))
//{
//    String usertolog = "";
//    String value = (new String(data));
//    //UPDATE LOGGED IN PLAYER ON ALL CONNECTED PLAYERS
//    for(PlayerProfile i: connected )
//    {
//        System.out.println("Sending data to " +i.username);
//        usertolog = "1#" + i.username;
//        sendData(usertolog.getBytes(), x, y);
//    }                
//    //ADD PLAYER TO CONNECTED ARRAY ON SERVER
//    connected.add(new PlayerProfile(((PacketLogin)rPacket).getUserName(),((PacketLogin)rPacket).getXCoord(),((PacketLogin)rPacket).getYCoord(),((PacketLogin)rPacket).getTerritory(),ipAddress,port));
//    //SEND USERNAME OF NEW PLAYER TO ALL CONNECTED PLAYERS
//    //INCLUDING NEW PLAYER
//    this.sendDataAll(value.getBytes());
//}
//else
//{
//String hello = "hello " + type;
//this.sendData(hello.getBytes(), x, y);
//}

    //send data to a specific user
    public void sendData(byte[] toSend, InetAddress address, int portme)
    {
        DatagramPacket sender = new DatagramPacket(toSend, toSend.length, address, portme);
        try 
        {
            this.socket.send(sender);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    //broadcast data to all logged in players
    public void sendDataAll(byte[] toSend)
    {
        for(PlayerProfile i : connected)
        {
            this.sendData(toSend, i.ipAddress, i.port );
        }
    }

    //make suere a player isn't logged in
    public boolean isLogged(int p)
    {
        for(PlayerProfile i : connected)
        {
            if(i.port == p)
            {
                return true;
            }
        }
        return false;
    }
}    
