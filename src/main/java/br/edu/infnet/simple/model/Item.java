package br.edu.infnet.simple.model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item  {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@Size(
			min = 2,
			max = 255,
			message = "Name cannot be < 2 and > 255"
			)
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date createOn;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private Set<Bid> bids;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Set<Bid> getBids() {
		bids = Objects.requireNonNullElse(bids, new TreeSet<Bid>());
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	

	public void addBid(Bid bid) {
		Objects.requireNonNull(bid, "Bid cannot be null");

		if(bid.getItem() != null) {
			throw new IllegalStateException("Is already set");
		}
		
		this.getBids().add(bid);
		bid.setItem(this);
		
	}
	

	
	
}
