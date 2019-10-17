package cs5220.hibernate.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String address;

    // Implicitly joining customers and customer_phones tables using id and customer_id
    @ElementCollection
    @JoinTable(name = "customer_phones",
        joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "phone")
    @OrderColumn(name = "phone_order")
    private List<String> phones;
    
    @OneToMany(mappedBy="owner")
    private Set<Account> accounts;

    public Customer()
    {
        phones = new ArrayList<String>();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public List<String> getPhones()
    {
        return phones;
    }

    public void setPhones( List<String> phones )
    {
        this.phones = phones;
    }

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}
