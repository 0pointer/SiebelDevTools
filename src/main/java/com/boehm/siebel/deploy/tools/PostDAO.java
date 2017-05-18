package com.boehm.siebel.deploy.tools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by boechr on 18.05.2017.
 */
public interface PostDAO extends CrudRepository<PostDAO, Long> {
    List<LinkDTO> getLinks();
}
