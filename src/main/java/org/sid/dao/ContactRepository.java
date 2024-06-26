package org.sid.dao;

import org.sid.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ContactRepository  extends JpaRepository<Contact, Long>{
	
	//Chercher contact
	@Query("select contact from Contact contact where contact.nom like :X")
	public Page<Contact> chercher(@Param("X") String mc, Pageable pageable);
	
	
}
