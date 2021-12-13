package filemanagement;

import java.util.StringJoiner;

public class FractionConverter {
    public double[] parseToDouble(String a) {
        String[] fractionTexts = a.split(";");
        int valueCount = fractionTexts.length;
        double[] values = new double[valueCount];
        for (int i = 0; i < valueCount; i++) {
            String[] numbers = fractionTexts[i].split("/");
            int numerator = Integer.parseInt(numbers[0]);
            int denominator = Integer.parseInt(numbers[1]);
            values[i] = (double) numerator / denominator;
        }
        return values;
    }

    public String parseToString(double[] values) {
        StringJoiner sj = new StringJoiner(";");
        for (double value : values) {
            String fraction = doubleToFraction(value);
            sj.add(fraction);
        }
        return sj.toString();
    }

    //                               e.g. value => -3.42
    public String doubleToFraction(double value) {
        //     valueText => "-3.42"
        String valueText = Double.toString(value);
        //     valueText  █'-'█'3'█'.'█'4'█'2'█
        //                ↑   ↑   ↑   ↑   ↑   ↑
        //                0   1   2   3   4   5

        //  decPointPos => 2
        int decPointPos = valueText.indexOf(".");

        //                  valueText.length() => 5
        //                                        decPointPos + 1 => 2 + 1
        //                                                        => 3
        //  decPartLength => 5 - 3
        //                => 2
        int decPartLength = valueText.length() - (decPointPos + 1);

        //                      Math.pow(10, 2) => 100.0
        //  denominator => 10^2
        //              => 100
        int denominator = (int) Math.pow(10, decPartLength);

        //                     value * denominator => -3.42 * 100
        //                                         => -342.0
        //  numerator => -342
        int numerator = (int) (value * denominator);

        //  g => 2
        int g = gcd(numerator, denominator);

        //          numerator / g => -342 / 2
        //                        => -171
        // numerator => -171
        numerator = numerator / g;

        //            denominator / g => 100 / 2
        //                            => 50
        // denominator => 50
        denominator = denominator / g;

        // "-171/50"
        return numerator + "/" + denominator;
    }

    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
