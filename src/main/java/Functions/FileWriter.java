package Functions;

import Entity.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriter {

    private static final Logger fileWriterLogger = Logger.getLogger(FileWriter.class.getName());

    public static void writeStatistics(List<Statistics> statistics, String path) {
        try {
            Workbook workbook = new XSSFWorkbook();
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            Sheet sheet = workbook.createSheet("Statistics");
            sheet.setColumnWidth(0, 14 * 256);
            sheet.setColumnWidth(1, 19 * 256);
            sheet.setColumnWidth(2, 33 * 256);
            sheet.setColumnWidth(3, 38 * 256);
            sheet.setColumnWidth(4, 21 * 256);
            Font font = workbook.createFont();
            font.setFontName("New Times Roman");
            font.setBold(true);
            font.setFontHeightInPoints((short) 14);
            CellStyle style = workbook.createCellStyle();
            style.setFont(font);

            Row row = sheet.createRow(1);

            Cell profileCell = row.createCell(0);
            profileCell.setCellValue("Профиль");
            profileCell.setCellStyle(style);
            Cell avgExamScoreCell = row.createCell(1);
            avgExamScoreCell.setCellValue("Средний бал");
            avgExamScoreCell.setCellStyle(style);
            Cell countStudentsCell = row.createCell(2);
            countStudentsCell.setCellValue("Количество студентов");
            countStudentsCell.setCellStyle(style);
            Cell countUniversityCell = row.createCell(3);
            countUniversityCell.setCellValue("Количество университетов");
            countUniversityCell.setCellStyle(style);
            Cell nameUniversityCell = row.createCell(4);
            nameUniversityCell.setCellValue("Университеты");
            nameUniversityCell.setCellStyle(style);

            int i = 2;

            for (Statistics stat : statistics) {
                Row rowData = sheet.createRow(i++);
                Cell profileCellData = rowData.createCell(0);
                profileCellData.setCellValue(stat.getStudyProfile().getProfileName());
                Cell avgExamScoreData = rowData.createCell(1);
                avgExamScoreData.setCellValue(stat.getAvgExamScore());
                Cell countStudentsData = rowData.createCell(2);
                countStudentsData.setCellValue(stat.getCountStudents());
                Cell countUniversityData = rowData.createCell(3);
                countUniversityData.setCellValue(stat.getCountUniversity());
                Cell nameUniversityData = rowData.createCell(4);
                nameUniversityData.setCellValue(stat.getNameUniversity());
            }

            workbook.write(fileOutputStream);
            fileWriterLogger.log(Level.INFO, "Статистика записана");
        } catch (IOException e) {
            fileWriterLogger.log(Level.SEVERE, "Ошибка при записи статистики, не найден путь записи");
            e.printStackTrace();
        }


    }

}
