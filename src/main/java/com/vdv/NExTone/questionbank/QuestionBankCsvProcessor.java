package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.questionbank.model.QuestionBank;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class QuestionBankCsvProcessor implements QuestionBankFileProcessor {
    @Override
    public QuestionBank processQuestionBankFile(MultipartFile file) {
        System.out.println("QuestionBankCsvProcessor");
        throw new RuntimeException("Not implemented yet");
//        return null;
    }
}
