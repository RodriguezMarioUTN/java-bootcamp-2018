package com.globant.controller;


import com.globant.dao.PaymentDao;
import com.globant.model.Payment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PaymentController {
    private PaymentDao paymentDao = new PaymentDao();

    public PaymentController() {
    }

    public void showOptionForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Payment existingPayment = paymentDao.getPayment(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/jsp/PaymentMenu.jsp");
        request.setAttribute("payment", existingPayment);
        dispatcher.forward(request, response);
    }

    public void listPayment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Payment> listPayment = paymentDao.listAllPayments();
        request.setAttribute("listPayment", listPayment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/jsp/PaymentList.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idOrder = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idOrder", ""+idOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/jsp/PaymentForm.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Payment existingPayment = paymentDao.getPayment(id);
        request.setAttribute("payment", existingPayment);
        request.setAttribute("idOrder", ""+existingPayment.getIdOrder());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/jsp/PaymentForm.jsp");
        dispatcher.forward(request, response);
    }

    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Float amount = Float.parseFloat(request.getParameter("amount"));
        System.out.println("AMOUNT EN EL BACK "+amount);
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        Payment newPayment = new Payment(amount, idOrder);
        paymentDao.insertPayment(newPayment);
        response.sendRedirect(request.getContextPath() + "/listPayment?id="+newPayment.getIdOrder());
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Float amount = Float.parseFloat(request.getParameter("amount"));
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        Payment payment = new Payment(id, amount, idOrder);
        paymentDao.updatePayment(payment);
        response.sendRedirect(request.getContextPath() + "/listPayment?id="+payment.getIdOrder());
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Payment payment = new Payment(id);
        paymentDao.deletePayment(payment);
        response.sendRedirect(request.getContextPath() + "/listPayment?id="+payment.getIdOrder());

    }

}


