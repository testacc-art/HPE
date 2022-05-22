package com.beraldo.hpe.script;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 * @author xiaofei_dev
 * @date 2020/12/10
 */
public class CMake {
    public static StringBuilder sb = new StringBuilder();
    public static StringBuilder sbInclude = new StringBuilder();
    //key 的值根据具体项目具体替换
    public static String key = "main\\cpp";

    public static void getCMake(File file){
        if (file == null) return;
        if (file.isFile()){
            String name = file.getName();
            if (name.endsWith(".c") ||
                    file.getName().endsWith(".cpp") ||
                    file.getName().endsWith(".cc") ||
                    file.getName().endsWith(".a") ||
                    file.getName().endsWith(".h")){
                String path = file.getAbsolutePath();
                if (!path.contains(key)) return;
                sb.append(path.substring(path.indexOf(key) + key.length() + 1).replace('\\', '/'));
                sb.append("\n");
            }
        } else {
            for (File subFile : Objects.requireNonNull(file.listFiles())) {
                getCMake(subFile);
            }
        }
    }

    public static void getCMakeTxt(File fileCpp){
        getCMake(fileCpp);
        try{
            File file = new File("CMake.txt");

            //if file doesnt exists, then create it
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();

            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(sb.toString());
            bufferWritter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void getInclude(File file){
        if (file == null) return;
        if (file.isFile()){
            String name = file.getName();
            if (name.endsWith(".h")){
                String path = file.getAbsolutePath();
                if (!path.contains(key)) return;
                sbInclude.append(String.format("#include \"%s\"", path.substring(path.indexOf(key) + key.length() + 1).replace('\\', '/')));
                sbInclude.append("\n");
            }
        } else {
            for (File subFile : Objects.requireNonNull(file.listFiles())) {
                getInclude(subFile);
            }
        }
    }

    public static void getIncludeTxt(File fileCpp){
        getInclude(fileCpp);
        try{
            File file = new File("include.cpp");

            //if file doesnt exists, then create it
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();

            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(sbInclude.toString());
            bufferWritter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
