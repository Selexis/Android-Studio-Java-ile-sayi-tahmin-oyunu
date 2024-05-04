package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText sayigirisi;

    Button can1,can2,can3;
    TextView sonuc,leveltxt,kalanhak;
    Random rastgele=new Random();
    int rastgelesayi, hak=5,puan=0, aralik=10,level=1, can=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sayigirisi=(EditText) findViewById(R.id.edttxt);
        rastgelesayi=rastgele.nextInt(aralik)+1;
        sonuc=(TextView)findViewById(R.id.textView3);
        leveltxt=(TextView) findViewById(R.id.textView4);
        kalanhak=(TextView) findViewById(R.id.textView5);

        can1=(Button) findViewById(R.id.can2);
        can2=(Button) findViewById(R.id.can3);
        can3=(Button) findViewById(R.id.can3);
        leveltxt.setText("Level " + level);
        kalanhak.setText("Kalan Hakkınnız: "+hak);

    }

    public void tahmin(View view){

        try{
                int sayi = Integer.parseInt(sayigirisi.getText().toString());

            if(hak>0){
                if(sayi==rastgelesayi) {
                    sayigirisi.setText("");
                    puan=puan + (5 * hak * level);

                    sonuc.setText(String.valueOf(puan));


                    if(puan<30)
                    {
                        aralik=10;
                        level=1;
                    }

                    else if(puan<70)
                    {
                        aralik=30;
                        level=2;
                    }

                    else if(puan<120)
                    {
                        aralik=40;
                        level=3;
                    }

                    else if(puan<200)
                    {
                        aralik=50;
                        level=4;
                    }

                    leveltxt.setText("LEVEL: " + level);

                    sayigirisi.setHint("Tebrikler Bildiniz... 1 - " + aralik + "arası yeni sayı giriniz");
                    sifirla();
                    kalanhak.setText("Kalan Hakkınız: " + hak);


                } else if (sayi<rastgelesayi) {
                    hak--;
                    kalanhak.setText("Kalan Hakkınız: " + hak);
                    sayigirisi.setText("");
                    sayigirisi.setHint("Sayıyı Büyütün");
                    if (hak == 0){
                        if (can != 0){
                            can--;


                        if(can == 2){
                            hak = 5;
                            can3.setVisibility(View.INVISIBLE);
                        }
                        else if(can == 1){
                            hak = 5;
                            can2.setVisibility(View.INVISIBLE);

                        }
                        else if(can == 0){
                            hak = 5;
                            can1.setVisibility(View.INVISIBLE);
                        }

                        kalanhak.setText("kalan hakkınız:  " + hak);

                    }else {
                        sayigirisi.setHint("Hakkınız Doldu... Doğru Cevap: " + rastgelesayi);
                        hak=0;
                        can=0;
                        }
                    }
                } else if (sayi>rastgelesayi) {

                    hak--;
                    kalanhak.setText("Kalan Hakkınız: "+ hak);
                    sayigirisi.setText("");
                    sayigirisi.setHint("Sayıyı küçültün");
                    if (hak == 0){
                        if (can != 0){
                            can--;


                            if(can == 2){
                                hak = 5;
                                can3.setVisibility(View.INVISIBLE);
                            }
                            else if(can == 1){
                                hak = 5;
                                can2.setVisibility(View.INVISIBLE);

                            }
                            else if(can == 0){
                                hak = 5;
                                can1.setVisibility(View.INVISIBLE);
                            }

                            kalanhak.setText("kalan hakkınız:  " + hak);
                        }else {
                            sayigirisi.setHint("Hakkınız Doldu... Doğru Cevap: " + rastgelesayi);
                            hak=0;
                            can=0;

                        }
                    }
                }

            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Bir sayı giriniz", Toast.LENGTH_SHORT).show();
        }
    }

    public void yeniden(View view){
        level=1;
        puan=0;
        aralik=10;
        sifirla();

        can=3;
        can1.setVisibility(View.VISIBLE);
        can2.setVisibility(View.VISIBLE);
        can3.setVisibility(View.VISIBLE);

        sayigirisi.setHint("1- "+ aralik+" arası bir sayı giriniz");
        sonuc.setText(("puan: "+puan));
        leveltxt.setText("LEVEL: "+level);
        kalanhak.setText("kalan hakkınız: " + hak);
    }
    public void sifirla() {
        rastgelesayi = rastgele.nextInt(aralik) + 1;
        hak = 5;

    }

}