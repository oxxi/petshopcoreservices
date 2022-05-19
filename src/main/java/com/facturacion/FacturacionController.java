package com.facturacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/facturacion")
public class FacturacionController {

    @ResponseBody
    String Facturacion()
    {
        return "";
    }
}
