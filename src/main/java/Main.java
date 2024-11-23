public class Main {
    public static void main(String[] args) {
        for (Student s : FileReader.readStudent()) {
            System.out.println(s);
        }
        for (University u : FileReader.readUniversity()) {
            System.out.println(u);
        }
    }
}
