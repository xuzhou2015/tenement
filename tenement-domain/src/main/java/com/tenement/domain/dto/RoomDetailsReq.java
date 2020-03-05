package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RoomDetailsReq implements Serializable {

    @NotEmpty
    private String name;

    @NotNull
    private Integer districtId;

    /**
     *  所属小区
     */
    @NotBlank
    private String ownerarea;

    /**
     * 面积
     */
    @NotNull
    private Integer housearea;

    @NotBlank
    private String builddate;

    @NotBlank
    private String cp;

    @NotNull
    private Integer floor;

    @NotBlank
    private String housestyle;

    @NotNull
    private Byte housestyleType;

    @NotNull
    private Double buildarea;

    @NotNull
    private Integer houseprice;

    @NotNull
    private Byte gn;

    @NotNull
    private Integer cqnx;

    @NotNull
    private Byte dt;

    @NotNull
    private Byte housedirection;

    @NotNull
    private Byte finishType;

    @NotNull
    private Byte onsaleType;

    @NotNull
    private Byte marketType;

    @NotNull
    private Byte tenementType;

    @NotNull
    private Integer brokerId;

    private List<Integer> fileIds;
}
