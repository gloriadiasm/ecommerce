package com.unitri.comp.ecommerce.model.enums;

public enum OrderStatusEnum{
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    PAGAMENTO_EFETUADO("Pagamento efetuado"),
    ENVIANDO("Enviando pedido"),
    ENTREGUE("Pedido entregue");

    private  String description;

    OrderStatusEnum(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
