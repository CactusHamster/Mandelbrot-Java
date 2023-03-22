package mandelbrot;

public class App {
    public static void main (String[] args) {
        Mandelbrot mandel = new Mandelbrot(50*2, 20*2);
        mandel.render();
    };
}