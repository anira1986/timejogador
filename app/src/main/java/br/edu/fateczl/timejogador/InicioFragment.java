/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.timejogador;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InicioFragment extends Fragment {

    private View view;
    private TextView tvInicio;

    public InicioFragment() {
        // Construtor vazio (obrigatório)
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar o layout do fragmento
        view = inflater.inflate(R.layout.fragment_inicio, container, false);

        // Inicializar o TextView
        tvInicio = view.findViewById(R.id.tvInicio);

        // Centralizar o texto no TextView
        tvInicio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvInicio.setText(getString(R.string.inicio));

        return view;
    }
}
