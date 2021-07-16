public class Cat implements Jumpable, Runnable {

    private int maxRunDistance = 100;
    private int maxJumpDistance = 10;


    public int getMaxRunDistance() {
        return this.maxRunDistance;
    }

    public int getMaxJumpDistance() {
        return this.maxJumpDistance;
    }

    public void jump() {
        System.out.println("Cat is jumping");
    }

    public void run() {
        System.out.println("Cat is running");
    }
}