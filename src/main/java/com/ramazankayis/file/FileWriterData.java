package com.ramazankayis.file;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

@Log4j2
public class FileWriterData {

    public static String writeUser(){
        Scanner klavye=new Scanner(System.in);
        System.out.println("Lütfen birşeyler yazınız");
        return klavye.nextLine();
    }

    //Dosya Yazmak
    public static void fileWriter() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FilePath.PATH, true))) {
            bufferedWriter.write(writeUser());
            bufferedWriter.flush();
            log.info("Ekleme Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Dosya Okumak
    public static void fileReader() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FilePath.PATH))) {
            StringBuilder stringBuilder = new StringBuilder();
            String okunan = "", satir = "";
            while ((satir = bufferedReader.readLine()) != null) {
                stringBuilder.append(satir);
            }
            log.info(stringBuilder.toString());
        } catch (Exception e) {
        }
    }

    //
    public static void allData(){
        Scanner klavye=new Scanner(System.in);
        while(true){
            System.out.println("Lütfen Seçim yapınız. \n1-)Okuma\n2-)Yazmak\n3-)Çıkış");
            int chooise=klavye.nextInt();
            switch (chooise){
                case 1:
                    log.info("Okuma");
                    fileReader();
                    break;

                case 2:
                    log.info("Yazmak");
                    fileWriter();
                    break;

                case 3:
                    log.info("sistemde çıkılıyor");
                    System.exit(0);
                    break;

                default:
                    log.info("Doğru Seçimi yapınız");
                    break;
            }
        }

    }


    //Main
    public static void main(String[] args) {
        allData();

    }
}
