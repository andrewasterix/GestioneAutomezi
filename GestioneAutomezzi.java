package autonoleggio;

import java.util.*;

public class GestioneAutomezzi {
		
		// Costruttore
		public GestioneAutomezzi() {
			parco_auto = new ArrayList<Automezzo>();
			num_veicoli = 0;
			pos_corrente = 0;
		}
		
		// Metodo per il controllo dell'inserimento di un nuovo automezzo
		// Ritorna FALSE se non e possibile, altrimenti TRUE
		public boolean aggiungi_auto(Automezzo veicolo){
			parco_auto.add(veicolo);
			
			if(parco_auto.get(num_veicoli) != null) {
				num_veicoli++;
				return true;
			}else {
				return false;
			}
		}
		
		// Metodo per la dismissione di un veicolo
		// Ritorna TRUE se il veicolo è stato eliminato correttamente, FALSE altrimenti
		public boolean elimina_auto(String targa){
			
			int posizione = cerca_interno(targa);
			
			if (posizione >= 0) {
			    parco_auto.remove(posizione);
			    num_veicoli--;
			    return true;
			} else {
				return false;
			}
		}
		

		
		// Metodo per la ricerca del veicolo tramite targa
		// Ritorna un Automezzo se trovato, altrimenti null
		public Automezzo cerca_per_targa(String targa) {
			
			int posizione = cerca_interno(targa);
			
			if(posizione >= 0)
				return parco_auto.get(posizione);
			else 
				return null;
		}
		
		// Metodo interno per la ricerca di automezzi
		// Ritorna -1 se l'automezzo non è presente nell'elenco e altrimenti la sua posizione in elenco
		private int cerca_interno(String targa){
		    for (int i = 0; i < parco_auto.size(); ++i) {
			      String targaTrovata = parco_auto.get(i).getTarga();
			      if (targaTrovata.equals(targa)) {
			        return i;
			      }
			}
			return -1;
		}
		
		// Metodo per la ricerca dei mezzi da Revisionare
		public GestioneAutomezzi revisione(int anno_corr) {
			
			GestioneAutomezzi gestione_auto = new GestioneAutomezzi();
			
			for(int i = 0; i < parco_auto.size(); i++) {
				int anno_i = parco_auto.get(i).getAnno_im();
				int anno_r = parco_auto.get(i).getAnno_re();
				
				if((anno_r == anno_i) && ((anno_r +4) == anno_corr)){
					gestione_auto.aggiungi_auto(parco_auto.get(i));
				} else if((anno_r +2) == anno_corr) {
					gestione_auto.aggiungi_auto(parco_auto.get(i));
				}
			}
			
			return gestione_auto; 
		}
		
		// Overload dei GETTER e SETTER per la classe GestioneAutomezzi
		public ArrayList<Automezzo> getParco_auto() {
			return parco_auto;
		}

		public void setParco_auto(ArrayList<Automezzo> parco_auto) {
			this.parco_auto = parco_auto;
		}

		public int getNum_veicoli() {
			return num_veicoli;
		}

		public void setNum_veicoli(int num_veicoli) {
			this.num_veicoli = num_veicoli;
		}

		public int getPos_corrente() {
			return pos_corrente;
		}

		public void setPos_corrente(int pos_corrente) {
			this.pos_corrente = pos_corrente;
		}

		private ArrayList<Automezzo> parco_auto;
		private int num_veicoli;
		private int pos_corrente;
}

