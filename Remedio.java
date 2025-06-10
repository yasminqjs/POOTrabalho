package entidades;

public class Remedio extends Produto {
    private String tarja;
    private String sintomasAparentes;

    public Remedio(double preco, int quantidade, String nome, String validade, String tarja, String sintomas) {
        super(preco, quantidade, nome, validade);
        this.tarja = tarja;
        this.sintomasAparentes = sintomas;
    }

	public String getTarja() {
		return tarja;
	}

	public void setTarja(String tarja) {
		this.tarja = tarja;
	}

	public String getSintomasAparentes() {
		return sintomasAparentes;
	}

	public void setSintomasAparentes(String sintomasAparentes) {
		this.sintomasAparentes = sintomasAparentes;
	}

	@Override
	public String toString() {
		return super.toString() + " Categoria: Remedio | Tarja: "+ tarja + " | " + "SintomasAparentes: " + sintomasAparentes + " |";
	}

  
}
