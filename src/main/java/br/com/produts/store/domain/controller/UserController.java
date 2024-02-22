package br.com.produts.store.domain.controller;

import br.com.produts.store.domain.dto.UserDTO;
import br.com.produts.store.domain.entity.User;
import br.com.produts.store.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    private final PasswordEncoder encoder;

    public UserController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserDTO data){
        data.setPassword(encoder.encode(data.getPassword()));
        var user = userService.saveUser(data);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<User>> listAllUsers(){
        var userLists = userService.listAllUsers();
        return ResponseEntity.ok().body(userLists);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<User> listId(@PathVariable Long id){
        var userList = userService.listUserId(id);
        return ResponseEntity.ok().body(userList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, UserDTO data){
        var update = userService.updateUser(id, data);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteId(@PathVariable Long id){
         userService.deleteId(id);
        return ResponseEntity.noContent().build();
    }
}
