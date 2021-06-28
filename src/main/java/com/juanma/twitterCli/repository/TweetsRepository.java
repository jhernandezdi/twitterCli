
package com.juanma.twitterCli.repository;



import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.juanma.twitterCli.domain.Tweets;

import org.sine95.kernel.base.repository.RepositoryBase;
////START_{Import}
////END_{Import}


/**
 * Spring Data  repository for the Tweets entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TweetsRepository extends RepositoryBase< Tweets,Long > {

////START_{Others}
//Si hay que a�adir m�todos se incluyen aqu�, se recomienda utilizar este tipo de comentario para no interferir con el DELETE
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}
