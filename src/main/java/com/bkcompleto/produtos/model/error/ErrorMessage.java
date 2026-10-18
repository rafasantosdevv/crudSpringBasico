package com.bkcompleto.produtos.model.error;

public class ErrorMessage {
    private String titulo;

    private Integer status;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public ErrorMessage(String titulo, Integer status, String msg) {
        this.titulo = titulo;
        this.status = status;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
