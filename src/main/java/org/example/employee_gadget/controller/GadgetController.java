package org.example.employee_gadget.controller;

import org.example.employee_gadget.dto.GadgetDto;
import org.example.employee_gadget.service.Impl.GadgetServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gadget")
public class GadgetController {
    private final GadgetServiceImpl gadgetService;

    public GadgetController(GadgetServiceImpl gadgetService) {
        this.gadgetService = gadgetService;
    }

    @GetMapping("/id")
    public GadgetDto get(@RequestParam Long id) {
        return gadgetService.findById(id);
    }

    @GetMapping("/all")
    public List<GadgetDto> getAll() {
        return gadgetService.findAll();
    }

    @PostMapping()
    public GadgetDto save(@RequestBody GadgetDto gadgetDto) {
        return gadgetService.saveGadget(gadgetDto);
    }

    @PutMapping()
    public GadgetDto update(@RequestBody GadgetDto gadgetDto) {
        return gadgetService.update(gadgetDto);
    }

    @DeleteMapping()
    public String delete(@RequestParam Long id) {
        gadgetService.delete(id);
        return "Deleted";
    }
}