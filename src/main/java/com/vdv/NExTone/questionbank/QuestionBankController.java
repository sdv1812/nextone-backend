package com.vdv.NExTone.questionbank;

//import com.google.gson.Gson;
import com.vdv.NExTone.exception.InvalidFileException;
import com.vdv.NExTone.questionbank.model.Question;
import com.vdv.NExTone.questionbank.model.QuestionBank;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/questionbank")
public class QuestionBankController {

    private static final String XLSX_FORMAT = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final String CSV_FORMAT = "text/csv";
    private static final List<String> ALLOWED_CONTENT_TYPES = List.of(XLSX_FORMAT, CSV_FORMAT);

    private final QuestionBankFileProcessor questionBankExcelProcessor;

    private final QuestionBankFileProcessor questionBankCsvProcessor;

    private final QuestionBankService questionBankService;
    public QuestionBankController(QuestionBankExcelProcessor questionBankExcelProcessor, QuestionBankCsvProcessor questionBankCsvProcessor, QuestionBankService questionBankService) {
        this.questionBankExcelProcessor = questionBankExcelProcessor;
        this.questionBankCsvProcessor = questionBankCsvProcessor;
        this.questionBankService = questionBankService;
    }

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<QuestionBank> processQuestionnaire(@RequestParam("file") MultipartFile file) throws IOException {
        checkFileValidity(file);
        String fileType = file.getContentType();
        QuestionBank questionBank;
        if (XLSX_FORMAT.equals(fileType))
            questionBank = questionBankExcelProcessor.processQuestionBankFile(file);
        else
            questionBank = questionBankCsvProcessor.processQuestionBankFile(file);

//        System.out.println(new Gson().toJson(questionBank));
        QuestionBank savedQuestionBank = questionBankService.saveOrUpdateQuestionBank(questionBank);
        return ResponseEntity.ok(savedQuestionBank);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionBank> getQuestionBank() {
        return ResponseEntity.ok(questionBankService.getQuestionBank());
    }
    @GetMapping(value = "question/{questionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Question> getQuestion(@PathVariable("questionId") String questionId) {
        return ResponseEntity.ok(questionBankService.getQuestion(questionId));
    }

    @GetMapping(value = "question/number/{questionNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Question> getQuestionByNumber(@PathVariable("questionNumber") Integer questionNumber) {
        return ResponseEntity.ok(questionBankService.getQuestionByNumber(questionNumber));
    }

    private void checkFileValidity(MultipartFile file) {
        if (file.isEmpty()) {
            throw new InvalidFileException("No files were uploaded");
        }
        String fileType = file.getContentType();
        if (!ALLOWED_CONTENT_TYPES.contains(fileType)) {
            throw new InvalidFileException("Invalid file type. Allowed types: XLSX, CSV");
        }

    }
}
