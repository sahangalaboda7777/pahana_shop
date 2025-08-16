package com.pahanabookshop.controller;

import com.pahanabookshop.model.Bill;
import com.pahanabookshop.model.BillItem;
import com.pahanabookshop.model.Item;
import com.pahanabookshop.service.BillService;
import com.pahanabookshop.service.ItemService;
import com.pahanabookshop.service.impl.BillServiceImpl;
import com.pahanabookshop.service.impl.ItemServiceImpl;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pahanabookshop.model.Customer;
import com.pahanabookshop.service.CustomerService;
import com.pahanabookshop.service.impl.CustomerServiceImpl;

@WebServlet("/bill")
public class BillServlet extends HttpServlet {

    private BillService billService = new BillServiceImpl();
    private ItemService itemService = new ItemServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            List<Item> items = itemService.getAllItems();
            List<Customer> customers = customerService.getAllCustomers(); // ✅ get customers
            request.setAttribute("items", items);
            request.setAttribute("customers", customers); // ✅ pass to JSP
            request.getRequestDispatcher("createBill.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            request.setAttribute("bills", billService.getAllBills());
            request.getRequestDispatcher("billPreview.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("accountNo");
        String[] itemIds = request.getParameterValues("itemId");
        String[] quantities = request.getParameterValues("quantity");

        if (itemIds == null || itemIds.length == 0) {
            request.setAttribute("error", "Please select at least one item.");
            request.getRequestDispatcher("createBill.jsp").forward(request, response);
            return;
        }

        List<BillItem> billItems = new ArrayList<>();
        double totalAmount = 0.0;

        for (int i = 0; i < itemIds.length; i++) {
            int id = Integer.parseInt(itemIds[i]);
            int qty = Integer.parseInt(quantities[i]);
            if (qty <= 0) continue;

            Item item = itemService.getItemById(id);
            double subTotal = item.getPrice() * qty;
            totalAmount += subTotal;

            BillItem billItem = new BillItem(0, null, id, qty, item.getPrice(), subTotal);
            billItems.add(billItem);
        }

        // Create Bill object (billId will be generated in DB)
        Bill bill = new Bill(0, accountNo, new java.sql.Date(new Date().getTime()), totalAmount, billItems);
        billService.addBill(bill); // billId + billNo will be filled

        // Generate PDF with billNo (formatted)
        try {
            String folderPath = "C:/bills/";
            File folder = new File(folderPath);
            if (!folder.exists()) folder.mkdirs();

            PdfWriter writer = new PdfWriter(folderPath + bill.getBillNo() + ".pdf");
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            document.add(new Paragraph("Bill No: " + bill.getBillNo()));
            document.add(new Paragraph("Account No: " + accountNo));
            document.add(new Paragraph("Date: " + new Date()));
            document.add(new Paragraph("-----------------------------------------------------"));

            for (BillItem bi : billItems) {
                Item item = itemService.getItemById(bi.getItemId());
                document.add(new Paragraph(
                    item.getName() + " x " + bi.getQuantity() + " @ " + bi.getUnitPrice() + " = " + bi.getSubTotal()
                ));
            }

            document.add(new Paragraph("-----------------------------------------------------"));
            document.add(new Paragraph("Total Amount: " + totalAmount));
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("bill?action=list");
    }

}
