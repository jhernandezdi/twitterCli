package org.sine95.kernel.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class UtilException {

	public static String printStackTrace(Throwable exc)
	{
		StringWriter sw=new StringWriter();
		PrintWriter sal=new PrintWriter(sw);
		exc.printStackTrace(sal);
		String res=sw.toString();
		
		sal.close();
		
		return res;
	}
}
