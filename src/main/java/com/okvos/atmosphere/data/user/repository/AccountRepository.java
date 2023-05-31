package com.okvos.atmosphere.data.user.repository;

import org.springframework.data.repository.CrudRepository;
import com.okvos.atmosphere.data.user.entity.Account;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface AccountRepository extends CrudRepository<Account, Integer> {
    Account findByUsername(String username);
}
