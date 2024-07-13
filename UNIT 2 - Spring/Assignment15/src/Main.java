import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ---------------------- Dependency Inversion ------------------------
        Teacher mathsTeacher = new MathsTeacher("Mathematics");
        Teacher physicsTeacher = new PhysicsTeacher("Physics");

        List<Teacher> teachersList = new ArrayList<>();

        teachersList.add(mathsTeacher);
        teachersList.add(physicsTeacher);

        College lpu = new LPU(teachersList);
        lpu.getAllSubjects();
    }

}