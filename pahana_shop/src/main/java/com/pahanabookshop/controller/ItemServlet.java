package com.pahanabookshop.controller;

import com.pahanabookshop.model.Item;
import com.pahanabookshop.service.ItemService;
import com.pahanabookshop.service.impl.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/item")
public class ItemServlet extends HttpServlet {

    private ItemService itemService = new ItemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            List<Item> items = itemService.getAllItems();
            request.setAttribute("items", items);
            request.getRequestDispatcher("items.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Item item = itemService.getItemById(id);
            request.setAttribute("item", item);
            request.getRequestDispatcher("item_form.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            itemService.deleteItem(id);
            response.sendRedirect("item?action=list");
        } else if ("add".equals(action)) {
            request.getRequestDispatcher("item_form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Item item = new Item(id, name, price, stock);

        if (id > 0) {
            itemService.updateItem(item);
        } else {
            itemService.addItem(item);
        }

        response.sendRedirect("item?action=list");
    }
}
