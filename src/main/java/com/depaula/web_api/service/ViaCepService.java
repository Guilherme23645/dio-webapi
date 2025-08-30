package com.depaula.web_api.service;

import com.depaula.web_api.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name="viacep", url="https://viacep.com.br/ws")
public interface ViaCepService {

    @RequestMapping(method = GET, value = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}
