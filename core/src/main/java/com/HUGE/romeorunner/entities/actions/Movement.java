package com.HUGE.romeorunner.entities.actions;

import com.HUGE.romeorunner.entities.Player;

public interface Movement {
    void move(Orientation orientation);
    void run(Orientation orientation);
}
