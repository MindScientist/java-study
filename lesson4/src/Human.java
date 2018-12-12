public class Human extends Creature {
    @Override
    public String getName() {
        return "Товарищ " + super.getName();
    }

    @Override
    public void setName(String name) {
        if (name.length() > 10) throw new RuntimeException("Низзя!");
        super.setName(name);
    }
}
