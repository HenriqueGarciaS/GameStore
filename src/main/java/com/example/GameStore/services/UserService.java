package com.example.GameStore.services;

import com.example.GameStore.VOs.UserVO;
import com.example.GameStore.exceptions.ResourceNotFoundException;
import com.example.GameStore.models.User;
import com.example.GameStore.models.Wallet;
import com.example.GameStore.repositories.UserRepository;
import com.example.GameStore.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletRepository walletRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new ResourceNotFoundException("user not found");
        return user.get();
    }

    public User createUser(UserVO userVO){
        Wallet createdWallet = new Wallet(new BigDecimal("0.0"), 0L);
        walletRepository.save(createdWallet);
        User createdUser = new User(userVO.getFirstName(), userVO.getLastName(), userVO.getEmail(), userVO.getPassword(), createdWallet);
        userRepository.save(createdUser);
        return createdUser;
    }

}
