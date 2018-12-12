public class Main {
    public static void main(String[] args) {
        /*Bird b = new Crow();
        Creature child = b.reproduce();
        b.fly();
        ((Bird)child).fly();*/
        Creature m = new Mushroom();
        Creature l = new Human();
        m.setName("Lenin");
        l.setName("Ленин");
        System.out.println(m.getName());
        System.out.println(l.getName());
    }
}
