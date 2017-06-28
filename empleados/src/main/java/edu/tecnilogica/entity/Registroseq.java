package edu.tecnilogica.entity;
// Generated 27-jun-2017 12:19:09 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Registroseq generated by hbm2java
 */
@Entity
@Table(name = "REGISTROSEQ", schema = "HR")
public class Registroseq implements java.io.Serializable {

	private BigDecimal id;

	public Registroseq() {
	}

	public Registroseq(BigDecimal id) {
		this.id = id;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

}