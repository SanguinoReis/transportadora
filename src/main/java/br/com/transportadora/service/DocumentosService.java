package br.com.transportadora.service;

import br.com.transportadora.entity.Documento;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class DocumentosService {

    private EntityManager em;

    public Optional<Documento> pesquisarDocumentosExpedicao(String filtro) {
        try {

            var emf = Persistence.createEntityManagerFactory("transportadora-pu");
            em = emf.createEntityManager();

            Optional<Documento> doc = Optional.of(
                    em.createNamedQuery(Documento.FIND_BY_CODIGO_POSTAGEM, Documento.class)
                            .setParameter("codigoPostagem", filtro)
                            .getSingleResult());

            return doc;
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
