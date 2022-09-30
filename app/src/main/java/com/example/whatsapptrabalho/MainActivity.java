package com.example.whatsapptrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextInputLayout textInputLayoutNumero, textInputLayoutMensagem;
    private TextInputEditText  textInputEditNumero, textInputEditTextMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textInputEditTextMensagem= findViewById(R.id.textInputEditTextMensagem);
        textInputEditNumero = findViewById(R.id.textInputEditNumero);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                button();
            }
        });
    }
    private void button(){

        String numero = textInputEditNumero.getText().toString().trim();
        String mensagem = textInputEditTextMensagem.getText().toString();

        if(mensagem.isEmpty()){
            textInputEditTextMensagem.setError("Por favor escreva uma mensagem no campo:");
            return;
        }

        if(numero.length() < 11){
            textInputEditNumero.setError("Por favor insira um número de telefone válido no campo:");
            return;
        }

        if(!numero.substring(0,2).equals("55")&&numero.length()==11){
            numero = "55" + numero;
        }

        String url = "https://wa.me/" + numero +"?text=" + mensagem;

        Uri webpage = Uri.parse(url);
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(webIntent);
    }
}