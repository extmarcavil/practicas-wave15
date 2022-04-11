public abstract  class Animal {
    private  int TipoGusto;

    public Animal(int tipoGusto) {
        TipoGusto = tipoGusto;
    }

    abstract public void EmiteSonido();

    public void  comerAnimal(){
        if (this.TipoGusto == 1)
            System.out.println("comer carne");
        else
            System.out.println("comer hierba");
    }

}
