package com.calculoimc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String ARQUIVO_MEUS_DADOS = "MeusDados";
    public static final String ALTURA_KEY = "altura";
    public static final String PESO_KEY = "peso";
    public static final String RESULTADO_KEY = "resultado";

    private EditText mEditTextAltura;
    private EditText mEditTextPeso;
    private Button mButtonCalcular;

    public void salvarDados(float altura, int peso){
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);

        sharedPreferences.edit()
                .putFloat(ALTURA_KEY, altura)
                .putInt(PESO_KEY, peso)
                .apply();
    }

    public void calcularIMC(float altura, int peso){
        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);

        float valorAltura = sharedPreferences.getFloat(ALTURA_KEY, 0);
        int valorPeso = sharedPreferences.getInt(PESO_KEY, 0);

        float resultado = valorPeso / (valorAltura * valorAltura);
        sharedPreferences.edit()
                .putFloat(RESULTADO_KEY, resultado)
                .apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextAltura = findViewById(R.id.editTextAltura);
        mEditTextPeso = findViewById(R.id.editTextPeso);
        mButtonCalcular = findViewById(R.id.buttonCalcular);

        mButtonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float altura = Float.parseFloat(mEditTextAltura.getText().toString());
                    int peso = Integer.parseInt(mEditTextPeso.getText().toString());

                    salvarDados(altura, peso);
                    calcularIMC(altura, peso);

                    Intent intent = new Intent(getBaseContext(), ResultadoActivity.class);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    // Trate a exceção de conversão aqui (por exemplo, exiba uma mensagem ao usuário)
                    Toast.makeText(getApplicationContext(), "Por favor, insira números válidos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
