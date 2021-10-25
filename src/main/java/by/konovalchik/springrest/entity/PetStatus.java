package by.konovalchik.springrest.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
public enum PetStatus {
    AVAILABLE("AVAILABLE"),
    PENDING("PENDING"),
    SOLD("SOLD");

    private final String value;

    PetStatus(String value) {
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
