import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Main {
    public static void main(String[] args)   {
        jade.core.Runtime rt = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl();
        AgentContainer mainContainer = rt.createMainContainer(profile);
        try {
            AgentController rma = mainContainer.createNewAgent("rma", "jade.tools.rma.rma", null);
            rma.start();
            Object[] agentArgs = new Object[1];
            agentArgs[0] = new ThermostatThresholds(21,23);

            AgentController ac = mainContainer.createNewAgent("ThermostatAgent", "ThermostatAgent", agentArgs);
            ac.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }

    }
}