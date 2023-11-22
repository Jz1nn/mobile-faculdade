package com.example.academiarecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AcademiaAdaptador extends RecyclerView.Adapter<AcademiaAdaptador.AcademiaViewHolder> {
    private List<Aluno> mListAluno; // Cria a lista de alunos

    @NonNull
    @Override
    public AcademiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aluno, parent, false);
        AcademiaViewHolder viewHolder = new AcademiaViewHolder(view);
        return viewHolder;
    }

    // Metodo para criar as view (layout manager chama esse metodo)
    @Override
    public void onBindViewHolder(@NonNull AcademiaViewHolder holder, int position) {
        Aluno aluno = mListAluno.get(position);

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
        if (mListAluno == null) return 0;
        return mListAluno.size();

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
    public void atualizarListagemCompleta(List<Aluno> mListProduto) {
        // Atualiza a listagem do Adaptador
        this.mListAluno = mListProduto;

        // Notifica o Adaptador para atualizar a listagem completa
        notifyDataSetChanged();
    }

    // Métodos para notificar o Adapter sobre mudanças nos itens da listagem
    public void inserirItemNaListagem(int position, List<Aluno> mListAluno) {
        this.mListAluno = mListAluno;
        // Notifica o Adaptador para inserir o item de acordo com a posicao recebida no parametro
        notifyItemInserted(position);
    }

    public void excluirItemDaListagem(int position, List<Aluno> mListAluno) {
        this.mListAluno = mListAluno;
        // Notifica o Adaptador para remover o item de acordo com a posicao recebida no parametro
        notifyItemRemoved(position);
    }

    public void atualizarItemNaListagem(int position, List<Aluno> mListAluno) {
        this.mListAluno = mListAluno;

        // Notifica o Adaptador para atualizar os dados do item de acordo com a posicao recebida no parametro
        notifyItemChanged(position);
    }
}