package entidades;

public class Remedio extends Produto {
    private String tarja;
    private String sintomasAparentes;

    public Remedio(double preco, int quantidade, String nome, String validade, String tarja, String sintomasAparentes) {
        super(preco, quantidade, nome, validade);
        this.tarja = tarja;
        this.sintomasAparentes = sintomasAparentes;
    }

    // Getters e Setters

    public String getTarja() {
        return tarja;
    }

    public String getSintomasAparentes() {
        return sintomasAparentes;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public void setSintomasAparentes(String sintomasAparentes) {
        this.sintomasAparentes = sintomasAparentes;
    }

}


/*
 /\___/\
( ^ v ^ ) 
<       > O Detentor do Codigo 
(_\___/_)      
*/