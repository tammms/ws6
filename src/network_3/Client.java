package network_3;

import java.net.Socket;

public class Client{

    static int defaultPort = 3000;
    public static void main(String[] args) throws Exception {
        
        if (args.length >0){
            defaultPort = Integer.parseInt(args[0]);
        }

        Socket socket = new Socket("localhost", defaultPort);
        CookieSession session = new CookieSession(socket);
        session.start();


    }


}