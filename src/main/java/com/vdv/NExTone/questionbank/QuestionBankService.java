package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.questionbank.model.QuestionBank;
import org.springframework.stereotype.Service;

@Service
public class QuestionBankService {

    private final QuestionRepository questionRepository;

    public QuestionBankService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionBank saveOrUpdateQuestionBank(QuestionBank questionBank) {
        return new QuestionBank(questionRepository.saveAll(questionBank.questions()));
    }
}
