package lv.javaguru.java2.views;

public class ProgramExitView implements View {
    @Override
    public void execute() {
        System.out.println("Good by!");
        System.exit(0);
    }
}
