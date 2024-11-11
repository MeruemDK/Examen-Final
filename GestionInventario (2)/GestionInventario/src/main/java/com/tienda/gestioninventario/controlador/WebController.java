package com.tienda.gestioninventario.controlador;

import com.tienda.gestioninventario.modelo.Producto;
import com.tienda.gestioninventario.modelo.Proveedor;
import com.tienda.gestioninventario.servicio.ProductoServicio;
import com.tienda.gestioninventario.servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoServicio.listarTodos());
        return "productos";
    }

    @GetMapping("/productos/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("proveedores", proveedorServicio.listarTodos());
        return "producto-form";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoServicio.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoServicio.obtenerPorId(id));
        model.addAttribute("proveedores", proveedorServicio.listarTodos());
        return "producto-form";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoServicio.eliminarProducto(id);
        return "redirect:/productos";
    }

    @GetMapping("/productos-invitado")
    public String productosInvitado(Model model) {
        model.addAttribute("productos", productoServicio.listarTodos());
        return "productos-invitado";
    }


    @GetMapping("/proveedores")
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorServicio.listarTodos());
        return "proveedores";
    }

    @GetMapping("/proveedores/nuevo")
    public String nuevoProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor-form";
    }

    @PostMapping("/proveedores/guardar")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorServicio.guardarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/editar/{id}")
    public String editarProveedor(@PathVariable Long id, Model model) {
        model.addAttribute("proveedor", proveedorServicio.obtenerPorId(id));
        return "proveedor-form";
    }

    @GetMapping("/proveedores/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        proveedorServicio.eliminarProveedor(id);
        return "redirect:/proveedores";
    }

    @GetMapping("/stock-bajo")
    public String stockBajo(Model model) {
        List<Producto> productosBajoStock = productoServicio.obtenerProductosBajoStock();
        System.out.println("Productos con stock bajo: " + productosBajoStock.size());
        model.addAttribute("productosBajoStock", productosBajoStock);
        return "stock-bajo";
    }
}
