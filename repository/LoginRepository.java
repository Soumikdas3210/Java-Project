package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoginRepository {

	public boolean validateCredentials(String username, String password) {
        boolean flag = true;
		File f = new File("data.txt");
			try {
				f.createNewFile();
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}

			FileReader fr = null;
			BufferedReader br = null;
 
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				String line = "";
				while ((line = br.readLine()) != null) {
					String words[] = line.split("\t");
					if (words[0].equals(username) && words[1].equals(password)) {
						flag = true;
						break;
					}
					else {
						flag = false;
						break;
					}
				}

			} catch (Exception ex3) {
				System.out.println(ex3.getMessage());
			}
            return flag;
	}
}
