public class Robot implements Jumping, Running{
    private String name;
    private int canRun;
    private int canJump;

    public Robot(String name, int height, int length) {
        this.name = name;
        this.canJump = height;
        this.canRun = length;
    }

    public String getName() {
        return name;
    }

    public int getCanRun() {
        return canRun;
    }

    public void setCanRun(int canRun) {
        this.canRun = canRun;
    }

    public int getCanJump() {
        return canJump;
    }

    public void setCanJump(int canJump) {
        this.canJump = canJump;
    }

    public void running(int length){
        System.out.println(getName() + " is running more " + length + "!");
    }

    public void jumping(int height){
        System.out.println(getName() + " is jumping above " + height + "!");
    }
}
