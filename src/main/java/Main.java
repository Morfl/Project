public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Василий","2",3,3.5f);
        Student student2 = new Student("Иван","1",1,4.2f);
        Student student3 = new Student("Евгений","1",4,2.5f);
        Student student4 = new Student("Игорь","2",2,3.8f);
        Student student5 = new Student("Дмитрий","2",1,4.7f);
        University university1 = new University("1","Государственный университет", "ГУ", 2000, StudyProfile.PROGRAMMING);
        University university2 = new University("2","Частный университет", "ЧУ", 2022, StudyProfile.MEDICINE);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(university1);
        System.out.println(university2);
    }
}
