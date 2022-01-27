package mgg.noticiero;

public class Noticia {
    private String titular;
    private String fecha;
    private String autor;
    private String link;

    public Noticia() {
    }

    public Noticia(String titular, String fecha, String autor, String link) {
        this.titular = titular;
        this.fecha = fecha;
        this.autor = autor;
        this.link = link;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
