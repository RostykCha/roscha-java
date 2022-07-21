package knowledge.roschajava.collections;

public interface LivingCreature {

    private static String getId(){
        return "My ID: " + Math.random();
    }

    void breathe();

    void eat();

    //Default can be Override
    default void getBirth(){
        System.out.println("I am alive " + getId());
    }

    //Static can't be Overridden
    static void die(){
        System.out.println("R.I.P.");
    }
}
