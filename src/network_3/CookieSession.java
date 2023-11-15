package network_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class CookieSession {

    private Socket socket;

    public CookieSession(Socket socket){
        this.socket = socket;
    }

    public void start() throws Exception{

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        boolean stop = false;
        Console cons = System.console();
        
        while (!stop){

            String input = cons.readLine("> ");
            input = input.trim().toLowerCase()+ "\n";

            bw.write(input);
            bw.flush();

            while (true) {
                String result = cons.readLine();
                result = result.trim().toLowerCase();

                if ("end".equals(result)){
                    break;
                }
                System.out.println("Session Ended");

            }


        }

        



    }
    
}
