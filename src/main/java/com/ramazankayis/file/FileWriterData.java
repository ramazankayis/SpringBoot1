package com.ramazankayis.file;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedWriter;
import java.io.FileWriter;

//file writer
//URL: C:\file
@Log4j2
public class FileWriterData {

    //Dosya Yazmak
    public static void fileWriter() {
        try (BufferedWriter bW = new BufferedWriter(new FileWriter(FilePath.PATH, true))) {
            bW.write("1.satır\n");
            bW.write("2.satır");
            bW.flush();
            log.info("Ekleme Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Main
    public static void main(String[] args) {
        fileWriter();
    }

}
