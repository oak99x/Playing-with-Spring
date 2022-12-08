package com.bcopstein.aplicacao.dtos;

public class TotalDTO {

    private double total;
    private double subTotal;
    private double frete;
    private double imposto;
    private double desconto;
    public TotalDTO(double total, double subTotal, double frete, double imposto, double desconto) {
        this.total = total;
        this.subTotal = subTotal;
        this.frete = frete;
        this.imposto = imposto;
        this.desconto = desconto;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public double getFrete() {
        return frete;
    }
    public void setFrete(double frete) {
        this.frete = frete;
    }
    public double getImposto() {
        return imposto;
    }
    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
    public double getDesconto() {
        return desconto;
    }
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }  
    
}
