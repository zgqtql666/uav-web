package com.dji.sample.component;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.dji.sample.component.AuthInterceptor.PARAM_TOKEN;

/**
 * @author sean.zhou
 * @version 0.1
 * @date 2021/11/22
 */
@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.addHeader("Access-Control-Allow-Origin", "http://119.29.247.126");//要改
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        res.addHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers," +
                "Authorization, Content-Length, X-CSRF-Token, Token,session,X_Requested_With,Accept, "+
                "Origin, Host, Connection, Accept-Encoding, Accept-Language,DNT, X-CustomHeader, Keep-Alive," +
                " User-Agent, X-Requested-With, If-Modified-Since, Cache-Control, Content-Type, Pragma," + PARAM_TOKEN);
        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
            return;
        }
        filterChain.doFilter(request, response);
    }
}
//package com.dji.sample.component;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import static com.dji.sample.component.AuthInterceptor.PARAM_TOKEN;
//
///**
// * @author sean.zhou
// * @version 0.1
// * @date 2021/11/22
// */
//@Component
//public class CorsFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse res = (HttpServletResponse) response;
//        res.addHeader("Access-Control-Allow-Credentials", "true");
//        res.addHeader("Access-Control-Allow-Origin", "http://localhost");
//        res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
//        res.addHeader("Access-Control-Allow-Headers",
//                "Authorization, Content-Length, X-CSRF-Token, Token,session,X-Requested-With,Accept, " +
//                        "Origin, Host, Connection, Accept-Encoding, Accept-Language,DNT, X-CustomHeader, Keep-Alive," +
//                        "User-Agent, X-Requested-With, If-Modified-Since, Cache-Control, Content-Type, Pragma");
//        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) request).getMethod())) {
//            // 对OPTIONS请求也设置必要的CORS响应头
//            res.setStatus(HttpServletResponse.SC_OK);
//            return;
//        }
//        filterChain.doFilter(request, response);
//    }
//}