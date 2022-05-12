package com.example.qrgenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditextNumber extends AppCompatActivity {

    public static final String ENVIAR_NUMERO = "numero";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editext_number);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btn_sendNumber = (Button) findViewById(R.id.btn_SendDatos);
        btn_sendNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarDatos(view);
            }
        });

    }

    public void enviarDatos(View view){
        Intent intent = new Intent(this, MainActivity.class);
        EditText edt_number = (EditText) findViewById(R.id.edtDatos);
        String datoUno = edt_number.getText().toString();
        intent.putExtra(ENVIAR_NUMERO, datoUno);
        startActivity(intent);
    }



    public void validarData(){

    }


}