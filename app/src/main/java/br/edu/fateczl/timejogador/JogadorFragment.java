/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */
package br.edu.fateczl.timejogador;

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

public class JogadorFragment extends Fragment {
    private EditText editTextNome;
    private EditText editTextIdade;
    private EditText editTextPosicao;
    private Button buttonSalvar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogador, container, false);

        // Inicializando os componentes
        editTextNome = view.findViewById(R.id.editTextNome);
        editTextIdade = view.findViewById(R.id.editTextIdade);
        editTextPosicao = view.findViewById(R.id.editTextPosicao);
        buttonSalvar = view.findViewById(R.id.buttonSalvar);

        // Configurando o botão de salvar
        buttonSalvar.setOnClickListener(v -> {
            if (validaCampos()) {
                salvarJogador();
            }
        });

        return view;
    }

    private boolean validaCampos() {
        // Verificando se os campos estão preenchidos
        if (editTextNome.getText().toString().isEmpty() ||
                editTextIdade.getText().toString().isEmpty() ||
                editTextPosicao.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void salvarJogador() {
        String nome = editTextNome.getText().toString();
        String idade = editTextIdade.getText().toString();
        String posicao = editTextPosicao.getText().toString();

        // Exibindo os dados em um Toast
        String mensagem = "Jogador salvo:\nNome: " + nome + "\nIdade: " + idade + "\nPosição: " + posicao;
        Toast.makeText(getContext(), mensagem, Toast.LENGTH_LONG).show();

        // Limpar os campos após salvar
        editTextNome.setText("");
        editTextIdade.setText("");
        editTextPosicao.setText("");
    }
}
