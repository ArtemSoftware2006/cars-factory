package com.artem.carsfactory.Dto;

public class CarCreateDto {
    private String name;
    private Long bodyId;
    private Long wheelId;
    private int countWheels;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getBodyId() {
        return bodyId;
    }
    public void setBodyId(Long bodyId) {
        this.bodyId = bodyId;
    }
    public Long getWheelId() {
        return wheelId;
    }
    public void setWheelId(Long wheelId) {
        this.wheelId = wheelId;
    }
    public int getCountWheels() {
        return countWheels;
    }
    public void setCountWheels(int countWheels) {
        this.countWheels = countWheels;
    }
}
