package com.task.betpawa_server.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;


@Embeddable
public class BalanceId implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "currency_id")
    private Long currencyId;

    @NotNull
    @Column(name = "user_id")
    private Long user_id;

    public BalanceId( ) {
    }

    public BalanceId(Long currency_id, Long user_id) {
        this.currencyId = currencyId;
        this.user_id = user_id;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BalanceId)) return false;
        BalanceId that = (BalanceId) o;
        return Objects.equals(getCurrencyId(), that.getCurrencyId()) &&
                Objects.equals(getUser_id(), that.getUser_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getCurrencyId());
    }
}
