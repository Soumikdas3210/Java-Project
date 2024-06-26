package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;



public class UserRepository {
	public int validateCredentials(String username, String password) {

		int flag = 2;
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
					if (words[3].equals("0")) {
						flag = 0;
						break;
					} else if (words[3].equals("1")) {
						flag = 1;
						break;
					}
				}
			}

		} catch (Exception ex3) {
			System.out.println(ex3.getMessage());
		}
		return flag;
	}

	public void registerUser(String username, String password, String email, String answer, String question) {

		File f = new File("data/user.txt");
		try {
			f.createNewFile();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		FileWriter fw = null;

		try {
			fw = new FileWriter(f, true);
			fw.write(username);
			fw.write("\t");
			fw.write(password);
			fw.write("\t");
			fw.write(email);
			fw.write("\t");
			fw.write("1");
			fw.write("\t");
			fw.write(question);
			fw.write("\t");
			fw.write(answer);
			fw.write("\n");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				fw.close();
			} catch (Exception ex1) {
				System.out.println(ex1.getMessage());
			}
		}
	}

	public void registerAdmin(String username, String password, String email) {

		File f = new File("data/user.txt");
		try {
			f.createNewFile();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		FileWriter fw = null;

		try {
			fw = new FileWriter(f, true);
			fw.write(username);
			fw.write("\t");
			fw.write(password);
			fw.write("\t");
			fw.write(email);
			fw.write("\t");
			fw.write("0");
			fw.write("\n");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				fw.close();
			} catch (Exception ex1) {
				System.out.println(ex1.getMessage());
			}
		}
	}

	public int validateUsernameEmail (String username, String email){
		int flag = 0;
		File f = new File("data/user.txt");

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {

				String words[] = line.split("\t");
				System.out.println(words[2]);
				if (words[0].equals(username)||words[2].equals(email)) {
					flag = 0;
					break;
				}else {
					flag = 1;
				}
			}

		} catch (Exception ex3) {
			System.out.println(ex3.getMessage());
		}
		return flag;

	}


}
