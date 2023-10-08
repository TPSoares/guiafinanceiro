package com.tpsoares.guiafinanceiro.usecase;

import com.tpsoares.guiafinanceiro.mapper.UserMapper;
import com.tpsoares.guiafinanceiro.repository.UserRepository;
import com.tpsoares.guiafinanceiro.exceptions.UserNotFoundException;
import com.tpsoares.guiafinanceiro.api.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserUseCase {

    private final UserRepository userRepository;

    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUser(Long userId) {
        return userRepository.findById(userId)
            .map(UserMapper::toDomain)
            .orElseThrow(UserNotFoundException::new);
    }
}
