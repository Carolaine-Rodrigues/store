package br.com.produts.store.domain.service;

import br.com.produts.store.domain.dto.UserDTO;
import br.com.produts.store.domain.entity.User;
import br.com.produts.store.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    // cadastro de usuario
    public User saveUser(UserDTO data){

        var userData = new User(data);
        userRepository.save(userData);
        return userData;
    }

    // atualizção de usuários
    @Transactional
    public Optional<User> updateUser(Long id, UserDTO update) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User updateUser = optionalUser.get();
            if (updateUser.getName() != null) {
               updateUser.setName(update.getName());
            }
            if(updateUser.getEmail()!=null){
                updateUser.setEmail(update.getEmail());
            }
            if(updateUser.getPassword()!=null){
                updateUser.setPassword(update.getPassword());
            }
            userRepository.save(updateUser);
            return Optional.of(updateUser);

        } else {
            throw new EntityNotFoundException();
        }

    }
    //lista todos
    public List<User> listAllUsers(){
        List<User> list = userRepository.findAll();
        return list;
    }

    // lista por id
    public User listUserId(Long id){
        var user = userRepository.findById(id).get();
        return user;
    }

    // deleta por id
    public void deleteId(Long id){
        Optional<User> deleteUser = userRepository.findById(id);
        if(deleteUser.isPresent()){
            User user = deleteUser.get();
            userRepository.delete(user);
        }else {
            throw new EntityNotFoundException();
        }
    }
}