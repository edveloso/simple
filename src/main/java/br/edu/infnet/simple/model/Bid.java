package br.edu.infnet.simple.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bid implements Comparable<Bid> {

	@Id
	@GeneratedValue
	private Integer id;
	
	private BigDecimal amount;
	
	private Date createOn;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int compareTo(Bid o) {
		if(id == null) {
			return -1;
		}
		return id.compareTo(o.getId());
	}
	
	
	
	
}
