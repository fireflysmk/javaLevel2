public class Wall implements Jumpable {
    private int height;

    public Wall(int weight) {
        this.height = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void jump() {
    }
}