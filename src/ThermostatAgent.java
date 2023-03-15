import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

import java.io.Serial;

public class ThermostatAgent extends Agent {
    @Serial
    private static final long serialVersionUID = 1L;
    public ThermostatThresholds thermostatThresholds;

    @Override
    public void setup() {
        Object[] args = getArguments();
        if (args != null && args.length > 0)
            thermostatThresholds = (ThermostatThresholds) args[0];
        TickerBehaviour thermostatAgentTickBehaviour = new ThermostatAgentTickBehaviour(this, 1000L, thermostatThresholds);
        addBehaviour(thermostatAgentTickBehaviour);

    }
}