package main.java.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 *
 * @lastName www.codejava.net
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String jdbcURL = "";
    private String jdbcUsername = "";
    private String jdbcPassword = "";
    private ClientController clientCont = new ClientController();
    private OrderController orderCont = new OrderController();
    private ItemController itemCont = new ItemController();
    private PaymentController paymentCont = new PaymentController();

    public void init() {
        jdbcURL = getServletContext().getInitParameter("jdbcURL");
        jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.showNewForm(request, response);
                    break;
                case "/newOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.showNewForm(request, response);
                    break;
                case "/newItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.showNewForm(request, response);
                    break;
                case "/newPayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.showNewForm(request, response);
                    break;
                case "/insert":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.insert(request, response);
                    break;
                case "/insertOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.insert(request, response);
                    break;
                case "/insertItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.insert(request, response);
                    break;
                case "/insertPayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.insert(request, response);
                    break;
                case "/delete":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.delete(request, response);
                    break;
                case "/deleteOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.delete(request, response);
                    break;
                case "/deleteItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.delete(request, response);
                    break;
                case "/deletePayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.delete(request, response);
                    break;
                case "/edit":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.showEditForm(request, response);
                    break;
                case "/editOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.showEditForm(request, response);
                    break;
                case "/editItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.showEditForm(request, response);
                    break;
                case "/editPayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.showEditForm(request, response);
                    break;
                case "/update":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.update(request, response);
                    break;
                case "/updateOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.update(request, response);
                    break;
                case "/updateItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.update(request, response);
                    break;
                case "/updatePayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.update(request, response);
                    break;
                case "/options":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.showOptionForm(request, response);
                    break;
                case "/optionsOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.showOptionForm(request, response);
                    break;
                case "/":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.listClient(request, response);
                    break;
                case "/listOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.listOrder(request, response);
                    break;
                case "/listItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.listItem(request, response);
                    break;
                case "/listPayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.listPayment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
