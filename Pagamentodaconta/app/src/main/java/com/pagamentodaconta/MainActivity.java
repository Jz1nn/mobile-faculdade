package com.pagamentodaconta;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private EditText mEditTextValorConta, mEditTextDinheiro;
    private TextView mTextViewValorGorjeta, mTextViewTotal, mTextViewTroco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextValorConta = findViewById(R.id.editTextValorConta);
        mEditTextDinheiro = findViewById(R.id.editTextDinheiro);
        mTextViewValorGorjeta = findViewById(R.id.textViewValorGorjeta);
        mTextViewTotal = findViewById(R.id.textViewTotal);
        mTextViewTroco = findViewById(R.id.textViewTroco);
    }

    @SuppressLint("DefaultLocale")
    public void calcular(View view){
        String valorContaDigitada = mEditTextValorConta.getText().toString();
        String valorDinheiroDigitado = mEditTextDinheiro.getText().toString();

        if(!(valorContaDigitada.isEmpty()) && !(valorDinheiroDigitado.isEmpty())){
            float valorConta = Float.parseFloat(valorContaDigitada);
            float valorDinheiro = Float.parseFloat(valorDinheiroDigitado);

            float valorGorjeta = valorConta * 15 / 100;
            float total = valorConta + valorGorjeta;
            float troco = valorDinheiro - total;

            mTextViewValorGorjeta.setText(String.format("R$ %.2f", valorGorjeta));
            mTextViewTotal.setText(String.format("R$ %.2f", total));
            mTextViewTroco.setText(String.format("R$ %.2f", troco));
        }
    }

    public void limparDados(View view){
        mEditTextValorConta.setText("");
        mEditTextDinheiro.setText("");
    }
}