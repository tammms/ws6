package network_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Cookie {

    static List<String> cookieFile = new LinkedList<>();
    

    Cookie(String fileName) throws Exception{
        
        try (FileReader fr = new FileReader(fileName);){
        BufferedReader br = new BufferedReader(fr);
        cookieFile = br.lines()
            .map(line -> line.trim())
            .filter(line -> line.length()>0)
            .toList()
        ;
        }
    }

    public List<String> getMessage(int numberMessages){
        List<String> cookieMessgaes = new LinkedList<>();
        Random rand = new Random();
         
        for (int i =0; i<numberMessages; i++){
            int r = rand.nextInt(cookieFile.size()-1);
            cookieMessgaes.add(cookieFile.get(r));
        }

        return cookieMessgaes;


    }
    
}
