package com.vdv.NExTone.questionbank;

import com.vdv.NExTone.questionbank.model.Option;
import com.vdv.NExTone.questionbank.model.Question;
import com.vdv.NExTone.questionbank.model.QuestionBank;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionBankExcelProcessor implements QuestionBankFileProcessor {

    private final static int NUMBER_OF_OPTIONS = 4;
    @Override
    public QuestionBank processQuestionBankFile(MultipartFile file) throws IOException {
        System.out.println("QuestionBankExcelProcessor");
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        List<Question> questions = new ArrayList<>();
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            int columnNum = 0;
            Row row = sheet.getRow(i);
            Integer questionNumber = getQuestionNumber(row.getCell(columnNum++));
            String questionText = getQuestion(row.getCell(columnNum++));
            List<Option> options = new ArrayList<>();
            for (int j = columnNum; j < columnNum + NUMBER_OF_OPTIONS; j++) {
                options.add(getOption(row.getCell(j)));
            }
            columnNum +=NUMBER_OF_OPTIONS;
            Option correctOption = getCorrectOption(row.getCell(columnNum++), options);
            int optionCounter = 0;
            for (int j = columnNum; j < columnNum + NUMBER_OF_OPTIONS; j++) {
                options.get(optionCounter).setComment(getOptionComment(row.getCell(j)));
                optionCounter++;
            }
            questions.add(new Question(
                    null,
                    questionNumber,
                    questionText,
                    options,
                    correctOption
            ));
        }
        return new QuestionBank(questions);
    }

    private String getOptionComment(Cell cell) {
        return cell.getStringCellValue();
    }

    private Option getCorrectOption(Cell cell, List<Option> options) {
        int optionNumber = (int) cell.getNumericCellValue();
        return options.get(optionNumber - 1);
    }

    private Option getOption(Cell cell) {
        String optionText = cell.getStringCellValue();
        return new Option(null, optionText);
    }

    private String getQuestion(Cell cell) {
        return cell.getStringCellValue();
    }

    private Integer getQuestionNumber(Cell cell) {
        return (int) cell.getNumericCellValue();
    }


}
