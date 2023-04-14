package com.tpsoares.guiafinanceiro.api.user;

import com.tpsoares.guiafinanceiro.api.enums.ErrorCodes;
import com.tpsoares.guiafinanceiro.api.enums.ErrorMessages;
import com.tpsoares.guiafinanceiro.api.exceptions.UserNotFoundException;
import com.tpsoares.guiafinanceiro.api.transaction.Transaction;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionInputDto;
import com.tpsoares.guiafinanceiro.core.Result;
import com.tpsoares.guiafinanceiro.utils.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Result<Transaction.TransactionBuilder, Exception> getUser(Transaction.TransactionBuilder transactionBuilder, TransactionInputDto transactionInputDto) {
        try {
            User user = null;

            if (transactionInputDto.getUserId() != null) {
                Optional<User> userOptional = userRepository.findById(transactionInputDto.getUserId());

                if (userOptional.isPresent()) {
                    user = userOptional.get();
                } else {
                    return Result.error(new UserNotFoundException());
                }
            }

            transactionBuilder.user(user);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(e);
        }
    }
}
