package net.crunchdroid.Dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ServiceDto {
    private String dropDownItem;
    private String nameService;
    private Long idEntreprise;
}
