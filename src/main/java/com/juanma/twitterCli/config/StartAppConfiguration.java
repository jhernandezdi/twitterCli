
package com.juanma.twitterCli.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartAppConfiguration {

    private String executeInit;

    private String modeTest;

  public  StartAppConfiguration (

    @Value("${StartApp.executeInit}") String executeInit 

    ,@Value("${StartApp.modeTest}") String modeTest 

  )
  {
    this.executeInit=executeInit;

    this.modeTest=modeTest;
  }

    public String getExecuteInit()
    {
      return this.executeInit;
    }

    public String getModeTest()
    {
      return this.modeTest;
    }
}
