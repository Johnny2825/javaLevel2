public class Human extends LivingThing implements Jumping, Running {

    public Human(String name, int height, int length){
        super(name);
        canJump = height;
        canRun = length;
    }

    @Override
    public void running(int length) {
        System.out.println(getName() + " is running more " + length + "!");
    }

    @Override
    public void jumping(int height) {
        System.out.println(getName() + " is jumping above " + height + "!");
    }

    public int getCanRun() {
        return canRun;
    }

    public int getCanJump() {
        return canJump;
    }

}
