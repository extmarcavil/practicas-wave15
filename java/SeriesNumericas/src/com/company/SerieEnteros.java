package com.company;

public class SerieEnteros extends SeriePrototipo {
    private Double start, inc;
    private Double count = 0.0;

    public SerieEnteros(Number inc) {
        this.inc = Double.valueOf(inc.toString());
    }

    public Number next() {
        this.count = Double.sum(this.count, this.inc);

        int int_version = (int)Math.round(this.count);

        if(this.count.intValue() == int_version)
            return int_version;

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
