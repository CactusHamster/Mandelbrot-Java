package mandelbrot;
import java.lang.Math;

public class Mandelbrot {
    int width;
    int height;
    int[] range = { -2, 2, -2, 2 };
    
    public Mandelbrot () { this(100, 40); }
    public Mandelbrot (int w, int h) {
        this.width = w;
        this.height = h;
    }
    
    private static double prop (double n, double min, double max, double nmin, double nmax) { return ((n - min) / (max - min)) * (nmax - nmin) + nmin; }

    public void render () { Mandelbrot.render(this.width, this.height, this.range); }
    public static void render (int w, int h, int[] range) {
        String symbols = " .*0#";
        int max_symbol_index = symbols.length();
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                Complex c = new Complex(
                    prop(x, 0, w, -2, 2),
                    prop(y, 0, h, -2, 2)
                );
                Complex z = new Complex(0, 0);
                int i = 0;
                while (i < 255 && z.length() < 10) {
                    z.multiply(z).add(c);
                    i += 1;
                }
                int symbol_index = (int) Math.ceil(prop(i, 0, 255, 0, max_symbol_index)) - 1;
                char symbol = symbols.charAt(symbol_index);
                System.out.print(symbol);
            }
            System.out.print("\n");
        }
    }
}