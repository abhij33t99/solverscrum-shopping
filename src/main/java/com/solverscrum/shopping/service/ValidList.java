package com.solverscrum.shopping.service;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class ValidList<E> {

    @Valid
    @NotEmpty(message = "List can't be empty")
    private List<E> list = new ArrayList<>();

}
