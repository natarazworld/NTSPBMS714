package com.nt.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class ZuulPreFilter extends ZuulFilter {
    private Logger logger= LoggerFactory.getLogger(ZuulPreFilter.class);
	@Override
	public boolean shouldFilter() {
		return true; // enables this  filter
	}

	@Override
	public Object run() throws ZuulException {
	    //  get RequestContext object  (it contains access to multiple other objects)
		 RequestContext context=RequestContext.getCurrentContext();
		 // get HttpServletRequest object from this
		 HttpServletRequest  req=context.getRequest();
		 System.out.println("ZuulPreFilter.run():: from pre-filter");
		 //write log messages about  current  request
		 logger.info("======From  PRE filter=====");
		 logger.info("request content type type::"+req.getContentType());
		 logger.info("request mode::"+req.getMethod());
		 logger.info("request path::"+req.getServletPath());
		 logger.info("request uri:: "+req.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return  FilterConstants.PRE_TYPE;  //makes the filter as prefilter
	}

	@Override
	public int filterOrder() {
		return 0;  //high priority
	}

}
