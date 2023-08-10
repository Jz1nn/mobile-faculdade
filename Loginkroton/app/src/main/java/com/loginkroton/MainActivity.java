package com.loginkroton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    mEditText = findViewById(R.id.editText);
    mTextView = findViewById(R.id.textView);
    }

    @SuppressLint("SetTextI18n")
    public void confirmar(View view) {

        String textoDigitado = mEditText.getText().toString();
        mTextView.setText("O curso digitado é: " + textoDigitado);
        }
}
