package br.com.fiap.gswebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.gswebapp.model.Donation;
import br.com.fiap.gswebapp.model.DonationPK;

public interface DonationRepository extends JpaRepository<Donation, DonationPK>{

}
