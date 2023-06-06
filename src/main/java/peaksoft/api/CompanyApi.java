package com.example.securityproject.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.*;
import peaksoft.service.CompanySe;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyApi {

    private final CompanySe companySe;


    @GetMapping
    public List<CompanyResponse> getAllCompany(){
        return companySe.getAllCompany();
    }

    @PostMapping
    public SimpleResponse saveCompany(@Valid @RequestBody CompanyRequest companyRequest){
        return companySe.saveCompany(companyRequest);
    }

    @GetMapping("/{id}")
    public CompanyResponse getCompanyById(@PathVariable Long id){
        return companySe.getCompanyId(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse update(@Valid @PathVariable Long id,@RequestBody CompanyRequest companyRequest){
        return companySe.updateCompany(id,companyRequest);
    }
    @DeleteMapping("{id}")
    public SimpleResponse delete(@PathVariable Long id) {
        return companySe.deleteCompany(id);
    }


    @GetMapping("/info/{companyId}")
    public CompanyInfoResponse companyRe (@PathVariable Long companyId){
        return companySe.infoCompany(companyId);
    }
}
