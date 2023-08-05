package com.ariane.asdinsights.controller;

import com.ariane.asdinsights.dto.ReportRecordDto;
import com.ariane.asdinsights.models.ReportModel;
import com.ariane.asdinsights.repositories.ReportRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ReportController {

    @Autowired
    ReportRepository reportRepository;

    @GetMapping("/reports")
    public ResponseEntity<List<ReportModel>> getAllReports(){
        List<ReportModel> reportsList = reportRepository.findAll();
        if(!reportsList.isEmpty()) {
            for(ReportModel report : reportsList) {
                UUID id = report.getIdUser();
                report.add(linkTo(methodOn(ReportController.class).getOneReport(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(reportsList);
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<Object> getOneReport(@PathVariable(value="id") UUID id){
        Optional<ReportModel> reportO = reportRepository.findById(id);
        if(reportO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Report not found.");
        }
        reportO.get().add(linkTo(methodOn(ReportController.class).getAllReports()).withRel("Users List"));
        return ResponseEntity.status(HttpStatus.OK).body(reportO.get());
    }

    @PostMapping("/reports")
    public ResponseEntity<ReportModel> saveReport(@RequestBody @Valid ReportRecordDto reportRecordDto) {
        var reportModel = new ReportModel();
        BeanUtils.copyProperties(reportRecordDto, reportModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(reportRepository.save(reportModel));
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity<Object> deleteReport(@PathVariable(value="id") UUID id) {
        Optional<ReportModel> reportO = reportRepository.findById(id);
        if(reportO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Report not found.");
        }
        reportRepository.delete(reportO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Report deleted successfully.");
    }

    @PutMapping("/reports/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid ReportRecordDto reportRecordDto) {
        Optional<ReportModel> reportO = reportRepository.findById(id);
        if(reportO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        var reportModel = reportO.get();
        BeanUtils.copyProperties(reportRecordDto, reportModel);
        return ResponseEntity.status(HttpStatus.OK).body(reportRepository.save(reportModel));
    }

}