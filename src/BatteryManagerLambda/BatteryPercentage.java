package BatteryManagerLambda;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

import java.util.function.Supplier;

/*Utilizando la libreria JPowerShell 3.1 y una función lambda nuestra aplicación obtiene
el porcentaje de bateria de la laptop en tiempo real. */

public class BatteryPercentage {
    public Supplier<Double> getBatteryPercentage() {
        return () -> {
            double batteryPercentage = 0.0;
            try (PowerShell powerShell = PowerShell.openSession()) {
                String command = "(Get-WmiObject -Class Win32_Battery).EstimatedChargeRemaining";
                PowerShellResponse response = powerShell.executeCommand(command);
                if (!response.isError()) {
                    String output = response.getCommandOutput();
                    batteryPercentage = Double.parseDouble(output);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return batteryPercentage;
        };
    }

    public static void main(String[] args) {
        BatteryPercentage batteryPercentage = new BatteryPercentage();
        Supplier<Double> percentageSupplier = batteryPercentage.getBatteryPercentage();
        double percentage = percentageSupplier.get();
        System.out.println("Porcentaje de carga de la bateria: " + percentage + "%");
    }
}
