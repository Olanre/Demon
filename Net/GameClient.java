/*
 * Client class which allows a player
 * to communicate to a server
 */
package Net;

import Game.GameMain;
import Game.Holder;

import Player.PlayerProfile;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Net.Packet.Packet;
import Net.Packet.PacketLogin;

public class GameClient extends Thread 
{

    public GameMain mainGame;//Incase we need the game class
    public GameServer server;
    public DatagramSocket socket;
    public InetAddress ipAddress;

    public GameClient(GameMain mainGame, String ipAddress) 
    {
        this.mainGame = mainGame;

        try 
        {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
        } 
        catch (SocketException | UnknownHostException e) 
        {
            e.printStackTrace();
        }        
    }

    //recieve data from server or someone else
    public void run() 
    {
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
            parseData(packet.getData());
        }
    }
    
    public void parseData(byte[] data)
    {
        //extracts packet type
        String type = new String(data).trim().substring(0,1);
        Packet rPacket;
        switch(type){
            case "1":
                rPacket = new PacketLogin(data);
                System.out.println("Entered Client Parse site "+ ((PacketLogin)rPacket).getUserName());
                PlayerProfile newLogin = new PlayerProfile(((PacketLogin)rPacket).getUserName(),((PacketLogin)rPacket).getXCoord(), ((PacketLogin)rPacket).getYCoord() );
                mainGame.connected.add(newLogin);
                //creates instance of all logged in players
                for(PlayerProfile p: mainGame.connected)
                {
                    mainGame.board.add(p.icon);
                    System.out.println(p.getXCoord());
                    mainGame.board.revalidate();
                    mainGame.board.repaint();
                }
                Holder.holder = newLogin;
                break;     
            default:
                System.out.println("CLIENT CASE 1 FAILED");
                break;
        }          
    }
        
        


//if(type.equals("1"))
//{
//    Packet login = new Packet(data);
//    System.out.println("Entered Client Parse site "+ login.userName);
//    PlayerProfile newLogin = new PlayerProfile(login.userName);
//    mainGame.connected.add(newLogin);
//    //creates instance of all logged in players
//    for(PlayerProfile p: mainGame.connected)
//    {
//        mainGame.board.add(p.icon);
//        System.out.println(p.getXCoord());
//        mainGame.board.revalidate();
//        mainGame.board.repaint();
//    }
//    Holder.holder = newLogin;
//}

    
    //Sends data to server
    public void sendData(byte[] toSend)
    {
        DatagramPacket sender = new DatagramPacket(toSend, toSend.length, ipAddress, 1331);
        try 
        {
            socket.send(sender);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
