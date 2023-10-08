package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.questionbank.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    Optional<List<Question>> findByQuestionNumber(Integer questionNumber);
}
