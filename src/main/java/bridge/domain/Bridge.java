package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.validator.PlayerInputValidator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final BridgeMaker bridgeMaker;
    private final int bridgeSize;
    private final List<String> shape;

    public Bridge(int bridgeSize) {
        validate(bridgeSize);
        this.bridgeSize = bridgeSize;
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        shape = new ArrayList<>(bridgeMaker.makeBridge(this.bridgeSize));
    }

    public void validate(int bridgeSize) {
        PlayerInputValidator.bridgeLengthValidator(bridgeSize);
    }

    public List<String> getShape() {
        return shape;
    }
}