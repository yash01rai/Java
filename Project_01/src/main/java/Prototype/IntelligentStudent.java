package Prototype;

public class IntelligentStudent extends Student{
    int iq;

    // creating intelligent student from other intelligent student
    IntelligentStudent(IntelligentStudent other) {
        super(other);
        this.iq = other.iq;
    }

    // creating intelligent student from other normal student
    IntelligentStudent(Student other) {
        super(other);
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public IntelligentStudent clone() {
        return new IntelligentStudent(this);
    }
}
