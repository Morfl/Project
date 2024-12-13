package Functions;

import Enums.StudyProfile;
import Entity.Student;
import Entity.University;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileReader {

    private static FileInputStream fileInputStream;
    private static XSSFWorkbook workbook;
    private static Sheet sheet;
    private static Iterator<Row> iteratorRow;
    private static Iterator<Cell> iteratorCell;

    private static Row row;
    private static Cell cell;


    static {
        try {
            fileInputStream = new FileInputStream("src\\main\\resources\\universityInfo.xlsx");
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            System.out.println("Отсутствует исходный файл");
            throw new RuntimeException(e);
        }
    }


    private FileReader() {

    }

    public static ArrayList<Student> readStudent() {

        ArrayList<Student> result = new ArrayList<>();
        ArrayList<Object> info = new ArrayList<>();

        sheet = workbook.getSheet("Студенты");
        iteratorRow = sheet.iterator();
        iteratorRow.next();
        while (iteratorRow.hasNext()) {
            row = iteratorRow.next();
            iteratorCell = row.cellIterator();
            while (iteratorCell.hasNext()) {
                cell = (iteratorCell.next());
                try {
                    info.add(cell.getStringCellValue());
                } catch (IllegalStateException e) {
                    info.add(cell.getNumericCellValue());
                }
            }
            Student student = new Student(
                    (String) info.get(1),
                    (String) info.get(0),
                    Integer.parseInt(String.valueOf(info.get(2).toString().charAt(0))),
                    Float.parseFloat(String.valueOf(info.get(3).toString())));

            result.add(student);
            info.clear();
        }
        return result;
    }

    public static ArrayList<University> readUniversity() {

        ArrayList<University> result = new ArrayList<>();
        ArrayList<Object> info = new ArrayList<>();

        sheet = workbook.getSheet("Университеты");
        iteratorRow = sheet.iterator();
        iteratorRow.next();
        while (iteratorRow.hasNext()) {
            row = iteratorRow.next();
            iteratorCell = row.cellIterator();
            while (iteratorCell.hasNext()) {
                cell = (iteratorCell.next());
                try {
                    info.add(cell.getStringCellValue());
                } catch (IllegalStateException e) {
                    info.add(cell.getNumericCellValue());
                }
            }
            University university = new University(
                    (String) info.get(0),
                    (String) info.get(1),
                    (String) info.get(2),
                    Integer.parseInt(info.get(3).toString().substring(0,4)),
                    StudyProfile.valueOf(String.valueOf(info.get(4)))
                    );

            result.add(university);
            info.clear();
        }
        return result;
    }
}
