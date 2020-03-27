public abstract class LivingThing {
    private String name;
    protected int canRun;
    protected int canJump;

    public LivingThing(String name) {
        this.name = name;
            }

    public String getName() {
        return name;
    }
}

interface Running{
    void running(int length);
}

interface Jumping{
    void jumping(int height);
}