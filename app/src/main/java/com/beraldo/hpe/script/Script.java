package com.beraldo.hpe.script;

import static com.beraldo.hpe.script.CMake.getCMakeTxt;

import java.io.File;

/**
 * @author xiaofei_dev
 * @date 2022/5/21
 */
public class Script {
    public static void main(String[] args){
        File file = new File("C:\\AndroidProject\\android-hpe\\dlib\\src\\main\\cpp\\opencv32");
        getCMakeTxt(file);
    }
}
