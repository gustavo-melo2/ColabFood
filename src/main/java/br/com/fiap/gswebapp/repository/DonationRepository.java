package br.com.fiap.gswebapp.repository;

import br.com.fiap.gswebapp.model.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.gswebapp.model.Donation;

import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation, Long>{
    public Optional<Donation> findDonationByAdvertising_Id(Long advertising_id);
}
