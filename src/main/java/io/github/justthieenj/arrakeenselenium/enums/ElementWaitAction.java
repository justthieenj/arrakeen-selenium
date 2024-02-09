package io.github.justthieenj.arrakeenselenium.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import static io.github.justthieenj.arrakeenselenium.enums.ElementState.*;

@AllArgsConstructor
@Getter
public enum ElementWaitAction {
    click(List.of(visible, enabled)),
    type(List.of(visible, editable));

    private final List<ElementState> states;
}
