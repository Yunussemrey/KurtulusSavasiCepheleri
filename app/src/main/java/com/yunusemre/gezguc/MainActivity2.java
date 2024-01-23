package com.yunusemre.gezguc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.yunusemre.gezguc.databinding.ActivityMain2Binding;
import com.yunusemre.gezguc.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {


    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent=getIntent();

        //Casting---> bölgeBilgileri olduğunu onaylıyoruz..
        BölgeBilgileri secilenbilgi= (BölgeBilgileri) intent.getSerializableExtra("yolla"); //anahtar kelimeyi girerek bilgileri aldık!!!

        //nereye ne gelecek tanımlıyoruz
        binding.textView4.setText(secilenbilgi.önAd);
        binding.textView.setText(secilenbilgi.isim);
        binding.textView2.setText(secilenbilgi.sehir);
        binding.imageView.setImageResource(secilenbilgi.image);
        binding.textView5.setText(secilenbilgi.aciklama);

    }
    public void geriDon(){
        Toast.makeText(getApplicationContext(),"Ana Sayfaya Dönülüyor..",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}