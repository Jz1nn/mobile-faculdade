package com.calculoicms;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private EditText mEditTextValor;
    private TextView mTextViewPorcentagem;
    private TextView mTextViewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextValor = findViewById(R.id.editTextValor);
        mTextViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        mTextViewTotal = findViewById(R.id.textViewTotal);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void calcular(View view) {

        String valorString = mEditTextValor.getText().toString();

        float valor = Float.parseFloat(valorString);

        float porcentagem = 13;

        float total = valor + (valor * porcentagem / 100);

        mTextViewPorcentagem.setText(porcentagem + "%");

        mTextViewTotal.setText(String.format("R$%.2f", total));
    }
}
