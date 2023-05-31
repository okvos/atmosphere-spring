package com.okvos.atmosphere.data.user.repository;

import com.okvos.atmosphere.data.user.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
