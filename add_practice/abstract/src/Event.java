public enum Event {
    evAccelerate (0),
    evSlowDown (1),
    evTurnLeft (2),
    evTurnRight (3);

    public int code;

    Event(int code) {
        this.code = code;
    }
}
