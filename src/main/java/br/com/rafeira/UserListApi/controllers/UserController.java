package br.com.rafeira.UserListApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafeira.UserListApi.models.User;
import br.com.rafeira.UserListApi.services.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
  }

  @PostMapping
  public ResponseEntity<User> create(@RequestBody User user) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
  }

  @PutMapping
  public ResponseEntity<User> update(@RequestBody User user) {
    return ResponseEntity.status(HttpStatus.OK).body(userService.update(user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    userService.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
