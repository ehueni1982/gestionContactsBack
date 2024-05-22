package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class ContactRestService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	//Rechercher tous les contacts
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
//Rechercher un contact
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Optional<Contact> getContact(@PathVariable Long id){
		return contactRepository.findById(id);
	}
	
	//Ajouter un contact
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact contact){
		return contactRepository.save(contact);
	}
	
	//Supprimer un contact
	@RequestMapping(value="/contact/{id}", method=RequestMethod.DELETE)
	public boolean supprimerContact(@PathVariable Long id){
		contactRepository.deleteById(id);
		return true;
	}
	
	//Mise à jour 
	@RequestMapping(value="/contacter/{id}", method=RequestMethod.PUT)
	public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact){
		contact.setId(id);
		return contactRepository.save(contact);
	}
	
	
		
	//Chercher Contact
	
	@RequestMapping(value="/cherchercontact", method=RequestMethod.GET)
	public Page<Contact> chercher(
			@RequestParam( name="mc", defaultValue="")String mc,
			@RequestParam(name="page", defaultValue = "0")int page,
			@RequestParam(name="size", defaultValue = "5")int size){
		 
		
		return contactRepository.chercher ("%"+mc+"%", PageRequest.of(page, size));
	}
	
	

}
