package com.demo.library.storage.database.mappers;

public interface EntityMapper <D, E>{

	E fromDomainToEntity(D domainObject);

	D fromEntityToDomain(E entityObject);
}
