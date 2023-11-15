package network_3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientHandler {

    public Cookie cookie;
    public Socket socket;

    ClientHandler(Cookie cookie, Socket client){
        this.cookie = cookie;
        this.socket = client;
    }

    public void start() throws Exception{
        
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        boolean stop = false;

        while(!stop){
            
            String input = br.readLine();
            input = input.trim().toLowerCase();
            if(input.length()<=0)
                continue;
            String[] inputArray = input.split(" ");
            int count =1;

            switch (inputArray[0]) {
                case "cookie":
                if (inputArray.length>1){
                    count = Integer.parseInt(inputArray[1]);}
                    cookie.getMessage(count)
                        .stream()
                        .map(line -> "%s\n".formatted(line))
                        .forEach(line -> {
                            try{
                                System.out.println("Cookie message: "+ line);
                                bw.write(line);
                                bw.flush();
                            } catch (Exception ex){ }
                        });
                        bw.write("end\n");
                        bw.flush();

                    break;

                case "end":
                System.out.println("Session Ended! byebye");
                stop = true;
            
                default:
                    bw.write("Session ended\n");
                    bw.flush();

                    break;
            }

        
        }
        is.close();
        os.close();
        socket.close();
    }


    
}
