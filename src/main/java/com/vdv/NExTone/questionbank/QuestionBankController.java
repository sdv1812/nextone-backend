package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.exception.InvalidFileException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/questionbank")
public class QuestionBankController {

    private static final List<String> ALLOWED_CONTENT_TYPES = List.of("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "text/csv");

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> processQuestionnaire(@RequestParam("file") MultipartFile file) {
        checkFileValidity(file);

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
