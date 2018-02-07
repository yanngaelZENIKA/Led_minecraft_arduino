import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* CE CODE MARCHE!!! */
/* CE CODE MARCHE!!! */
/* CE CODE MARCHE!!! */
/* CE CODE MARCHE!!! */
/* CE CODE MARCHE!!! */
/* CE CODE MARCHE!!! */
/* CE CODE MARCHE!!! */
/* CE CODE MARCHE!!! */
/* CE CODE MARCHE!!! */
public class test {

	private static final String FILENAME = "/home/default/.minecraft/logs/latest.log";
	private static final String TTYACM0 = "/dev/ttyACM0";
	
	public static void main(String[] args) {
		/* CE CODE MARCHE!!! */
		BufferedWriter bw = null;
		BufferedReader br = null;
		FileReader fr = null;
		FileWriter fw = null;
		Pattern pattern = Pattern.compile(".*: <yanngael> (.*)");
		/* CE CODE MARCHE!!! */		
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(TTYACM0);
			bw = new BufferedWriter(fw);
			
			String sCurrentLine;
		  while (true){
			while ((sCurrentLine = br.readLine()) != null) {
				Matcher matcher = pattern.matcher(sCurrentLine);
				if (matcher.find()) {
					String command = matcher.group(1);
					System.out.println(command);
					if (command.equals("led on")){
						bw.write(1);
						bw.flush();
					} else if (command.equals("led off")){
						bw.write(0);
						bw.flush();
					}
				
				}
			}
		  }	
		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
				/*if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
				*/

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}