package com.api.spring.jpa.h2.service;

import com.api.spring.jpa.h2.exception.InternalException;
import com.api.spring.jpa.h2.model.Superheroe;
import com.api.spring.jpa.h2.repository.SuperheroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuperheroeService {

    @Autowired
    private SuperheroeRepository superheroeRepository;

    public List<Superheroe> getAllSuperheroes (String nombre) throws InternalException {
        try {
            List<Superheroe> superheroes = new ArrayList<>();
            if (nombre == null)
                superheroeRepository.findAll().forEach(superheroes::add);
            else
                superheroeRepository.findByNombreContainingIgnoreCase(nombre).forEach(superheroes::add);

            return superheroes;

        } catch (Exception ex) {
            throw new InternalException("Getting All Superheroes error: " + ex);
        }
    }

    public Optional<Superheroe> getSuperheroeById(long id) throws InternalException {
        try {
            return superheroeRepository.findById(id);
        } catch (Exception ex) {
            throw new InternalException("Getting Superheroe By Id error: " + ex);
        }
    }

    public Superheroe saveSuperheroe (Superheroe superheroe) throws InternalException {
        try {
            return superheroeRepository.save(superheroe);
        } catch (Exception ex) {
            throw new InternalException("Saving Superheroe error: " + ex);
        }
    }

    public Superheroe updateSuperheroe(long id, Superheroe superheroe) throws InternalException {
        try {
            Optional<Superheroe> superheroeData = superheroeRepository.findById(id);

            if (superheroeData.isPresent()) {
                Superheroe updatedSuperheroe = superheroeData.get();
                updatedSuperheroe.setNombre(superheroe.getNombre());
                updatedSuperheroe.setDescripcion(superheroe.getDescripcion());
                superheroeRepository.save(updatedSuperheroe);
                return updatedSuperheroe;
            } else {
                throw new InternalException("Superheroe not found");
            }

        } catch (InternalException ex) {
            throw new InternalException("Updating Superheroe error: " + ex);
        }
    }

    public void deleteSuperheroeById (long id) throws InternalException {
        try {
            superheroeRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalException("Deleting Superheroe error: " + ex);
        }
    }
}
