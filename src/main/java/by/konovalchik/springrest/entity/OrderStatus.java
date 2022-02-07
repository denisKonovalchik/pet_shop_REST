package by.konovalchik.springrest.entity;


import lombok.Getter;

@Getter
public enum OrderStatus {
    PLACED("PLACED"),
    APPROVED("APPROVED"),
    DELIVERED("DELIVERED");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }


}
