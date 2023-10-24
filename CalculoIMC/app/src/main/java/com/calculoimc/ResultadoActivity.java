package com.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView mTextViewResultado;
    private TextView mTextViewCalculado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        mTextViewResultado = findViewById(R.id.textViewResultado);
        mTextViewCalculado = findViewById(R.id.textViewCalculado);

        SharedPreferences sharedPreferences =
                getSharedPreferences(MainActivity.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);

        float valorPeso = sharedPreferences.getInt(MainActivity.PESO_KEY, 0);
        float valorAltura = sharedPreferences.getFloat(MainActivity.ALTURA_KEY, 0);

        float resultado = valorPeso / (valorAltura * valorAltura);

        mTextViewCalculado.setText(String.format("Seu IMC: %.2f", resultado));

        if (resultado <= 18.5) {
            mTextViewResultado.setText("Abaixo do peso");
        } else if (resultado <= 24.9) {
            mTextViewResultado.setText("Peso Normal");
        } else if (resultado <= 29.9) {
            mTextViewResultado.setText("Sobrepeso");
        } else {
            mTextViewResultado.setText("Obeso");
        }

    }
}
