package main;

import util.InputUtil;
import util.MenuUtil;

public class Main {

    public static void main(String[] args) {
        int menu = 0;

        while (true ) {
             menu = InputUtil.requireNumber("What do you want to do? " +
                    "\n 1.Register student" +
                    "\n 2.Show all students " +
                    "\n 3.Find student " +
                    "\n 4.Update student " +
                    "\n5.Exit. ");
            MenuUtil.processMenu(menu);
        }
    }
}
