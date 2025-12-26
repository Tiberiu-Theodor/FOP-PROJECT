package com.HUGE.romeorunner.entities.actions;

import com.HUGE.romeorunner.entities.Player;

public interface Movement {
    void move(Direction direction);
    void run(Direction direction);
}
