package br.com.rafeira.UserListApi.services;

import java.util.List;
import java.util.Optional;

import br.com.rafeira.UserListApi.models.User;

public interface UserService {
  User save(User product);

  List<User> findAll();

  Optional<User> findById(Long id);

  User update(User product);

  void deleteById(Long id);
}
