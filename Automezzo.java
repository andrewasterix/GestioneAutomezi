package autonoleggio;

public class Automezzo {

	// Costruttore per parametri
	public Automezzo(String marca, String modello, String targa, int anno_im, int anno_re) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.anno_im = anno_im;
		this.anno_re = anno_re;
	}
	
	// Overload Getter
	public String getMarca() {
		return marca;
	}
	public String getModello() {
		return modello;
	}
	public String getTarga() {
		return targa;
	}
	public int getAnno_im() {
		return anno_im;
	}
	public int getAnno_re() {
		return anno_re;
	}

	// Overload Setter
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public void setAnno_im(int anno_im) {
		this.anno_im = anno_im;
	}

	public void setAnno_re(int anno_re) {
		this.anno_re = anno_re;
	}

	private String marca;
	private String modello;
	private String targa;
	
	private int anno_im;
	private int anno_re;
}