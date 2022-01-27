package mgg.noticiero;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class Preferences {
    private String nombre;
    SharedPreferences sp;

    public Preferences(Context context) {
        nombre = "MiniDB";
        sp = context.getSharedPreferences(nombre, 0);
    }

    public void saveNoticias(LinkedList<Noticia> list) {
        for (int i = 0; i < list.size(); i++) {
            Noticia n = list.get(i);
            sp.edit().putString("saveTitular" + i, n.getTitular()).apply();
            sp.edit().putString("saveAutor" + i, n.getAutor()).apply();
            sp.edit().putString("saveFecha" + i, n.getFecha()).apply();
            sp.edit().putString("saveLink" + i, n.getLink()).apply();
        }
    }

    public LinkedList<Noticia> getNoticias() {
        LinkedList<Noticia> noticias = new LinkedList<>();
        boolean hayNoticias = true;
        int contador = 0;
        while (hayNoticias) {
            Noticia noticia = new Noticia();
            if (sp.getString("saveTitular" + contador, "no").equals("no")) {
                hayNoticias = false;
            } else {
                noticia.setTitular(sp.getString("saveTitular" + contador, "no"));
                noticia.setAutor(sp.getString("saveAutor" + contador, "no"));
                noticia.setFecha(sp.getString("saveFecha" + contador, "no"));
                noticia.setLink(sp.getString("saveLink" + contador, "no"));
                noticias.add(noticia);

                contador++;
            }
        }


        return noticias;
    }
}
