package by.tc.sshop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ReqUtility {
    private static final String PREVIOUS_QUERY_TO_SESSION = "previousQuery";
    private static final char DATA_SEPARATOR = '?';

    private ReqUtility() {
    }

    public static void saveActualQueryToSession(HttpServletRequest request){
        HttpSession session = request.getSession(true);

        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();

        if(queryString == null){
            session.setAttribute(PREVIOUS_QUERY_TO_SESSION, requestURI);
            System.out.println("A part of URL without user data : " + requestURI + "is set in a session");
        }
        else {
            session.setAttribute(PREVIOUS_QUERY_TO_SESSION, requestURI + DATA_SEPARATOR + queryString);
            System.out.println(requestURI + DATA_SEPARATOR + queryString);
        }
    }
}

