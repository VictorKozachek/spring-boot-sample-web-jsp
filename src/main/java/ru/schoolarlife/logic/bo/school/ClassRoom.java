package ru.schoolarlife.logic.bo.school;

import ru.schoolarlife.logic.bo.lifecycle.SchoolClass;

/**
 * Created by victor on 08.11.16.
 */
public class ClassRoom {
    private long id;
    private String name;
    private int floorNumber;
    private int seatsNumber;
    private boolean hasProjector;
    private boolean hasElectronicBoard;
    private String cameraLink;
    private SchoolClass embededSchoolClass;

    public ClassRoom() {
    }

    public ClassRoom(long id, String name, int floorNumber, int seatsNumber, boolean hasProjector, boolean hasElectronicBoard, String cameraLink, SchoolClass embededSchoolClass) {
        this.id = id;
        this.name = name;
        this.floorNumber = floorNumber;
        this.seatsNumber = seatsNumber;
        this.hasProjector = hasProjector;
        this.hasElectronicBoard = hasElectronicBoard;
        this.cameraLink = cameraLink;
        this.embededSchoolClass = embededSchoolClass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public boolean isHasElectronicBoard() {
        return hasElectronicBoard;
    }

    public void setHasElectronicBoard(boolean hasElectronicBoard) {
        this.hasElectronicBoard = hasElectronicBoard;
    }

    public String getCameraLink() {
        return cameraLink;
    }

    public void setCameraLink(String cameraLink) {
        this.cameraLink = cameraLink;
    }

    public SchoolClass getEmbededSchoolClass() {
        return embededSchoolClass;
    }

    public void setEmbededSchoolClass(SchoolClass embededSchoolClass) {
        this.embededSchoolClass = embededSchoolClass;
    }
}
