package Prototype;

public class Client {
    public static void fillRegistry(StudentRegistry studentRegistry) {
        Student apr21BatchStudent = new Student();
        apr21BatchStudent.setName("Apr21 Batch Student");
        apr21BatchStudent.setPsp(100.0);

        Student apr21Student1 = apr21BatchStudent.clone();
        apr21Student1.setName("Apr21 Student 1");

        System.out.println(apr21BatchStudent.name);
        System.out.println(apr21BatchStudent.psp);
        System.out.println(apr21Student1.name);
        System.out.println(apr21Student1.psp);

        IntelligentStudent s2 = new IntelligentStudent(apr21BatchStudent);
        s2.setIq(100);

        System.out.println(s2.name);
        System.out.println(s2.iq);

        studentRegistry.register("Apr21BatchStudent", apr21BatchStudent);
    }

    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegistry(studentRegistry);

        Student std = studentRegistry.get("Apr21BatchStudent");
    }

}
