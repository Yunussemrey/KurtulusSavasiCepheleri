package com.yunusemre.gezguc;

import java.io.Serializable;

public class BölgeBilgileri implements Serializable { //böyle yaptık dizi deki elemanlara basınca diğer sayfada burda ki bilgiler gözüksün diye
    String önAd;
    String isim;
    String sehir;
    int image; //image int diye tanımlıyoruz çünkü android studio integer türünde değere çeviriyor.
    String aciklama;

    public BölgeBilgileri(String önAd,String isim,String sehir,int image,String aciklama){
        this.önAd=önAd;
        this.isim=isim;
        this.sehir=sehir;
        this.image=image;
        this.aciklama=aciklama;
    }
}
