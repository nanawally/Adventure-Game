package se.anna.adventure;

public class Tasks {
    private boolean northCompleted = false;
    private boolean southCompleted = false;
    private boolean eastCompleted = false;
    private boolean westCompleted = false;

    public boolean isNorthCompleted() {
        return northCompleted;
    }

    public void setNorthCompleted(boolean northCompleted) {
        this.northCompleted = northCompleted;
    }

    public boolean isSouthCompleted() {
        return southCompleted;
    }

    public void setSouthCompleted(boolean southCompleted) {
        this.southCompleted = southCompleted;
    }

    public boolean isEastCompleted() {
        return eastCompleted;
    }

    public void setEastCompleted(boolean eastCompleted) {
        this.eastCompleted = eastCompleted;
    }

    public boolean isWestCompleted() {
        return westCompleted;
    }

    public void setWestCompleted(boolean westCompleted) {
        this.westCompleted = westCompleted;
    }
}
