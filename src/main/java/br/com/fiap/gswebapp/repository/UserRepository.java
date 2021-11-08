package br.com.fiap.gswebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.gswebapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
