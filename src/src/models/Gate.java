package models;

import enums.GateStatus;
import enums.GateType;

public class Gate extends BaseModel{

    private int gate_number;

    private Operator operator;

    private GateStatus gateStatus;

    private GateType gateType;

    public int getGate_number() {
        return gate_number;
    }

    public void setGate_number(int gate_number) {
        this.gate_number = gate_number;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }
}
