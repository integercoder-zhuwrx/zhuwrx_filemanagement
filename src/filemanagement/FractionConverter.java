package filemanagement;

import java.util.StringJoiner;

public class FractionConverter {
    //                                     e.g. text => "-1/2;5/4;-171/50;0/1"
    public static double[] parseToDouble(String text) {
        // text  █'-'█'1'█'/'█'2'█';'█'5'█'/'█'4'█';'█'-'█'1'█'7'█'1'█'/'█'5'█'0'█';'█'0'█'/'█'1'█
        //       ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑
        //       0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20

        String[] fractions = text.split(";");
        // fractions  █"-1/2"   █"5/4"    █"-171/50"█"0/1"    █
        //            ↑         ↑         ↑         ↑         ↑
        //            0         1         2         3         4

        //                           fractions.length => 4
        double[] values = new double[fractions.length];

        //                  fractions.length => 4
        for (int i = 0; i < fractions.length; i++) {
            //                           fractions[0] => "-1/2"
            //                           fractions[1] => "5/4"
            //                           fractions[2] => "-171/50"
            //                           fractions[3] => "0/1"
            values[i] = fractionToDouble(fractions[i]);
        }

        //    values  █-0.5     █1.25     █-3.42    █0.0      █
        //            ↑         ↑         ↑         ↑         ↑
        //            0         1         2         3         4
        return values;
    }

    //                                      e.g. fraction => "-171/50"
    public static double fractionToDouble(String fraction) {
        // fraction  █'-'█'1'█'7'█'1'█'/'█'5'█'0'█
        //           ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑
        //           0   1   2   3   4   5   6   7

        String[] parts = fraction.split("/");
        // parts  █"-171"█"50"█
        //        ↑      ↑    ↑
        //        0      1    2

        //                               parts[0] => "-171"
        //  numerator => -171
        int numerator = Integer.parseInt(parts[0]);

        //                                 parts[1] => "50"
        //  denominator => 50
        int denominator = Integer.parseInt(parts[1]);

        //     (double) numerator => -171.0
        //     (double) numerator / denominator => -171.0 / 50
        //                                      => -3.42
        return (double) numerator / denominator;
    }

    public static String parseToString(double[] values) {
        StringJoiner sj = new StringJoiner(";");
        for (double value : values) {
            String fraction = doubleToFraction(value);
            sj.add(fraction);
        }
        return sj.toString();
    }

    //                                      e.g. value => -3.42
    public static String doubleToFraction(double value) {
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

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
