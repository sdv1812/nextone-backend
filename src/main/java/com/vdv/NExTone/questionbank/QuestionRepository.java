package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.questionbank.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, Long> {

}
