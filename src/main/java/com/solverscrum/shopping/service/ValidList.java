package com.solverscrum.shopping.service;

import lombok.Data;
import lombok.experimental.Delegate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Data
public class ValidList<E> implements List<E> {

    @Valid @Delegate @NotEmpty(message = "List can't be empty")
    private List<E> list = new ArrayList<>();
}
