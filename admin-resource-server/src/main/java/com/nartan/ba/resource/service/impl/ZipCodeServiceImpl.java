package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.ZipCode;
import com.nartan.ba.resource.repository.ZipCodeRepository;
import com.nartan.ba.resource.service.ZipCodeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    private final ZipCodeRepository repository;

  public ZipCodeServiceImpl(ZipCodeRepository repository) {
    this.repository = repository;
  }

  @Override
    public List<ZipCode> findAll() {

        return repository.findAll();
    }

    @Override
    public List<ZipCode> findAll(Pageable pageable) {

        Page<ZipCode> pagedResult = repository.findAll(pageable);
        System.out.println("Total pages: " + pagedResult.getTotalPages());

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<ZipCode> findByZipCode(String zipCode) {
        return repository.findByZipCode(zipCode);
    }

    @Override
    public List<ZipCode> findByNeighborhood(String neighborhood) {

        return repository.findAll();
    }

    @Override
    public List<ZipCode> findByCityId(int id) {
        return repository.findByCityId(id);
    }

    @Override
    public List<ZipCode> findByStateId(int id) {

        return repository.findByStateId(id);
    }

    @Override
    public List<ZipCode> findByCountryId(int id) {
        return repository.findByCountryId(id);
    }

    @Override
    public void addZipCode(ZipCode zipcode) {
        repository.save(zipcode);
    }

    @Override
    public void updateZipCode(ZipCode zipcode) {
        repository.save(zipcode);
    }

    @Override
    public List<ZipCode> findByStatus(Pageable paging, int status) {

        Page<ZipCode> pagedResult = repository.findByStatus(paging, status);
        System.out.println("Total pages: " + pagedResult.getTotalPages());

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }


}
