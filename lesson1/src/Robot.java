public class Robot implements Jumpable, Runnable {

    private int maxRunDistance = 1000;
    private int maxJumpDistance = 12;


    public int getMaxRunDistance() {
        return this.maxRunDistance;
    }

    public int getMaxJumpDistance() {
        return this.maxJumpDistance;
    }

    public void jump() {
        System.out.println("Robot is jumping");
    }

    public void run() {
        System.out.println("Robot is running");
    }
}
