package com.example.academiarecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AcademiaAdaptador extends RecyclerView.Adapter<AcademiaAdaptador.AcademiaViewHolder> {

    private List<Aluno> mListAlunos; // Adicionando a lista de alunos

    // Construtor para receber a lista de alunos
    public AcademiaAdaptador(List<Aluno> listaAlunos) {
        this.mListAlunos = listaAlunos;
    }

    @Override
    public AcademiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aluno, parent, false);
        return new AcademiaViewHolder(view);
    }

    // Metodo para criar as view (layout manager chama esse metodo)
    @Override
    public void onBindViewHolder(@NonNull AcademiaViewHolder holder, int position) {
        Aluno aluno = mListAlunos.get(position);

        // Atualizar os TextViews com os dados do Aluno
        holder.textViewNome.setText(aluno.getNome());
        holder.textViewIdade.setText(String.valueOf(aluno.getIdade()));
        holder.textViewAltura.setText(String.valueOf(aluno.getAltura()));
        holder.textViewPeso.setText(String.valueOf(aluno.getPeso()));
        holder.textViewUnidadeCadastro.setText(aluno.getUnidadeCadastro());
    }

    // Metodo para retornar o numero de itens na lista (layout manager chama esse metodo)
    @Override
    public int getItemCount() {
        if (mListAlunos != null) {
            return mListAlunos.size();
        } else {
            return 0;
        }
    }

    public void atualizarLista(List<Aluno> novaListaAlunos) {
        if (mListAlunos != null) {
            mListAlunos.clear(); // Limpa a lista atual de alunos
            mListAlunos.addAll(novaListaAlunos); // Adiciona a nova lista de alunos
            notifyItemRangeInserted(0, novaListaAlunos.size()); // Notifica sobre a inserção de novos itens
        } else {
            mListAlunos = novaListaAlunos; // Se a lista atual estiver vazia, apenas atribui a nova lista
            notifyDataSetChanged(); // Notifica o RecyclerView sobre as mudanças nos dados
        }
    }

    // INNER CLASS Classe ViewHolder para manter as referências das views
    public static class AcademiaViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNome;
        TextView textViewIdade;
        TextView textViewAltura;
        TextView textViewPeso;
        TextView textViewUnidadeCadastro;

        public AcademiaViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inicializar os TextViews do item_aluno.xml
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewIdade = itemView.findViewById(R.id.textViewIdade);
            textViewAltura = itemView.findViewById(R.id.textViewAltura);
            textViewPeso = itemView.findViewById(R.id.textViewPeso);
            textViewUnidadeCadastro = itemView.findViewById(R.id.textViewUnidadeCadastro);
        }
    }

    // Método para atualizar a lista (caso haja alterações)
    // Métodos para notificar o Adapter sobre mudanças nos itens da listagem
    public void adicionarAluno(Aluno aluno) {
        mListAlunos.add(aluno);
        notifyItemInserted(mListAlunos.size() - 1);
    }

    public void removerAluno(int position) {
        mListAlunos.remove(position);
        notifyItemRemoved(position);
    }

    public void atualizarAluno(int position, Aluno aluno) {
        mListAlunos.set(position, aluno);
        notifyItemChanged(position);
    }

}
