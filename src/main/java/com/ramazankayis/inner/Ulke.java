package com.ramazankayis.inner;

import lombok.Getter;
import lombok.Setter;

//public,static yazamıyoruz.
public class Ulke {
    //nesne değişkeni
    @Getter @Setter
    private String ulkeAdi;

    //inner class:Şehir
    public static class Sehir {
        @Getter @Setter
        private String sehirAdi;

        //inner class:Mahalle
        public static class Mahalle {
            @Getter @Setter
            private String mahalleAdi;
        }
    }
}


