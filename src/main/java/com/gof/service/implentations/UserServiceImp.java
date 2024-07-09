package com.gof.service.implentations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gof.model.Address;
import com.gof.model.User;
import com.gof.repository.AddressRepository;
import com.gof.repository.UserRepository;
import com.gof.service.UserService;
import com.gof.service.ViaCepService;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public User saveUser(User user) {
        salvarClienteComCep(user);
        return user;
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user, Long id) {
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isPresent()) {
            salvarClienteComCep(user);
        }
        return null;
    }

    private void salvarClienteComCep(User cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getAddress().getCep();
        Address endereco = addressRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Address novoEndereco = viaCepService.consultarCep(cep);
            addressRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setAddress(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        userRepository.save(cliente);
    }

}
