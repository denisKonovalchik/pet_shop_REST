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

    public static PetStatus getEnum(String value){
        for(PetStatus status: PetStatus.values()){
            if(status.getValue().equals(value)){
                return status;
            }
        }
        return  null;
    }
}
