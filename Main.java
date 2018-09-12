package autonoleggio;

import java.util.*;

public class Main {
	
	private static GestioneAutomezzi parco_auto; 
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Programma per la gestione del parco auto");
		parco_auto = new GestioneAutomezzi();
		
		boolean doThing = true;
		
		while(doThing) {
			
			System.out.println("Scegli l'opzione\n"
					+ "1 - Nuovo Veicolo\n"
					+ "2 - Aggiunta N automezzi\n"
					+ "3 - Rimuovi Veicolo (Per Dismissione)\n"
					+ "4 - Cerca Veicolo per Targa\n"
					+ "5 - Cerca Veicolo da Revisionare\n"
					+ "6 - Stampa di tutti i Modelli di Veicolo\n"
					+ "0 - Termina");
			System.out.print("Opzione: ");
			
			int opzione = in.nextInt();
			in.nextLine();
			
			switch(opzione) {
				case 1:{

					System.out.println("Nuovo automezzo");
					
					System.out.print("Marca: ");
					String marca = in.nextLine();
					
					System.out.print("Modello: ");
					String modello = in.nextLine();
					
					System.out.print("Targa: ");
					String targa = in.nextLine();
					targa = targa.toUpperCase();
					
					while(!targa.matches("[a-zA-Z][a-zA-Z][0-9][0-9][0-9][a-zA-Z][a-zA-Z]")) {
						System.out.println("Targa non conforme; prego inserire nuovamente\nTarga: "); 
						targa = in.nextLine();
					}
					
					System.out.print("Anno di immatricolazione: ");
					int immatricolazione = in.nextInt();
					in.nextLine();
					
					Automezzo automezzo = new Automezzo(marca, modello, targa, immatricolazione, immatricolazione);
					boolean aggiunto = parco_auto.aggiungi_auto(automezzo);
					
					if (aggiunto) {
					      	System.out.println("Inserimento effettuato!");
					} else {
					    	System.out.println("Capacit� del parco auto esaurita!");
					}
				}
					break;
					
				case 2:{
					
					System.out.println("Inserire il numero di autoveicoli che si vogliono inserire\n"
							+ "Numero: ");
					
					int n = in.nextInt();
					in.nextLine();
					
					for(int i = 0; i < n; i++) {
						System.out.println("Nuovo automezzo");
						
						System.out.print("Marca: ");
						String marca = in.nextLine();
						
						System.out.print("Modello: ");
						String modello = in.nextLine();
						
						System.out.print("Targa: ");
						String targa = in.nextLine();
						
						targa = targa.toUpperCase();
						
						while(!targa.matches("[a-zA-Z][a-zA-Z][0-9][0-9][0-9][a-zA-Z][a-zA-Z]")) {
							System.out.println("Targa non conforme; prego inserire nuovamente\nTarga: "); 
							targa = in.nextLine();
						}
						
						System.out.print("Anno di immatricolazione: ");
						int immatricolazione = in.nextInt();
						in.nextLine();
						
						Automezzo automezzo = new Automezzo(marca, modello, targa, immatricolazione, immatricolazione);
						boolean aggiunto = parco_auto.aggiungi_auto(automezzo);
						
						if (aggiunto) {
						      	System.out.println("Inserimento effettuato!");
						} else {
						    	System.out.println("Capacit� del parco auto esaurita!");
						}
					}
				}
					break;
					
				case 3:{
					
					System.out.print("Targa dell'automezzo da rimuovere: ");
					String elimina_targa = in.nextLine();
					
					elimina_targa = elimina_targa.toUpperCase();

					while(!elimina_targa.matches("[a-zA-Z][a-zA-Z][0-9][0-9][0-9][a-zA-Z][a-zA-Z]")) {
						System.out.println("Targa non conforme; prego inserire nuovamente\nTarga: "); 
						elimina_targa = in.nextLine();
					}
					
					boolean eliminato = parco_auto.elimina_auto(elimina_targa);
					
					if (eliminato) {
				      	System.out.println("Eliminazione effettuata!");
					} else {
				    	System.out.println("Automezzo non presente nel parco auto!");
					}
				}
					break;
					
				case 4:{
					System.out.println("Inserire la targa del veicolo da cercare\nTarga: ");
					String targa =  in.nextLine();

					targa = targa.toUpperCase();
					
					while(!targa.matches("[a-zA-Z][a-zA-Z][0-9][0-9][0-9][a-zA-Z][a-zA-Z]")) {
						System.out.println("Targa non conforme; prego inserire nuovamente\nTarga: "); 
						targa = in.nextLine();
					}
					
					Automezzo veicolo = parco_auto.cerca_per_targa(targa);
					
					if(veicolo != null) {
						System.out.println("Veicolo trovato");
						System.out.println(	"Marca: " +veicolo.getMarca()+ "\n"+
											"Modello: " +veicolo.getModello()+ "\n"+
											"Anno di Immatricolazione: " +veicolo.getAnno_im()+ "\n");
					}else {
						System.out.println("Veicolo con tale targa non trovato");
					}
				}
					break;
					
				case 5:{
					
					System.out.println("Inserire l'anno corrente");
					System.out.print("Anno: ");
					int anno = in.nextInt();
					in.nextLine();
					
					GestioneAutomezzi revisione = parco_auto.revisione(anno);
					
					if(revisione.getNum_veicoli() > 0) {
						ArrayList <Automezzo> veicolo = revisione.getParco_auto();
						for(int i = 0; i < revisione.getNum_veicoli(); i++) {
							System.out.println("Veicolo trovato");
							System.out.println(	"Marca: " +veicolo.get(i).getMarca()+ "\n"+
												"Modello: " +veicolo.get(i).getModello()+ "\n"+
												"Anno di Immatricolazione: " +veicolo.get(i).getAnno_im()+ "\n");
						}
						
					}else {
						System.out.println("Nessun veicolo da revisionare nell'anno corrente");
					}
				}
					break;
					
				case 6:{
					System.out.println("Elenco modelli");
					
					ArrayList <Automezzo> veicolo = parco_auto.getParco_auto();

					Set<String> modello = new HashSet<String>();
									
					
					for (int i = 0; i < veicolo.size(); i++) {
						modello.add(veicolo.get(i).getModello());
					}
					
					System.out.println(modello);
					
				}
					break;
					
				case 0:{
					doThing = false;
				}
					break;

				default:{
					System.out.println("Opzione non riconosciuta!");
				}
			}
		
		}
		in.close();
		System.exit(0);
	}
}
