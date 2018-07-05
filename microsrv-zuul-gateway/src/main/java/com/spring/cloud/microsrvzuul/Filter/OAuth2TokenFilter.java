package com.spring.cloud.microsrvzuul.Filter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

public class OAuth2TokenFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(OAuth2TokenFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String userName = request.getParameter("userName");
        logger.info("userName: "+userName);
        return null;
    }
}