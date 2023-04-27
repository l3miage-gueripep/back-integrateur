package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.response.MiahootDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MiahootMapper {
    MiahootDTO toDto(Miahoot entity);

    @Mapping(target = "description", source = "description")
    @Mapping(target = "nom", source = "nom")
    Miahoot toEntity(CreateMiahootRequest request);

}
