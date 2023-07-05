package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.exception.InvalidFileException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/questionbank")
public class QuestionBankController {

    private static final String XLSX_FORMAT = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final String CSV_FORMAT = "text/csv";
    private static final List<String> ALLOWED_CONTENT_TYPES = List.of(XLSX_FORMAT, CSV_FORMAT);

    private final QuestionBankFileProcessor questionBankExcelProcessor;

    private final QuestionBankFileProcessor questionBankCsvProcessor;
    public QuestionBankController(QuestionBankExcelProcessor questionBankExcelProcessor, QuestionBankCsvProcessor questionBankCsvProcessor) {
        this.questionBankExcelProcessor = questionBankExcelProcessor;
        this.questionBankCsvProcessor = questionBankCsvProcessor;
    }

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> processQuestionnaire(@RequestParam("file") MultipartFile file) {
        checkFileValidity(file);
        String fileType = file.getContentType();
        if (XLSX_FORMAT.equals(fileType))
            questionBankExcelProcessor.processQuestionBankFile(file);
        else
            questionBankCsvProcessor.processQuestionBankFile(file);
        return ResponseEntity.ok("File uploaded and processed successfully");
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
