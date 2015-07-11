package web.com.accountservice.servlets;

import bl.com.accountservice.service.AccountService;
import bl.com.accountservice.service.Impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Илья
 * @Created 07.07.2015.
 */
public class AccountServiceServlet extends HttpServlet {


    private static final String MODE_PARAM = "mode";
    private static final String USER_ID_PARAM = "id";
    private static final String VALUE_TO_ADD_PARAM = "value";

    private static final String ADD_AMOUNT_MODE = "addamount";
    private static final String GET_AMOUNT_MODE = "getamount";

    private static final String INCORRECT_MODE_RESPONSE = "Error. Incorrect mode";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Integer userId = new Integer(request.getParameter(USER_ID_PARAM));
        String mode = request.getParameter(MODE_PARAM);
        String responseString;
        switch (mode) {
            case GET_AMOUNT_MODE:
                responseString = processGetAmmountReq(userId);
                break;
            case ADD_AMOUNT_MODE:
                Long value = new Long(request.getParameter(VALUE_TO_ADD_PARAM));
                responseString = processAddAmountReq(userId, value);
                break;
            default:
                responseString = INCORRECT_MODE_RESPONSE;
        }

        out.println(responseString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    private String processGetAmmountReq(Integer userId) {
        AccountService service = new AccountServiceImpl();
        String response;
        try {
            Long balance = service.getAmount(userId);
            response = "Amount of user with id = " +
                    userId + " is " +
                    balance + " rub.";
        } catch (Exception e) {
            response = "Error. " + e.getMessage();
        }

        return response;
    }

    private String processAddAmountReq(Integer userId, Long value) {
        AccountService service = new AccountServiceImpl();
        String response;
        try {
            Long balance = service.addAmount(userId, value);
            response = "Transaction is successful (" +
                    value + " rub).\nAmount of user with id = " +
                    userId + " is " +
                    balance + " rub.";
        } catch (Exception e) {
            response = "Error. " + e.getMessage();
        }

        return response;
    }
}
