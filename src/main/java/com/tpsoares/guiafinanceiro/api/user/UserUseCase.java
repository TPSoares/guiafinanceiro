package com.tpsoares.guiafinanceiro.api.user;

import com.tpsoares.guiafinanceiro.api.exceptions.UserNotFoundException;
import com.tpsoares.guiafinanceiro.api.user.dto.UserDto;
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
