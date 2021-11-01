package br.com.transportadora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "historico_postagem")
@NamedQueries({
        @NamedQuery(name = HistoricoPostagem.FIND_BY_DOCUMENTO, query = "SELECT h FROM HistoricoPostagem h WHERE h.documento = :documento ORDER BY h.data DESC")
})

@Embeddable
public class HistoricoPostagem implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_DOCUMENTO = "HistoricoPostagem.findByDocumento";

    private Long historicoId;
    private String comentario;
    private Instant data;
    private Documento documento;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_seq")
    @SequenceGenerator(name = "historico_seq", sequenceName = "historico_seq", allocationSize = 1)
    public Long getHistoricoId() {
        return historicoId;
    }

    public void setHistoricoId(Long historicoId) {
        this.historicoId = historicoId;
    }

    @OneToOne
    @JoinColumn(name = "documento_id")
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Column(name = "data_hora_movimento")
    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }
}
