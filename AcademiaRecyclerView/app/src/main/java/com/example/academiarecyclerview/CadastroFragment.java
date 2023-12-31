package com.example.academiarecyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroFragment extends Fragment {

    private Button mbuttonSalvar;
    private EditText mEditTextNome;
    private EditText mEditTextIdade;
    private EditText mEditTextAltura;
    private EditText mEditTextPeso;
    private EditText mEditTextUnidadeCadastro;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroFragment newInstance(String param1, String param2) {
        CadastroFragment fragment = new CadastroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mbuttonSalvar = getActivity().findViewById(R.id.salvar);
        mEditTextNome = getActivity().findViewById(R.id.nome);
        mEditTextIdade = getActivity().findViewById(R.id.idade);
        mEditTextAltura = getActivity().findViewById(R.id.altura);
        mEditTextPeso = getActivity().findViewById(R.id.peso);
        mEditTextUnidadeCadastro = getActivity().findViewById(R.id.unidadeCadastro);

        mbuttonSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String nome = mEditTextNome.getText().toString();
                int idade = Integer.parseInt(mEditTextIdade.getText().toString());
                double altura = Double.parseDouble(mEditTextAltura.getText().toString());
                double peso = Double.parseDouble(mEditTextPeso.getText().toString());
                String unidadeCadastro = mEditTextUnidadeCadastro.getText().toString();

                Aluno aluno = new Aluno(nome, idade, altura, peso, unidadeCadastro);

                DatabaseReference reference = FirebaseDatabase
                        .getInstance()
                        .getReference()
                        .child("Alunos");

                reference
                        .push()
                        .setValue(aluno);

                mEditTextNome.setText("");
                mEditTextIdade.setText("");
                mEditTextAltura.setText("");
                mEditTextPeso.setText("");
                mEditTextUnidadeCadastro.setText("");
            }
        });
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
        return inflater.inflate(R.layout.fragment_cadastro, container, false);
    }
}