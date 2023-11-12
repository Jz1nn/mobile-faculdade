package com.example.jogofragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CadastrarFragment extends Fragment {

    Button mBotaoJogar;
    Button mBotaoCadastrar;
    EditText mEditTextPerg;
    EditText mEditTextResp;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastrarFragment() {

    }

    public static CadastrarFragment newInstance(String param1, String param2) {
        CadastrarFragment fragment = new CadastrarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastrar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBotaoJogar = getActivity().findViewById(R.id.botaoJogar);
        mBotaoCadastrar = getActivity().findViewById(R.id.botaoCadastrar);
        mEditTextPerg = getActivity().findViewById(R.id.editPergunta);
        mEditTextResp = getActivity().findViewById(R.id.editResposta);

        mBotaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, new JogarFragment()).commit();
            }
        });

        mBotaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pergunta = mEditTextPerg.getText().toString();
                String resposta = mEditTextResp.getText().toString();

                if(!pergunta.isEmpty() && !resposta.isEmpty()){
                    // Cria um objeto do tipo Questoes com os valores digitados pelo usuário
                    Questoes questoes = new Questoes(pergunta, resposta);

                    //atraves da classe DAO insere questao no BD
                    BancoDeDados.getBancoDeDados(getActivity())
                            .meuDAO().inserirQuestao(questoes);

                    mEditTextPerg.setText("");
                    mEditTextResp.setText("");

                    Toast.makeText(getActivity(), "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}