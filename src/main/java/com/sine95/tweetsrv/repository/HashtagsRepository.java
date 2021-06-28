
package com.sine95.tweetsrv.repository;



import java.util.*;
import com.sine95.tweetsrv.domain.Hashtags;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.sine95.kernel.base.repository.RepositoryBase;
////START_{Import}
////END_{Import}


/**
 * Spring Data  repository for the Hashtags entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HashtagsRepository extends RepositoryBase< Hashtags,Long > {

////START_{Others}
//Si hay que a�adir m�todos se incluyen aqu�, se recomienda utilizar este tipo de comentario para no interferir con el DELETE
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}
