package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionContactsApplication implements CommandLineRunner {
	
	//Test de l'interface
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Insertion enregistrements
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("ANGORA","Barth", df.parse("12/01/1998"), "ehueni@gmail.com", 064523, "aping1.jpg"));
		contactRepository.save(new Contact("ANGORA","Barth", df.parse("12/01/1998"), "ehueni@gmail.com", 064523, "aping1.jpg"));
		contactRepository.save(new Contact("ANGORA","Bob", df.parse("12/01/1999"), "ehueni34@gmail.com", 066567, "aping5.jpg"));
		contactRepository.save(new Contact("ANGORA","BarthE", df.parse("12/01/1997"), "ehueni@gmail.com", 061234, "aping4.jpg"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}

}
