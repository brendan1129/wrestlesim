package com.bnh.wrestlim.repositories;

import com.bnh.wrestlim.models.Wrestler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrestlerRepository extends MongoRepository<Wrestler, String> {
}
