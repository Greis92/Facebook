package Facebook;

import java.util.*;

public class Facebook {
	//ATTRIBUTO: LISTA UTENTI ISCRITTI A FACEBOOK
	private List<Utente> utenti = new ArrayList<Utente>();;
	
	//COSTRUTTORE VUOTO
	public Facebook() {
	}
	
	//METODI GET E SET
	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	/*METODO: CONTROLLA SE L'UTENTE NON E' PRESENTE IN FACEBOOK(VEDI METODO PRIVATE) 
	 * E SE LA STRINGA MAIL E' VALIDA
	 */
	public void registraUtente(String nome, String cognome, int età, char sesso, String email){
		Utente utente = ricercaUtente(nome,cognome,età,sesso,email);
		if(utente == null){
			if(email.contains("@")){ 
				Utente u = new Utente(nome,cognome,età,sesso,email);
				utenti.add(u);
			}
		}
	}
	
	private Utente ricercaUtente(String nome, String cognome, int età, char sesso, String email){
		Utente uTemp = null;
		for(Utente u : utenti){
			if(u.getNome().equals(nome) && u.getCognome().equals(cognome)
				&& u.getEtà() == età && u.getSesso() == sesso && u.getEmail().equals(email)){
				uTemp = u;
				break;
			}
		}
		return uTemp;
	}
	
	//METODO: PRENDE DUE UTENTI E AGGIUNGE L'UNO ALLA LISTA DI AMICI DELL'ALTRO
	public void aggiungiAmici(String NomeCognome1, String NomeCognome2){
		Utente u1 = null;
		Utente u2 = null;
			for (Utente u : utenti){
				String strTemp = u.getNome()+u.getCognome();
				if(NomeCognome1.equals(strTemp) == true){
					u1 = u;
				}
			}
			for (Utente u : utenti){
				String strTemp = u.getNome()+u.getCognome();
				if(NomeCognome2.equals(strTemp) == true){
					u2 = u;
				}
			}
		if(u1 != null && u2 != null){
			u1.aggiungiAmico(u2);
			u2.aggiungiAmico(u1);
		}
	}
	
	//METODO: CONTROLLA CHE L'UTENTE ESISTA E PRENDE LA LISTA DEI SUOI AMICI
	public List<Utente> getAmiciDiUnUtente(String Nome, String Cognome){
		List<Utente> list = null;
		for(Utente u : utenti){
			if (u.getNome().equals(Nome) && u.getCognome().equals(Cognome)){
				list = u.getAmici();
			}
		}
		if(list != null){
			return list;
		}
		return null;	
	}
	
	//METODO: CONTROLLA CHE L'UTENTE ESISTA E PRENDE GLI AMICI DEGLI AMICI
	public List<Utente> getAmiciDiAmici(String nome, String cognome){
		Utente uTemp = null;
		for(Utente u : utenti){
			if (u.getNome().equals(nome) && u.getCognome().equals(cognome)){
				uTemp = u;
			}
		}
		
		List<Utente> listaAmici = uTemp.getAmici();
		List<Utente> listTemp = new ArrayList<Utente>();
		
		for(Utente u : listaAmici){
			listTemp.add(u);
			List<Utente> listaAmiciDiAmici = u.getAmici();
			for(Utente uTmp : listaAmiciDiAmici){
				if(uTmp.getNome().equals(nome) == false && uTmp.getCognome().equals(cognome) == false && 
						listaAmici.contains(uTmp) == false){
					listTemp.add(uTmp);
				}
			}
		}
		return listTemp;
	}
		
}
	
	
	

