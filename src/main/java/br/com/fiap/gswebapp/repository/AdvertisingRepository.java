package br.com.fiap.gswebapp.repository;

import br.com.fiap.gswebapp.model.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.gswebapp.model.Advertising;

import java.util.List;

public interface AdvertisingRepository extends JpaRepository<Advertising, Long>{
    public List<Advertising> findAllByStatus(StatusEnum status);
}
