package br.com.ctfera.course.services;

import br.com.ctfera.course.entities.User;
import br.com.ctfera.course.repositories.UserRepository;
import br.com.ctfera.course.services.exceptions.DatabaseException;
import br.com.ctfera.course.services.exceptions.ResourceNotFoundException;
import ch.qos.logback.core.LogbackException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Registrando class como component service do Spring
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll(); //Usando o userRepository para retornar dados do banco
   }

   public User findById(Long id){
       Optional<User> obj = userRepository.findById(id);

       //return obj.get();
       //Return agora usará lançamento de exceção personalizada, usando exp. lambda na cláusula orElseThrow()
       return obj.orElseThrow(() -> new ResourceNotFoundException(id));
   }

   public User insert(User obj){
        return userRepository.save(obj);
   }

   public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        try{
            userRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
           throw new DatabaseException(e.getMessage());
        }
   }

   public User update(Long id, User obj){
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
   }

   //método auxiliar para atualizar o objeto User
   private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
   }
}
