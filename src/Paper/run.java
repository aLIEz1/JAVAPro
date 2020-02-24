package Paper;

public class run {

    public static void main(String[] args) {
        Application A=new Application();
        A.input();
        A.show(A.getAverage(),A.getMaxMin(),A.selectScore());
    }
}