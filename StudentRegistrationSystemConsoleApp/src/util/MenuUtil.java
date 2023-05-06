package util;

public class MenuUtil {

    public static void processMenu(int selectedMenu){

        switch (selectedMenu){
            case 1:
                StudentUtil.registerStudents();
             break;
            case 2:
                StudentUtil.printAllRegisteredStudents();
                break;
            case 3:
                StudentUtil.findStudentsAndPrint();
                break;
            case 4:
                StudentUtil.updateStudentWithNewObjekt();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }



    }


}
