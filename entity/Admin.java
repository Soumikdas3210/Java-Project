package entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Admin extends User {

    public Admin(){
        super();
    }

     public Admin(String username, String password){
        super(username, password);
         File f = new File("data/user.txt");
		
			
			FileReader fr = null;
			BufferedReader br = null;
 
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				String line = "";
				while ((line = br.readLine()) != null) {
					
					String words[] = line.split("\t");
					if (words[0].equals(username) && words[1].equals(password)) {
						this.setEmail(words[1]);
				    }
                }
           }catch (Exception ex3) {
            System.out.println(ex3.getMessage());
        }
    }
    
}
