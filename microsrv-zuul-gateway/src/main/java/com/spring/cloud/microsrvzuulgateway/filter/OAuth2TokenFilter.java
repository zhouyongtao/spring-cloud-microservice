package com.spring.cloud.microsrvzuulgateway.filter;
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
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        Object accessToken = request.getHeader("Authorization");
        if (accessToken==null){
            logger.warn("Authorization token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("Authorization token is empty");
            return null;
        }
        logger.info("Authorization token is ok");
        return null;
    }
}