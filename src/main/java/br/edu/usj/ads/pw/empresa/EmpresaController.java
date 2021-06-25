package br.edu.usj.ads.pw.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@CrossOrigin
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping(value = "/")
    public List<Empresa> getListarTodos() {
        List<Empresa> lista = empresaRepository.findAll();
        return lista;
    }

    @GetMapping(value = "/detalhes/{id}")
    public Empresa getDetalhes(@PathVariable Long id) {
        Empresa empresa = new Empresa();
        empresa = empresaRepository.findById(id).get();
        return empresa;
    }

    @PostMapping(value = "/adicionar")
    public Empresa postAdicionar(@RequestBody Empresa empresa) {
        Empresa empresaNovo = empresaRepository.save(empresa);

        return empresaNovo;

    }

    @GetMapping(value = "/deletar/{id}")
    public void getDeletar(@PathVariable Long id) {
        empresaRepository.deleteById(id);

    }
}