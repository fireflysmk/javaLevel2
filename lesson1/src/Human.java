public class Human implements Jumpable, Runnable {

    private int maxRunDistance = 500;
    private int maxJumpDistance = 3;

    public int getMaxRunDistance() {
        return this.maxRunDistance;
    }

    public int getMaxJumpDistance() {
        return this.maxJumpDistance;
    }

    public void jump() {
        System.out.println("Human is jumping");
    }

    public void run() {
        System.out.println("Human is running");
    }
}
