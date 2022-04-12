package com.company;

public abstract class SeriePrototipo {
    private Double start, count, inc;

    public abstract Number next();

    public void reset() {
        this.count = 0.0;
    }

    public void start(Number start) {
        this.start = (double)start;
        this.count = (double)start;
    }
}
