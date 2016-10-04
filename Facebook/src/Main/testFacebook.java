package Main;

import Facebook.Facebook;
import Facebook.Utente;

public class testFacebook {

	public static void main(String[] args) {
		
		//CREO FACEBOOK
		Facebook f = new Facebook(); 
		
		//CREO GLI UTENTI
		Utente u1 = new Utente("Maria", "Pina", 18, 'f', "mariapina@alfa.com");
		Utente u2 = new Utente("Paolo", "Vini", 18, 'm', "paolovini@alfa.com");
		Utente u3 = new Utente("Enrico", "Boni", 28, 'm', "enricoboni@alfa.com");
		Utente u4 = new Utente("Enrica", "Bona", 28, 'f', "enricabona@alfa.com");
		Utente u5 = new Utente("Marco", "Bianchi", 28, 'm', "marcobianchi@alfa.com");
		
		//VERIFICO METODO REGISTRA UTENTE  OK!!!
		f.registraUtente("Maria", "Pina", 18, 'f', "mariapina@alfa.com");
		f.registraUtente("Paolo", "Vini", 18, 'm', "paolovini@alfa.com");
		f.registraUtente("Enrico", "Boni", 28, 'm', "enricoboni@alfa.com");
		f.registraUtente("Enrica", "Bona", 28, 'f', "enricabona@alfa.com");
		f.registraUtente("Marco", "Bianchi", 28, 'm', "marcobianchi@alfa.com");
		
		//STAMPO UTENTI FACEBOOK
		for(Utente u : f.getUtenti()){
			System.out.println(u.toString());
		}
		
		System.out.println();
		
		//VERFICA METODO AGGIUNGI AMICI
		f.aggiungiAmici(u1.getNome() + u1.getCognome(), u2.getNome() + u2.getCognome());
		f.aggiungiAmici(u3.getNome() + u3.getCognome(), u4.getNome() + u4.getCognome());
		f.aggiungiAmici(u1.getNome() + u1.getCognome(), u4.getNome() + u4.getCognome());
		f.aggiungiAmici(u1.getNome() + u1.getCognome(), u5.getNome() + u5.getCognome());
		f.aggiungiAmici(u2.getNome() + u2.getCognome(), u3.getNome() + u3.getCognome());
		
		//AMICI DI UN UTENTE
		System.out.println(f.getAmiciDiUnUtente("Maria","Pina")); // OK!!!
		
		System.out.println();
		
		//AMICI DI AMICI DI UN UTENTE
		System.out.println(f.getAmiciDiAmici("Marco","Bianchi")); // OK!!!
		

	}

}
