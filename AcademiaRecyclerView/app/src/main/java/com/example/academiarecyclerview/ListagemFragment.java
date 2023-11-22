package com.example.academiarecyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListagemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListagemFragment extends Fragment {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference();
    private List<Aluno> mListAluno = new ArrayList<>(); // Declaração da lista de alunos (será preenchida posteriormente)
    private RecyclerView recyclerView;
    public AcademiaAdaptador academiaAdaptador;

    public ListagemFragment() {
        // Required empty public constructor
    }

    public ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            Aluno aluno = snapshot.getValue(Aluno.class);
            aluno.setId(snapshot.getKey());

            mListAluno.add(aluno); // Adiciona o aluno na lista local

            int position = mListAluno.indexOf(aluno);
            academiaAdaptador.inserirItemNaListagem(position, mListAluno);
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            Aluno aluno = snapshot.getValue(Aluno.class);
            aluno.setId(snapshot.getKey());

            int position = mListAluno.indexOf(aluno);
            mListAluno.set(position, aluno);
            academiaAdaptador.atualizarItemNaListagem(position, mListAluno);
        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            Aluno aluno = snapshot.getValue(Aluno.class);
            aluno.setId(snapshot.getKey());

            int position = mListAluno.indexOf(aluno);
            mListAluno.remove(aluno);

            academiaAdaptador.excluirItemDaListagem(position, mListAluno);
        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;

    private String mParam2;

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
    public void onStart() {
        super.onStart();

        reference.child("alunos")
                .orderByChild("nome")
                .addChildEventListener(childEventListener);

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

        mListAluno = new ArrayList<>();

        // Define um tamanho fixo para o RecyclerView ser exibido no layout
        recyclerView.setHasFixedSize(true);

        // Define o LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Linha entre cada item da listagem
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(itemDecoration);

        // Define o Adapter para o RecyclerView
        AcademiaAdaptador academiaAdaptador = new AcademiaAdaptador();
        recyclerView.setAdapter(academiaAdaptador);

        // Chama o metodo do Adapter responsavel por atualizar todos os itens da listagem
        academiaAdaptador.atualizarListagemCompleta(mListAluno);
    }

    @Override
    public void onStop() {
        super.onStop();

        reference.child("produtos")
                .removeEventListener(childEventListener);
    }

}