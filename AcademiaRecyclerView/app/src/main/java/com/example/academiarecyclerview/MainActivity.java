package com.example.academiarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButtonListagem = findViewById(R.id.buttonListagem);
        Button mButtonCadastro = findViewById(R.id.buttonCadastro);

        mButtonListagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, new ListagemFragment())  // Substitui o fragmento atual pelo ListagemFragment
                        .commit();
            }
        });

        mButtonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, new CadastroFragment())  // Substitui o fragmento atual pelo CadastroFragment
                        .commit();
            }
        });
    }
}
