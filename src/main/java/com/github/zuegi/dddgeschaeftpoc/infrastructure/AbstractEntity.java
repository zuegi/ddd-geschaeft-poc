package com.github.zuegi.dddgeschaeftpoc.infrastructure;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class AbstractEntity {

	public AbstractEntity() {
		this.active = true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean active;

	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)

	private Date createdDate;

	private String lastModifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Version
	private int version;
}
