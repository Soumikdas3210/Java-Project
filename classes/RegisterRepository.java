package classes;

import java.io.File;
import java.io.FileWriter;

public class RegisterRepository {

	public void registerUser(String username, String password, String email) {

		File f = new File("D:\\java Project\\repository\\user.txt");
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
}
