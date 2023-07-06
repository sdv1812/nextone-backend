package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.questionbank.model.QuestionBank;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface QuestionBankFileProcessor {
    QuestionBank processQuestionBankFile(MultipartFile file) throws IOException;
}
