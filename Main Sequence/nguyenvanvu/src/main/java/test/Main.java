package test;

import jdepend.xmlui.JDepend;

import java.io.*;
import java.util.Scanner;


public class Main {
    private static final String  FILE_RESULT_NAME = "result.xml";
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(FILE_RESULT_NAME));
        File file = new File("result.xml");
        System.out.println(file.getAbsolutePath());
        JDepend depend = new JDepend(printWriter);
        depend.addDirectory("T:\\VoVanHai\\source-code\\demo");
        depend.analyze();
        String packagesPrefix = getPackages(FILE_RESULT_NAME);
        System.out.println("--------------"+ packagesPrefix);
        excCommand(file.getAbsolutePath(),packagesPrefix);

    }
    public static void excCommand(String xmlfileName,String packagesPrefix){
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(new String[]{"cmd.exe","/c","npm run jdepend-ui"+ xmlfileName +packagesPrefix});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getPackages(String filename){
        try {
            String data ="";
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if (!data.contains("java") && data.contains("<Package name=")){
                    myReader.close();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "";
    }
}