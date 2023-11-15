package network_3;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static int defaultPort = 3000;

    public static void main(String[] args) throws Exception {
        
        String fileName ="";
        
        if (args.length == 1) {

            fileName = args[0];
        } else if(args.length == 2){
            
            fileName = args[0];
            defaultPort = Integer.parseInt(args[1]);

        } else{
            System.out.println("Argument error");
            System.exit(1);
        }

        System.out.printf("Loading cookie file %s\n", args[0]);
        Cookie cookie = new Cookie(fileName);

        System.out.printf("Starting server on port %d\n", defaultPort);
        ServerSocket server = new ServerSocket(defaultPort);

        while(true){
            Socket client = server.accept();
            System.out.println("New client connection");

            ClientHandler handler = new ClientHandler(cookie, client);
            handler.start();
            server.close();

        }

        
        




        


    }
    
}
