package mgg.noticiero;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private LinkedList<Noticia> lista;
    private Borrador interfazBorrador;

    public Adapter(LinkedList<Noticia> lista, Borrador interfazBorrador) {
        this.lista = lista;
        this.interfazBorrador = interfazBorrador;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.add_noticia, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.render(lista.get(position), interfazBorrador);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
