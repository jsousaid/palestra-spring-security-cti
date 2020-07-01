package com.algaworks.gp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GpController {

    /*
     * Automaticamente quando bate nessas url's o sistema direciona para cada template que a url retorna.
     * Exemplo, quando bate em '/entrar' o sistema redireciona para o arquivo '/resources/templates/entrar.html'
     * Para isso tem que estar mapeado no form o campo '/entrar' e o http method post
     **/

    @RequestMapping(method = RequestMethod.GET, path = "/entrar")
    public String entrar() {
        return "entrar";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String inicio() {
        return "inicio";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/projetos")
    public String projetos() {
        return "projetos";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/relatorio-custos")
    public String relatorioCustos() {
        return "relatorio-custos";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/relatorio-equipe")
    public String relatorioEquipe() {
        return "relatorio-equipe";
    }
}
