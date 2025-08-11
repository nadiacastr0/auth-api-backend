package com.example.api.services;

import com.example.api.entities.User;
import com.example.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User update(User user) {
        User userCurrent = repository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<User> userByEmail = repository.findByEmail(user.getEmail());
        if (userByEmail.isPresent() && !userByEmail.get().getId().equals(user.getId())) {
            throw new RuntimeException("Email already taken by another user");
        }

        Optional<User> userByCpf = repository.findByCpf(user.getCpf());
        if (userByCpf.isPresent() && !userByCpf.get().getId().equals(user.getId())) {
            throw new RuntimeException("CPF already registered by another user");
        }

        userCurrent.setEmail(user.getEmail());
        userCurrent.setName(user.getName());
        userCurrent.setCpf(user.getCpf());

        return repository.save(userCurrent);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
