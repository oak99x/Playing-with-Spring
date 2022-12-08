package com.bcopstein.aplicacao.dtos;

public class SubTotalDTO {

    private double subTotal;
    private double frete;
    private double imposto;
    private double desconto;
    public SubTotalDTO(double subTotal, double frete) {
        this.subTotal = subTotal;
        this.frete = frete;
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