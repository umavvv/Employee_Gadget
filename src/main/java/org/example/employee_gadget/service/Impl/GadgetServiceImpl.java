package org.example.employee_gadget.service.Impl;

import org.example.employee_gadget.dto.GadgetDto;
import org.example.employee_gadget.entity.Gadget;
import org.example.employee_gadget.repository.GadgetRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class GadgetServiceImpl {
    private final GadgetRepository gadgetRepository;

    public GadgetServiceImpl(GadgetRepository gadgetRepository) {
        this.gadgetRepository = gadgetRepository;
    }

    public GadgetDto gadgetDtoConvert(Gadget gadget) {
        GadgetDto gadgetDto = new GadgetDto();
        gadgetDto.setId(gadget.getId());
        gadgetDto.setModel(gadget.getModel());
        gadgetDto.setProcessor(gadget.getProcessor());
        gadgetDto.setMonitorDiagonal(gadget.getMonitorDiagonal());
        gadgetDto.setOperationalMemory(gadget.getOperationalMemory());
        return gadgetDto;
    }

    public GadgetDto findById(Long id) {
        Gadget gadget = gadgetRepository.findById(id).get();
        GadgetDto gadgetDto = new GadgetDto();
        gadgetDto.setId(gadget.getId());
        gadgetDto.setModel(gadget.getModel());
        gadgetDto.setProcessor(gadget.getProcessor());
        gadgetDto.setMonitorDiagonal(gadget.getMonitorDiagonal());
        gadgetDto.setOperationalMemory(gadget.getOperationalMemory());
        return gadgetDto;
    }

    public List<GadgetDto> findAll() {
        return ((List<Gadget>) gadgetRepository
                .findAll())
                .stream()
                .map(this::gadgetDtoConvert)
                .collect(Collectors.toList());
    }

    public GadgetDto saveGadget(GadgetDto gadgetDto) {
        Gadget gadget = new Gadget();
        gadget.setModel(gadgetDto.getModel());
        gadget.setMonitorDiagonal(gadgetDto.getMonitorDiagonal());
        gadget.setOperationalMemory(gadgetDto.getOperationalMemory());
        gadget.setProcessor(gadgetDto.getProcessor());
        gadgetRepository.save(gadget);
        return gadgetDto;
    }

    public GadgetDto update(GadgetDto gadgetDto) {
        Gadget gadget = gadgetRepository.findById(gadgetDto.getId()).get();
        gadget.setId(gadget.getId());
        gadget.setModel(gadgetDto.getModel());
        gadget.setOperationalMemory(gadgetDto.getOperationalMemory());
        gadget.setProcessor(gadgetDto.getProcessor());
        gadget.setMonitorDiagonal(gadgetDto.getMonitorDiagonal());
        gadgetRepository.save(gadget);

        gadgetDto.setOperationalMemory(gadget.getOperationalMemory());
        gadgetDto.setId(gadget.getId());
        gadgetDto.setModel(gadget.getModel());
        gadgetDto.setMonitorDiagonal(gadget.getMonitorDiagonal());
        gadgetDto.setProcessor(gadget.getProcessor());

        return gadgetDto;
    }

    public String delete(Long id) {
        gadgetRepository.deleteById(id);
        return "Delete";
    }
}

