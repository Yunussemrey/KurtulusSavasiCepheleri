package com.yunusemre.gezguc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.yunusemre.gezguc.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter arrayAdapter;
    ArrayList<BölgeBilgileri> bölgeBilgileriArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        bölgeBilgileriArrayList=new ArrayList<>(); //inizilate ettik.




        //oluşturduğumuz sınıf ile bilgileri bu şekil match ederek dizi oluşturcaz.
        BölgeBilgileri dogu=new BölgeBilgileri("DOĞU CEPHESİ", "Türk-Ermeni Savaşı","Kars",R.drawable.dogu,"");
        BölgeBilgileri bati=new BölgeBilgileri("BATI CEPHESİ","Türk-Yunan Savaşı" ," İzmir-Bursa-Balıkesir-Kütahya- \n Eskişehir",R.drawable.bati,"");
        BölgeBilgileri guney=new BölgeBilgileri("GÜNEY CEPHESİ", "Türk-Fransız Savaşı","Hatay",R.drawable.guney,"");
        BölgeBilgileri ic=new BölgeBilgileri("İÇ CEPHE", "İsyanlar","İstanbul Hükümeti",R.drawable.icjpg,"!NOT: Burada 'Şeyh Said' kurtuluş dönemindeki iç isyanlarımıza örnek olarak en çok" +
                " bilinen isim olduğu için konmuştur.");

        //Tanımlanan bilgileri dizi ye ekledik.
        bölgeBilgileriArrayList.add(dogu);
        bölgeBilgileriArrayList.add(bati);
        bölgeBilgileriArrayList.add(guney);
        bölgeBilgileriArrayList.add(ic);

        //array listedeki elemanları ekran da ki recycler view listesinde göstermek için "Adaptor" kullanılır.
        //burada basit şekilde listView ile dizimizi entegre ettik ve binding ile ekrana sırasıyla yazdırdık.
        //ama bu yöntem çok tercih edilmiyor. "RECYCLER LİST" yöntemi daha etkili.
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,
                bölgeBilgileriArrayList.stream().map(bölgeBilgileri -> bölgeBilgileri.önAd).collect(Collectors.toList()) //bu ifade string olmayan dizi miz için
        );
        binding.listView.setAdapter(arrayAdapter);
        //listeden bir elemana tıklandığında sonraki sayfaya gitmek için;
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //position hangisine tıklanırsa demek.
                Toast.makeText(getApplicationContext(),bölgeBilgileriArrayList.get(position).önAd,Toast.LENGTH_SHORT).show(); //tıkladığımızın altta mesajı gözüksün
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("yolla",bölgeBilgileriArrayList.get(position)); //burası kızdı. BölgeBilgileri sınıfımızı seriablize etmemiz gerekiyor.
                startActivity(intent);
            }
        });




    }
}