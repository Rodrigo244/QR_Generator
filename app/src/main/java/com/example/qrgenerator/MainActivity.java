package com.example.qrgenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String numero = intent.getStringExtra(EditextNumber.ENVIAR_NUMERO);


        TextView textView = findViewById(R.id.txtNumero);
        Button btnGenera = findViewById(R.id.btnGenera);
        Button btnGeneraBarra = findViewById(R.id.btnGeneraCode);
        ImageView qrCode = findViewById(R.id.qrCode);
        ImageView qrCodeBarras = findViewById(R.id.qrCodeBarras);


        btnGenera.setOnClickListener(view -> {

            try {
                BarcodeEncoder encoder = new BarcodeEncoder();
                Bitmap bitmap = encoder.encodeBitmap(numero, BarcodeFormat.QR_CODE, 750,750);
                qrCode.setImageBitmap(bitmap);

            }catch (Exception e) {
                e.printStackTrace();
            }
        });


        btnGeneraBarra.setOnClickListener(view -> {
            try {
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap_Uno = barcodeEncoder.encodeBitmap(numero, BarcodeFormat.PDF_417,900, 300);
                qrCodeBarras.setImageBitmap(bitmap_Uno);
                textView.setText(numero);
            }catch (Exception e){
                e.printStackTrace();
            }
        });


    }

}