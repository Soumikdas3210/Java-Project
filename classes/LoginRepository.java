package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoginRepository {

	public int validateCredentials(String username, String password) {

		
        int flag = 2;
		File f = new File("D:\\java Project\\repository\\user.txt");
		
			
			FileReader fr = null;
			BufferedReader br = null;
 
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				String line = "";
				while ((line = br.readLine()) != null) {
					
					String words[] = line.split("\t");
					if ((words[0].equals(username) && words[1].equals(password))) {
						if(words[3].equals("0")){
							flag = 0;
						}
						else if (words[3].equals("1")){
							flag = 1;
						}
						break;
					}
					else {
						flag = 2;
						break;
					}
				}

			} catch (Exception ex3) {
				System.out.println(ex3.getMessage());
			}
            return flag;
	}
}
