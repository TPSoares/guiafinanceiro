package com.tpsoares.guiafinanceiro.api.user;

import com.tpsoares.guiafinanceiro.api.exceptions.UserNotFoundException;
import com.tpsoares.guiafinanceiro.api.user.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserUseCase {

    private final UserRepository userRepository;

    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Long userId) {
        return UserMapper.toDomain(userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new));
    }
}
