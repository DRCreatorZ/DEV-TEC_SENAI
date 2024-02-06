package control;

import model.ElevadorModel;
import view.ElevadorView;

public class ElevadorControl {
    private SimuladorElevadorView view;
    private Elevador elevador1;
    private Elevador elevador2;

    public ElevadorControl(SimuladorElevadorView view, Elevador elevador1, Elevador elevador2) {
        this.view = view;
        this.elevador1 = elevador1;
        this.elevador2 = elevador2;

        // ... (Initialize any additional setup or event handling)
    }
}
