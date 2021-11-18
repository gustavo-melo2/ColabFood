package br.com.fiap.gswebapp.repository;

import br.com.fiap.gswebapp.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long>{
}
