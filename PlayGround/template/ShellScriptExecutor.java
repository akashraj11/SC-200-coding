import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileReader;
import java.lang.Object;

import java.io.FileInputStream;

public class ShellScriptExecutor {
    /**
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException {

	System.out.println(args[0]);
        walkin(new File(args[0]));
    }

    public static void walkin(File dir) {
        String pattern = ""; //for example ".java"

        File listFile[] = dir.listFiles();
        String path[] = new String[listFile.length];
        String content[] = new String[listFile.length];
        if(listFile != null) {
            for(int i=0; i<listFile.length; i++) {
                if(listFile[i].isDirectory()) {
                    walkin(listFile[i]);
                } else {
                    if(listFile[i].getName().endsWith(pattern))
                    {
                        try{
                            content[i] = readFile(listFile[i].getPath());
//                            System.out.println(listFile[i].getEncoding());
                        }
                        catch (Exception e)
                        {
                            System.out.println("bshfjbdj");
                        }
                        path[i] = listFile[i].getPath();
                    }
                }
            }
        }

        for(int i=0; i<listFile.length; i++) {
            System.out.println(path[i]);
        }

        for(int i=0; i<listFile.length; i++) {
            System.out.println(content[i]);
        }
    }


    public static String readFile(String Path)
    {
        if(Path.contains(".java") || Path.contains(".ts") || Path.contains(".html") || Path.contains(".css") || Path.contains(".json"))
        {
            try {

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(Path), "UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                String ls = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                reader.close();
                String content = stringBuilder.toString();
                return content;

            }
            catch (Exception e)
            {
                System.out.println("fbhd");
                return "fcbdj";
            }
        }
        else
        {
            return "";
        }
    }

}
