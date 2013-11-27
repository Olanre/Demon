/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Net;

import Game.GameMain;
import java.util.Scanner;
/**
 *
 * @author cs
 */
public class Test implements Runnable{
    //public GameMain mainGame = new GameMain();
    //public GameServer server = new GameServer(mainGame);
    public GameClient client;
    
    public Thread thread;
    
    public void run(){
    Scanner input = new Scanner(System.in);
        String thisthing;
        //server.start();
        thisthing = input.nextLine();
        //client = new GameClient(mainGame, "localhost", thisthing);
        client.start();
        //test to send data to server *sending name of client*
        client.sendData(thisthing.getBytes());
        //test to see if sending a broadcast to all players worked
        if(input.nextInt() == 1){
        client.sendData("1".getBytes());
        }
    }
    public void start(){}
    
    public static void main(String args[]){
        System.out.println("Hope this works");
        (new Thread(new Test())).start();
       
    }
    
}
