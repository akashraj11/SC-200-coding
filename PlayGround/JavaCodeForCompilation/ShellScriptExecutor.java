import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ShellScriptExecutor {
    /**
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException {
        try{
            System.out.println("start excution......");
            String[] command = {"/bin/bash", "shellScript.sh", "a/" , "HelloWorld"};
            ProcessBuilder p = new ProcessBuilder(command);
            Process p2 = p.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("ending excution......");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
