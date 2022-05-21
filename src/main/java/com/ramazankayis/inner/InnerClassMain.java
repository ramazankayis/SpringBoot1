package com.ramazankayis.inner;

public class InnerClassMain {

    public static void main(String[] args) {
        Ulke ulke=new Ulke();
        ulke.setUlkeAdi("Türkiye");

        Ulke.Sehir sehir=new Ulke.Sehir();
        sehir.setSehirAdi("İstanbul");

        Ulke.Sehir.Mahalle mahalle=new Ulke.Sehir.Mahalle();
        mahalle.setMahalleAdi("Başakşehir");

        System.out.println("Ülke Adı: "+ulke.getUlkeAdi()+" Şehir Adı:"+sehir.getSehirAdi()+" Mahalle Adı:"+mahalle.getMahalleAdi());
    }
}
