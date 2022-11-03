import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // don't need to specify a hostname, it will be the current machine
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("ServerSocket awaiting connections...");
        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");

        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        // create an object output stream from the output stream so we can send an object through it
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        // read the list of messages from the socket
       // List<Message> listOfMessages = (List<Message>) objectInputStream.readObject();
       // System.out.println("Received [" + listOfMessages.size() + "] messages from: " + socket);
        // print out the text of every message
        //System.out.println("All messages:");
       // listOfMessages.forEach((msg)-> System.out.println(msg.getText()));

       xTank game = new xTank();

        while(true) {
            if(objectInputStream.readObject() instanceof Craft) {
                game.getBoard().addCraft((Craft) objectInputStream.readObject());
            }
            
            //objectOutputStream.writeObject(game);
           // objectInputStream.readObject();
        }

        //System.out.println("Closing sockets.");
       // ss.close();
        //socket.close();
    }
}