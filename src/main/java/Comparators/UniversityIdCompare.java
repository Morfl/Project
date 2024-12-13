package Comparators;

import Entity.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityIdCompare implements UniversityComparator{

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getId(),o1.getId());
    }
}
