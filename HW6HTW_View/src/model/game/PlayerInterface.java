package model.game;

public interface PlayerInterface {
    void setCurrentLocation(int[] location);
    int getArrowsCount();
    void arrowCountDecrease();
    PlayerStatus getStatus();
    void setStatus(PlayerStatus status);
}
