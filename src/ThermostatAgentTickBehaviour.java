import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

import java.util.Random;

public class ThermostatAgentTickBehaviour extends TickerBehaviour {

    private final Float[] environment = new Float[10];
    private final Random rd = new Random(); // creating Random object
    public ThermostatThresholds thermostatThresholds;

    public ThermostatAgentTickBehaviour(Agent a, long period, ThermostatThresholds thermostatThresholds) {
        super(a, period);
        for (int i = 0; i < environment.length; i++) {
            environment[i] = rd.nextFloat(19.0f, 24.0f); // storing random integers in an array
        }
        this.thermostatThresholds = thermostatThresholds;
        rd.setSeed(123871391873L);
    }

    @Override
    protected void onTick() {
        Float currentTemp = environment[rd.nextInt(environment.length)];
        if (currentTemp < thermostatThresholds.lower) {
            System.out.printf("AC on at temp %.2f\n", currentTemp);
        } else if (currentTemp > thermostatThresholds.upper){
            System.out.printf("AC off at temp %.2f\n", currentTemp);
        } else if (currentTemp >= thermostatThresholds.lower && currentTemp <= thermostatThresholds.upper ) {
            System.out.printf("AC off in range at temp %.2f\n", currentTemp);
        }

    }
}
