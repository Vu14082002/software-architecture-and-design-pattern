package test;

import jdepend.xmlui.JDepend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("result.xml"));
        JDepend depend = new JDepend(printWriter);
        depend.addDirectory("T:\\VoVanHai\\source-code\\demo");
        depend.analyze();
    }
    public void excCommand(String new_dir){
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(new String[]{"cmd.exe","/c","start"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}