package mgg.noticiero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity implements Borrador {
    private Button btnadd;
    private LinkedList<Noticia> noticias;
    private Dialogo dialog;
    private RecyclerView recycler;
    private Adapter adapter;
    private LottieAnimationView corazon;
    private boolean sub = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

    }

    private void initUI() {
        initView();
        initListeners();
        initRecyclerView();
    }

    private void initRecyclerView() {
        noticias = NoticiaApplication.pref.getNoticias();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }

    private void initView() {
        noticias = new LinkedList<>();
        dialog = new Dialogo();
        btnadd = findViewById(R.id.btnAdd);
        recycler = findViewById(R.id.recycler);
        corazon = findViewById(R.id.corazon);
        adapter = new Adapter(noticias, this::borrador);
    }

    private void initListeners() {
        btnadd.setOnClickListener(x -> {
            dialog.show(getSupportFragmentManager(), "añadidor");
        });
        corazon.setOnClickListener(x -> sub = animacion(corazon, R.raw.animacion, sub));
    }


    private boolean animacion(LottieAnimationView lav, int animation, boolean like) {
        if (!like) {
            lav.setAnimation(animation);
            lav.setTranslationX(lav.getTranslationX()-1200);
            lav.playAnimation();
        } else {
            lav.setTranslationX(lav.getTranslationX()+1200);
            lav.animate().alpha(0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    lav.setImageResource(R.drawable.ic_heart);
                    lav.setAlpha(1f);
                }


            });
        }
        return !like;
    }

    public void addNoticia(Noticia noticia) {
        noticias.add(noticia);
        adapter.notifyDataSetChanged();
        NoticiaApplication.pref.saveNoticias(noticias);
    }

    public void visitarLink(Noticia noticia) {
        Uri link = Uri.parse(noticia.getLink());
        Intent intent = new Intent(Intent.ACTION_VIEW, link);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuRemove) {
            noticias.removeAll(noticias);
            adapter.notifyDataSetChanged();
            NoticiaApplication.pref.saveNoticias(noticias);
            Toast.makeText(this, "Borrado con éxito", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void borrador(int i) {
        noticias.remove(i);
        adapter.notifyDataSetChanged();
        NoticiaApplication.pref.saveNoticias(noticias);
    }
}