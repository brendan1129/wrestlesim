package com.bnh.wrestlim.repositories;

import com.bnh.wrestlim.models.WrestlerImage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrestlerImageRepository extends MongoRepository<WrestlerImage, String> {
}
