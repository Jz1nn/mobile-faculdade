package com.example.academiarecyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListagemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListagemFragment extends Fragment {

    private List<Aluno> listaAlunos = new ArrayList<>(); // Declaração da lista de alunos (será preenchida posteriormente)
    private RecyclerView recyclerView;
    private AcademiaAdaptador academiaAdaptador;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListagemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListagemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListagemFragment newInstance(String param1, String param2) {
        ListagemFragment fragment = new ListagemFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listagem, container, false);
        recyclerView = view.findViewById(R.id.fragmentListagem);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Inicializa o adapter e o RecyclerView
        academiaAdaptador = new AcademiaAdaptador(listaAlunos);
        recyclerView.setAdapter(academiaAdaptador);

        // Define um tamanho fixo para o RecyclerView ser exibido no layout (opcional)
        recyclerView.setHasFixedSize(true);

        // Define o LayoutManager (LinearLayoutManager por exemplo)
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Carrega os dados dos alunos e atualize a lista
//        carregarAlunosDoBancoDeDados();
        academiaAdaptador.atualizarLista(listaAlunos);

    }
}