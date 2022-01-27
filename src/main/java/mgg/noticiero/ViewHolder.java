package mgg.noticiero;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView twTitulo;
    private TextView twAutor;
    private TextView twFecha;

    private ImageView iwBasura;
    private ImageView iwLink;

    private MainActivity main;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        main = getMain();
        twTitulo = itemView.findViewById(R.id.titular);
        twAutor = itemView.findViewById(R.id.autor);
        twFecha = itemView.findViewById(R.id.fecha);

        iwBasura = itemView.findViewById(R.id.iconoDelete);

        iwLink = itemView.findViewById(R.id.iconoEnlace);

    }

    public void render(Noticia noticia, Borrador borrador) {
        twTitulo.setText(noticia.getTitular());
        twAutor.setText(noticia.getAutor());
        twFecha.setText(noticia.getFecha());

        iwBasura.setOnClickListener(x -> {
            borrador.borrador(getAdapterPosition());
        });

        iwLink.setOnClickListener(x -> main.visitarLink(noticia));
    }

    public TextView getTwTitulo() {
        return twTitulo;
    }

    public void setTwTitulo(TextView twTitulo) {
        this.twTitulo = twTitulo;
    }

    public TextView getTwAutor() {
        return twAutor;
    }

    public void setTwAutor(TextView twAutor) {
        this.twAutor = twAutor;
    }

    public TextView getTwFecha() {
        return twFecha;
    }

    public void setTwFecha(TextView twFecha) {
        this.twFecha = twFecha;
    }

    public ImageView getIwBasura() {
        return iwBasura;
    }

    public void setIwBasura(ImageView iwBasura) {
        this.iwBasura = iwBasura;
    }

    public ImageView getIwLink() {
        return iwLink;
    }

    public void setIwLink(ImageView iwLink) {
        this.iwLink = iwLink;
    }

    public MainActivity getMain() {
        return main;
    }

    public void setMain(MainActivity main) {
        this.main = main;
    }
}
