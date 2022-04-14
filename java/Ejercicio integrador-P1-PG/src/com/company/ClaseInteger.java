package com.company;

public class ClaseInteger extends Prototipo<Integer>{
    @Override
    public Integer next() {
        if(getInitial().doubleValue() == 1 || getInitial().doubleValue()==2)
        {
            setActual(getActual()+2);
        }else if(getInitial().doubleValue() == 3 ) {
            setActual(getActual()+3);
        }

        return getActual();
    }

    @Override
    public void reset() {
        setActual(getInitial());
    }

    @Override
    public void initialValor(Integer initial) {
        setInitial(initial);
    }
}

