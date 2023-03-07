package com.example.paymentta.controller;

import com.example.paymentta.dto.convertor.BaseConvertor;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AbstractController <E,D>{


    @Autowired
    private AbstractService<? extends JpaRepository<E, Long>, E> service;

    @Autowired
    private BaseConvertor<D, E> converter;


    @PostMapping()
    @Transactional
    public void add(@RequestBody D d) throws ServiceException {


        service.insert(converter.convertDto(d));
    }

    public AbstractService<? extends JpaRepository<E, Long>, E> getService() {
        return service;
    }
}
