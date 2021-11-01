package br.com.transportadora.service;

import br.com.transportadora.entity.Documento;
import br.com.transportadora.entity.HistoricoPostagem;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class HistoricoService {

    private EntityManager em;

    public List<HistoricoPostagem> carregarHistoricoByDocumento(Documento documento) {
        try {

            var emf = Persistence.createEntityManagerFactory("transportadora-pu");
            em = emf.createEntityManager();

            return em.createNamedQuery(HistoricoPostagem.FIND_BY_DOCUMENTO, HistoricoPostagem.class)
                    .setParameter("documento", documento)
                    .getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }
}
