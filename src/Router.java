import Controller.InstructionsController;
import javax.swing.*;


public class Router {
    JFrame frame;

    public Router(){
        frame = new JFrame();
    }

    public void Router(){
        InstructionsController.get(frame);
    }

    public enum RouteTable{
        BALLOT,
        AUTHENTICATION,
        INSTRUCTIONS,
        REGISTER,
        VOTE
    }



}
