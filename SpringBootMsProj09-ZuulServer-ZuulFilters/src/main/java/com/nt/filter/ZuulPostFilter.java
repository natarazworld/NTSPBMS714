package com.nt.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class ZuulPostFilter extends ZuulFilter {
    private Logger logger= LoggerFactory.getLogger(ZuulPostFilter.class);
	@Override
	public boolean shouldFilter() {
		return true; // enables this  filter
	}

	@Override
	public Object run() throws ZuulException {
	    //  get RequestContext object  (it contains access to multiple other objects)
		 RequestContext context=RequestContext.getCurrentContext();
		 // get HttpServletResponse object from this
		 HttpServletResponse  res=context.getResponse();
		 System.out.println("ZuulPostFilter.run():: from post-filter");
		 //write log messages about  current  request
		 logger.info("======From  Post filter=====");
		 logger.info("response content type type::"+res.getContentType());
		 logger.info("response status::"+res.getStatus());
		 logger.info("response status code::"+res.getHeader("host"));
		return null;	}

	@Override
	public String filterType() {
		return  FilterConstants.POST_TYPE;  //makes the filter as postfilter
	}

	@Override
	public int filterOrder() {
		return 0;  //high priority
	}

}
