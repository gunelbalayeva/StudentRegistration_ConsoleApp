package util;

import main.Config;
import bean.Student;
public class StudentUtil {

    public static Student fillStudent() {
        String name = InputUtil.requreText("Enter name ");
        String surname = InputUtil.requreText("Enter surname ");
        String className = InputUtil.requreText("Enter classname ");
        int age = InputUtil.requireNumber("Enter age ");

        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            System.out.println((i + 1) + "." + st.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("How many students will you enroll? ");
        Config.students = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1 + ".Register "));
            Config.students[i] = StudentUtil.fillStudent();
            System.out.println("Registration completed successfully ");
        }
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requreText("Type name, surname or class name ");
        Student[] result = findStudent(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getFullInfo());
        }
    }

    public static Student[] findStudent(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }
        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found] = st;
                found++;
            }
        }
        return result;
    }

    public static void updateStudentWithNewObjekt() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("What person do you want to change? ");

        System.out.println("Enter new information: ");
        Student s = StudentUtil.fillStudent();

        Config.students[i - 1] = s;
    }

    public static void updateStudentWithSameObject() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("What person do you want to change? ");

        System.out.println("Enter new information: ");

        Student selectedStudent = Config.students[i - 1];
        String changeParams = InputUtil.requreText("/ What would you like to change :'name', 'surname', 'age'");


        if (changeParams.contains("'name'")) {
            selectedStudent.setName(InputUtil.requreText("name"));
        }
        if (changeParams.contains("'surname'")) {
            selectedStudent.setSurname(InputUtil.requreText("surname"));
        }
        if (changeParams.contains("'age'")) {
            selectedStudent.setAge(InputUtil.requireNumber("'age'"));
        }
        if (changeParams.contains("'classname'")) {
            selectedStudent.setClassName(InputUtil.requreText("class name"));
        }
    }

    public static void updateStudentWithSplite() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("What person do you want to change? ");

        System.out.println("Enter new information: ");

        Student selectedStudent = Config.students[i - 1];
        String changeParams = InputUtil.requreText("/ What would you like to change :'name', 'surname', 'age'");

        String[] parametrs = changeParams.split(",");
        for (int in = 0; in < parametrs.length; i++) {
            String param = parametrs[i];
            if (param.equalsIgnoreCase("name")) selectedStudent.setName(InputUtil.requreText("name"));
            else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(InputUtil.requreText("surname"));
            } else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(InputUtil.requireNumber("age"));

            } else if (param.equalsIgnoreCase("classname")) {
                selectedStudent.setClassName(InputUtil.requreText("class name"));
                break;


            }
        }
    }
}
