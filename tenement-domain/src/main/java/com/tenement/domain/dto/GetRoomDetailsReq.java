package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class GetRoomDetailsReq implements Serializable {

    @NotNull
    private Long roomId;
}
