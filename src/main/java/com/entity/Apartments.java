package com.entity;

public class Apartments {

    private long id;
    private String status;
    private long hotelId;

    public Apartments(long id, String status) {
        this.id = id;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Apartments{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", hotelId=" + hotelId +
                '}';
    }
}
