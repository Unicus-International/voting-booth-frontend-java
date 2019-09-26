package Controller;

import View.InstructionView;

import javax.swing.*;

public class InstructionsController {


    public static void get(JFrame frame) {

        InstructionView view = new InstructionView(frame);
        view.render();


    }
}
