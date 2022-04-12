package com.company;

public class Serie extends SeriePrototipo {
    private Double start, inc;
    private Double count = 0.0;

    public Serie(Number inc) {
        this.inc = Double.valueOf(inc.toString());
    }

    public Number next() {
        this.count = Double.sum(this.count, this.inc);
        return this.count;
    }

    public void reset() {
        this.count = this.start;
    }

    public void start(Number start) {
        this.start = Double.valueOf(start.toString());
        this.reset();

    }
}
