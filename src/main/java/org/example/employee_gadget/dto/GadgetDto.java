package org.example.employee_gadget.dto;

import lombok.Builder;

@Builder
public class GadgetDto {
    private Long id;
    private String monitorDiagonal;
    private String operationalMemory;
    private String processor;
    private String model;

    public GadgetDto() {
    }

    public GadgetDto(Long id, String monitorDiagonal, String operationalMemory, String processor, String model) {
        this.id = id;
        this.monitorDiagonal = monitorDiagonal;
        this.operationalMemory = operationalMemory;
        this.processor = processor;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonitorDiagonal() {
        return monitorDiagonal;
    }

    public void setMonitorDiagonal(String monitorDiagonal) {
        this.monitorDiagonal = monitorDiagonal;
    }

    public String getOperationalMemory() {
        return operationalMemory;
    }

    public void setOperationalMemory(String operationalMemory) {
        this.operationalMemory = operationalMemory;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}