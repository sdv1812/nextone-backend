package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.questionbank.model.QuestionBank;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class QuestionBankExcelProcessor implements QuestionBankFileProcessor {
    @Override
    public QuestionBank processQuestionBankFile(MultipartFile file) {
        System.out.println("QuestionBankExcelProcessor");
        return null;
    }
}
