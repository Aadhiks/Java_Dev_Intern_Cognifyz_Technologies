import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter unit of measurement (Celsius or Fahrenheit): ");
        scanner.nextLine(); 
        String unit = scanner.nextLine().toLowerCase();

        if (unit.equals("celsius")) {
            double convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println("Converted temperature in Fahrenheit: " + convertedTemperature + " °F");
        } else if (unit.equals("fahrenheit")) {
            double convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println("Converted temperature in Celsius: " + convertedTemperature + " °C");
        } else {
            System.out.println("Invalid unit of measurement. Please enter either Celsius or Fahrenheit.");
        }

        scanner.close();
    }


    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }


    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
