package ua.ipz4.aplleStore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import ua.labproject.repair_agency.dto.validation.group.OnCreate;
//import ua.labproject.repair_agency.dto.validation.group.OnUpdate;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Null;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
//    @Null(groups = OnCreate.class)
//    @NotNull(groups = OnUpdate.class)
    private Long id;

    private String login;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String bankAccount;


}
