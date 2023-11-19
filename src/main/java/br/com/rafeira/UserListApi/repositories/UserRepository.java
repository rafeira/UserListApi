package br.com.rafeira.UserListApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafeira.UserListApi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
