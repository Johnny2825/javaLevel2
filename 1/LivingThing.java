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

interface running{
    void running(int length);
}

interface jumping{
    void jumping(int height);
}