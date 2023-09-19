package kz.bitlab.G114ajax.controller;

import kz.bitlab.G114ajax.models.Academy;
import kz.bitlab.G114ajax.repository.AcademyRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    private AcademyRepository academyRepository;

    @GetMapping("/")
    public String homePage()
    {
        List<Academy> academies = academyRepository.findAll();
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet 1");
            int i = 0;
            for (Academy academy : academies) {
                Row headerRow = sheet.createRow(i);
                Cell headerCell = headerRow.createCell(0);
                Cell h = headerRow.createCell(1);
                headerCell.setCellValue(academy.getName());
                h.setCellValue(academy.getRating());
                i++;
            }
            try (FileOutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "home";
    }
}
