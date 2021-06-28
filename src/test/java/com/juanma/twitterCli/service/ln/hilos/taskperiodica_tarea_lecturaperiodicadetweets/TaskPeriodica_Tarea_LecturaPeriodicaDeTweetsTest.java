
package com.juanma.twitterCli.service.ln.hilos.taskperiodica_tarea_lecturaperiodicadetweets;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanma.twitterCli.TwitterCliApp;
import com.juanma.twitterCli.domain.Configuration;
import com.juanma.twitterCli.errores.*;
import com.juanma.twitterCli.repository.UtilDB;
import com.juanma.twitterCli.service.Config;
import com.juanma.twitterCli.service.crud.ConfigurationServiceCRUD;

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
import org.springframework.context.ApplicationContext;
import java.io.File;

import java.util.*;


////START_{Import}
////END_{Import}

/**
* Una vez por minuto se revisan los tweets a descargar
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TwitterCliApp.class)
public class TaskPeriodica_Tarea_LecturaPeriodicaDeTweetsTest extends BaseTest
{

    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected ConfigurationServiceCRUD configService;
    
    @Autowired
    protected UtilDB udb;
    ////START_{AutoWired}
    ////END_{AutoWired}


    @Before
    public void init(){
      ////START_{Init}
////END_{Init}
    }


////START_{Init}
////END_{Init}



////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}
