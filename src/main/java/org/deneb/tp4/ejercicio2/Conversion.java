package org.deneb.tp4.ejercicio2;
class Conversion {
    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}