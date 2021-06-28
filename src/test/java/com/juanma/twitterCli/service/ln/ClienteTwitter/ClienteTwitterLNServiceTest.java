
package com.juanma.twitterCli.service.ln.ClienteTwitter;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanma.twitterCli.TwitterCliApp;
import com.juanma.twitterCli.domain.Configuration;
import com.juanma.twitterCli.domain.Hashtags;
import com.juanma.twitterCli.domain.HashtagsCrit;
import com.juanma.twitterCli.domain.HashtagsCritPaged;
import com.juanma.twitterCli.domain.HashtagsExt;
import com.juanma.twitterCli.domain.Tweets;
import com.juanma.twitterCli.domain.TweetsCrit;
import com.juanma.twitterCli.domain.TweetsCritPaged;
import com.juanma.twitterCli.domain.TweetsExt;
import com.juanma.twitterCli.enums.SiNo;
import com.juanma.twitterCli.errores.*;
import com.juanma.twitterCli.repository.UtilDB;
import com.juanma.twitterCli.service.Config;
import com.juanma.twitterCli.service.crud.ConfigurationServiceCRUD;
import com.juanma.twitterCli.service.crud.HashtagsServiceCRUD;
import com.juanma.twitterCli.service.crud.TweetsServiceCRUD;
import com.juanma.twitterCli.service.ln.ClienteTwitterLNService;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.test.*;
import org.sine95.kernel.base.Contexto;

import java.util.*;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;

////START_{Import}
////END_{Import}

/**
* Logica de negocio para el acceso a Twitter
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TwitterCliApp.class)
@Transactional
public class ClienteTwitterLNServiceTest extends BaseTest
{
////START_{AutoWired}
////END_{AutoWired}

    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected TweetsServiceCRUD tweetsService;

    @Autowired
    protected HashtagsServiceCRUD hashtagsService;


    @Autowired
    protected ClienteTwitterLNService serviceLN;

    @Autowired
    protected ConfigurationServiceCRUD configService;
    
    @Autowired
    protected UtilDB udb;

    @Before
    public void init(){
      ////START_{Init}
      ////END_{Init}
    }

////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}
