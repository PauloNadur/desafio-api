package gft.filter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Teste {

	public static void main(String[] args) {
		
		String senha = "Gft@0000";
		String senhaTeste = new BCryptPasswordEncoder().encode(senha);
		System.out.println(senhaTeste);
		
	}
}
