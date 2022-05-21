package com.ramazankayis.module.association;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AssociationMainTest {
    //assosication: gevşek bağlantıdır:
    public static void main(String[] args) {
        Market market= Market.builder().marketAdi("Xyz market").marketId(12L).build();
        Musteri musteri=Musteri.builder().musteriId(44L).musteriAdi("Müşteri Adı").musteriSoyadi("MüşteriSoyadı").build();

        log.info("Market Bilgileri: "+market+" Müşteri Bilgileri: "+musteri);
    }
}
