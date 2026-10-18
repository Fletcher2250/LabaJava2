public class Fraction {
    private int numerator;   // Числитель
    private int denominator; // Знаменатель

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() { return numerator; }
    public void setNumerator(int numerator) { this.numerator = numerator; }
    public int getDenominator() { return denominator; }
    public void setDenominator(int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction other) {
        return new Fraction(
                this.numerator * other.denominator + other.numerator * this.denominator,
                this.denominator * other.denominator
        );
    }

    public Fraction sum(int other) {
        return new Fraction(this.numerator + other * this.denominator, this.denominator);
    }

    public Fraction minus(Fraction other) {
        return new Fraction(
                this.numerator * other.denominator - other.numerator * this.denominator,
                this.denominator * other.denominator
        );
    }

    public Fraction minus(int other) {
        return new Fraction(this.numerator - other * this.denominator, this.denominator);
    }

    public Fraction mul(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction mul(int other) {
        return new Fraction(this.numerator * other, this.denominator);
    }

    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на дробь с нулевым числителем!");
        }
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public Fraction div(int other) {
        if (other == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return new Fraction(this.numerator, this.denominator * other);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
