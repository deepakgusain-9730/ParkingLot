package factory;

import enums.SlotAssignedStrategyType;
import strategies.RandomSlotAssignedStrategy;
import strategies.SlotAssignedStrategy;

public class SlotAssignedStrategyFactory {

    public static SlotAssignedStrategy getSlotAssignedStrategy(SlotAssignedStrategyType strategy) {
        return new RandomSlotAssignedStrategy();
    }
}
