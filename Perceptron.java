public class Perceptron {

    private double[] weights;
    private int n;

    // Creates a perceptron with n inputs.
    public Perceptron(int n) {
        this.n = n;
        this.weights = new double[n];
    }

    // Returns the number of inputs n.
    public int numberOfInputs() {
        return n;
    }

    // Returns the weighted sum of the weight vector and x.
    public double weightedSum(double[] x) {
        double weight = 0;
        for (int i = 0; i < x.length; i++) {
            weight += weights[i] * x[i];
        }
        return weight;
    }

    // Predict the label (+1 or -1) of input x.
    public int predict(double[] x) {
        int q = 0;
        if (weightedSum(x) <= 0) {
            q = -1;
        }
        else if (weightedSum(x) >= 0) {
            q = 1;
        }
        return q;
    }


    // Trains this perceptron on the labeled (+1 or -1) input x.
    public void train(double[] x, int label) {
        if (label != predict(x)) {
            if (predict(x) == 1) {
                for (int i = 0; i < weights.length; i++) {
                    weights[i] = weights[i] - x[i];
                }
            }
            else if (predict(x) == -1) {
                for (int i = 0; i < weights.length; i++) {
                    weights[i] = weights[i] + x[i];
                }
            }
        }
    }

    // Returns a string representation of this perceptron.
    public String toString() {
        String sum = "(";
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] + ", ";
        }
        sum = sum.substring(0, sum.length() - 2);
        sum = sum + ")";
        return sum;
    }

    // Tests this class by directly calling all instance methods.
    public static void main(String[] args) {
        double[] training1 = { 5.0, -4.0, 3.0 };  // yes
        double[] training2 = { 2.0, 3.0, -2.0 };  // no
        double[] training3 = { 4.0, 3.0, 2.0 };  // yes
        double[] training4 = { -6.0, -5.0, 7.0 };  // no

        int n = 3;
        Perceptron perceptron = new Perceptron(n);
        StdOut.println(perceptron);
        perceptron.train(training1, +1);
        StdOut.println(perceptron);
        perceptron.train(training2, -1);
        StdOut.println(perceptron);
        perceptron.train(training3, +1);
        StdOut.println(perceptron);
        perceptron.train(training4, -1);
        StdOut.println(perceptron);
    }
}
