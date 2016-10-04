package Facebook;

import java.util.*;

public class Utente {
	
	//ATTRIBUTI
	private String nome;
	private String cognome;
	private int età;
	private char sesso;
	private String email;
	private List<Utente> amici= new ArrayList<Utente>();//LISTA AMICI PER OGNI UTENTE
	
	//COSTRUTTORE VUOTO
	public Utente() {
	}
	
	//COSTRUTTORE
	public Utente(String nome, String cognome, int età, char sesso, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.età = età;
		this.sesso = sesso;
		this.email = email;
	}

	//METODI GET E SET PER OGNI ATTRIBUTO
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public char getSesso() {
		return sesso;
	}
	
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}
	
	public int getEtà() {
		return età;
	}
	
	public void setEtà(int età) {
		this.età = età;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Utente> getAmici() {
		return amici;
	}
	
	public void setAmici(List<Utente> amici) {
		this.amici = amici;
	}
	
	//AGGIUNGE UN AMICO ALLA PROPRIA LISTA AMICI
	public void aggiungiAmico(Utente u){
		if(amici.contains(u) == false){
			amici.add(u);
		}
	}
	
	//METODO TOSTRING 
	public String toString(){
		String str = "";
		str = nome+" "+cognome+" "+età+" "+sesso+" "+email+" ";
		return str;
	} 
}
