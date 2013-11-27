/**
 * This class is used to initiate and store 
 * all the main instance variables of the game
 * such as board, game client and game server
 */

package Game;

import Board.Board;
import Net.GameClient;
import Net.GameServer;
import Player.PlayerProfile;
import java.util.ArrayList;

public class GameMain {
    public Board board;
    public GameMain mainGame;
    public GameServer server;
    public GameClient client;
    public PlayerProfile activePlayer;
    //a list of local instance of players connected to the server
    public ArrayList<PlayerProfile> connected;
    
    public GameMain(Board board){
        
        this.board = board;
        connected = new ArrayList<>();
        server = new GameServer(this);
        this.activePlayer = Game.Holder.holder;
        server.start();
        client = new GameClient(this, "localhost");
        client.start();
        //test to send data to server *sending name of client*
        //Using builddata to send message to server
        String toSend = "1#" +activePlayer.username;
        client.sendData(toSend.getBytes());
    }
}
