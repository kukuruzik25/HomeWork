public class CustomsTerminal {

    public static void inspectCargo(CargoBay<? extends Cargo> bay) {
        for (int i = 0; i < bay.getSize(); i++) {
            Cargo cargo = bay.get(i);
            System.out.println("Груз - " + cargo.getName());
        }

    }

    public static void loadHumanitarianApples(CargoBay<? super Fruit> apples) {
        apples.add(new Fruit("яблоко раз"));
        apples.add(new Fruit("яблоко два"));
    }

    public static <T> void transferCargo(CargoBay<? extends T> from, CargoBay<? super T> to) {
        for (int i = 0; i <= from.getSize(); i++) {
            T carg = from.get(i);
            to.add(carg);
            System.out.println();
        }
    }
}
