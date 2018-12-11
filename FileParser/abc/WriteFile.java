import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;


public class WriteFile {

	public static void main(String[] args) {
		String filePath = "docker-compose.yml";
		String text = "\n" +
				"  " + args[0] + "-" + args[1] + ":\n" +
				"    image: " + args[0] + "-" + args[1] + "\n" +
				"    build: ./challenges/" + args[0] +"/" + args[1] +"/\n" +
				"    network_mode: host\n" +
				"    container_name: " + args[0] + "-" + args[1] + "\n" +
				"    ports:\n" +
				"      - " + args[2] + ":" + args[2] + "\n" +
				"    expose:\n" +
				"      - " + args[2] + "\n" +
				"    volumes:\n" +
                                "      -  /var/run/docker.sock:/var/run/docker.sock\n" +
				"      -  /usr/app1/challenges/" + args[0] + "/" + args[1] + ":/usr/app" +
				"\n";
		File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}
}

