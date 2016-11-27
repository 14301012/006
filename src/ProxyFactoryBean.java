

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactoryBean {
	
	private Object tar;
	
	private String InterfacesName;	
	
	
	private List<Advice> inter;
	
	
	public Object getProxy()
	{
		Object proxyObject=null;
		if(inter.size()>0)
		{
			proxyObject=tar;
			for(int i=0;i<inter.size();i++)
			{
				inter.get(i).setTargetObject(proxyObject);
				try {
					proxyObject = Proxy.newProxyInstance(this.getClass().getClassLoader(), tar.getClass().getInterfaces() , (InvocationHandler) inter.get(i));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			return proxyObject;
		}
		else {
			return tar;
		}
		
	}

	public Object getTarget() {
		return tar;
	}

	public void setTarget(Object tar) {
		this.tar = tar;
	}
	
	public String getProxyInterfaces() {
		return InterfacesName;
	}

	public void setProxyInterfaces(String InterfacesName) {
		this.InterfacesName = InterfacesName;
	}


	public List<Advice> getInterceptorNames() {
		return inter;
	}

	public void setInterceptorNames(List<Advice> inter) {
		this.inter = inter;
	}



	
}
