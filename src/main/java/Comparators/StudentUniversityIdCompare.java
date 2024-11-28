package Comparators;

import models.Student;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

public class StudentUniversityIdCompare implements StudentComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(),o2.getUniversityId());
    }
}
