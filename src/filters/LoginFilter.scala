package filters

import javax.servlet.Filter
import javax.servlet.ServletResponse
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.http.HttpServletResponse
import beans.LoginBean
import javax.servlet.http.HttpServletRequest
import beans.SessionBean
import javax.servlet.FilterConfig

class LoginFilter extends Filter{
  @Override
	def doFilter(request:ServletRequest, response:ServletResponse, chain:FilterChain){
        val sessionBean=request.asInstanceOf[HttpServletRequest].getSession().getAttribute("sessionBean").asInstanceOf[SessionBean]
         
        if (sessionBean == null || sessionBean.userId==null) {
          //request.asInstanceOf[HttpServletRequest].getRequestDispatcher("/login.xhtml").forward(request, response)
          response.asInstanceOf[HttpServletResponse].sendRedirect(request.asInstanceOf[HttpServletRequest].getContextPath()+"/login.xhtml")
        }
        chain.doFilter(request, response);
             
    }
  @Override
    def init(config:FilterConfig){
        // Nothing to do here!
    }
  @Override
    def destroy() {
        // Nothing to do here!
    }  
}