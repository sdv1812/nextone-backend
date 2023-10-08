package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.exception.EntityNotFoundException;
import com.vdv.NExTone.questionbank.model.Question;
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

    public QuestionBank getQuestionBank() {
        return new QuestionBank(questionRepository.findAll());
    }

    public Question getQuestion(String questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("questionId not found:  %s".formatted(questionId)));
    }

    public Question getQuestionByNumber(Integer questionNumber) {
        return questionRepository
                .findByQuestionNumber(questionNumber)
                .flatMap(questions -> questions.stream().findFirst())
                .orElseThrow(() -> new EntityNotFoundException("QuestionNumber not found:  %d".formatted(questionNumber)));

    }
}
