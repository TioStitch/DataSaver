package org.tiostitch.datasaver;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public final class PlayerData implements Serializable {

    private String name;
    private int coins;
    private int gems;
}
