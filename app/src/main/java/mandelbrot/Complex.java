package mandelbrot;
public class Complex {
    double real;
    double imag;
    public Complex (double r, double i) {
        real = r;
        imag = i;
    }
    public Complex add (Complex n) {
        return add(n.real, n.imag);
    }
    public Complex add (double r, double i) {
        this.real += r;
        this.imag += i;
        return this;
    }
    public Complex subtract (Complex n) {
        return subtract(n.real, n.imag);
    }
    public Complex subtract (double r, double i) {
        real -= r;
        imag -= i;
        return this;
    }
    public Complex power (double p) {
        double radius = Math.pow(Math.sqrt((real * real) + (imag * imag)), p);
        double theta = Math.atan2(imag, real) * p;
        real = radius * Math.cos(theta);
        imag = radius * Math.sin(theta);
        return this;
    }
    public Complex multiply (Complex n) {
        return multiply(n.real, n.imag);
    }
    public Complex multiply (double r, double i) {
        double real_temp = (r * this.real) - (i * this.imag);
        this.imag = (this.real * i) + (this.imag * r);
        this.real = real_temp;
        return this;
    }
    public double length () {
        return Math.sqrt((real * real) + (imag * imag));
    }
}