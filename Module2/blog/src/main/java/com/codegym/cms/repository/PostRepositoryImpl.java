package com.codegym.cms.repository;

import com.codegym.cms.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
    public class PostRepositoryImpl implements PostRepository<Post> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Post> findAll() {
        TypedQuery<Post> query = em.createQuery("select c from Post c", Post.class);
        return query.getResultList();
    }
    @Override
    public Post findById(Long id) {
        TypedQuery<Post> query = em.createQuery("select c from Post c where  c.id=:id", Post.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public void save(Post model) {
        if (model.getId() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }




        @Override
        public void remove(Long id){
            Post article = findById(id);
            if (article != null) {
                em.remove(article);
            }
        }
    }