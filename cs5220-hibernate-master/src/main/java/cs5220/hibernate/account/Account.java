package cs5220.hibernate.account;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@Inheritance
@DiscriminatorColumn(name = "account_type")
@DiscriminatorValue("CHECKING")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private Double balance;

    @Column(name = "created_on")
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Customer owner;

    public Account()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public Double getBalance()
    {
        return balance;
    }

    public void setBalance( Double balance )
    {
        this.balance = balance;
    }

    public Date getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn( Date createdOn )
    {
        this.createdOn = createdOn;
    }

    public Customer getOwner()
    {
        return owner;
    }

    public void setOwner( Customer owner )
    {
        this.owner = owner;
    }

}