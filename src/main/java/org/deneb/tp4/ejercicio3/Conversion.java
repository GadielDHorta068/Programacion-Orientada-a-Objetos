package org.deneb.tp4.ejercicio3;
class Conversion {
    public static double convertirTemperatura(double valor, String deTipo, String aTipo) {
        double resultado = valor;

        if (deTipo.equals("Grado Celsius")) {
            if (aTipo.equals("Grado Fahrenheit")) {
                resultado = celsiusAFahrenheit(valor);
            } else if (aTipo.equals("Kelvin")) {
                resultado = celsiusAKelvin(valor);
            }
        } else if (deTipo.equals("Grado Fahrenheit")) {
            if (aTipo.equals("Grado Celsius")) {
                resultado = fahrenheitACelsius(valor);
            } else if (aTipo.equals("Kelvin")) {
                resultado = fahrenheitAKelvin(valor);
            }
        } else if (deTipo.equals("Kelvin")) {
            if (aTipo.equals("Grado Celsius")) {
                resultado = kelvinACelsius(valor);
            } else if (aTipo.equals("Grado Fahrenheit")) {
                resultado = kelvinAFahrenheit(valor);
            }
        }

        return resultado;
    }

    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusAKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinACelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double fahrenheitAKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinAFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }
}