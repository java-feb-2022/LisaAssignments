public class Casting {
    public static void main(String[] args) {
        double d = 35.25;
        double dd = 35.99;

        // casting the double d into an int
        int i = (int) d;

        // casting the double dd into an int
        int ii = (int) dd;

        System.out.println(i);
        System.out.println(ii);

        int i1 = 120;
        byte b = (byte) i1;

        System.out.println(b);

        byte b1 = 127;
        int i2 = b1;

        System.out.println(i2);

    }
}
