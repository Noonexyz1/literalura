package com.literalura.infrastructure.app.terminal.model;

public class OpcionModel {
    private Integer opcionNumerica;
    private String opcionLiteral;

    //private Function<Integer, String> asdf;

    //Me decidi hacerlo con un Runnable jeje, asi no retornas un modelo general,
    //mucho trabajo para mostrar, tendriamos que mapear campo por campo y demas
    //No me importa de donde, pero pasame el comportamiento
    private Runnable ejecutarOpcion;


    public OpcionModel(
            Integer opcionNumerica,
            String opcionLiteral,
            Runnable ejecutarOpcion
    ) {
        this.opcionNumerica = opcionNumerica;
        this.opcionLiteral = opcionLiteral;
        this.ejecutarOpcion = ejecutarOpcion;
    }


    public Integer getOpcionNumerica() {
        return opcionNumerica;
    }

    public void setOpcionNumerica(Integer opcionNumerica) {
        this.opcionNumerica = opcionNumerica;
    }

    public String getOpcionLiteral() {
        return opcionLiteral;
    }

    public void setOpcionLiteral(String opcionLiteral) {
        this.opcionLiteral = opcionLiteral;
    }

    public Runnable getEjecutarOpcion() {
        return ejecutarOpcion;
    }

    public void setEjecutarOpcion(Runnable ejecutarOpcion) {
        this.ejecutarOpcion = ejecutarOpcion;
    }
}
