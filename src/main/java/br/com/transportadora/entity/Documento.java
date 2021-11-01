package br.com.transportadora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "documentos")
@NamedQuery(name = Documento.FIND_BY_CODIGO_POSTAGEM, query = "SELECT d FROM Documento d WHERE d.codigoPostagem =:codigoPostagem")

public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_CODIGO_POSTAGEM = "Documento.findByCodigoPostagem";

    private Long documentoId;
    private String codigoPostagem;
    private BigDecimal peso;
    private Destinatario destinatario;

    public Documento() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documentos_seq")
    @SequenceGenerator(name = "documentos_seq", sequenceName = "documentos_seq", allocationSize = 1)
    public Long getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Long documentoId) {
        this.documentoId = documentoId;
    }

    @Column(name = "codigo_postagem")
    public String getCodigoPostagem() {
        return codigoPostagem;
    }

    public void setCodigoPostagem(String codigoPostagem) {
        this.codigoPostagem = codigoPostagem;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    @Embedded
    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codigoPostagem == null) ? 0 : codigoPostagem.hashCode());
        result = prime * result
                + ((documentoId == null) ? 0 : documentoId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Documento other = (Documento) obj;
        if (codigoPostagem == null) {
            if (other.codigoPostagem != null)
                return false;
        } else if (!codigoPostagem.equals(other.codigoPostagem))
            return false;
        if (documentoId == null) {
            if (other.documentoId != null)
                return false;
        } else if (!documentoId.equals(other.documentoId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Documento [documentoId=" + documentoId + ", codigoPostagem=" + codigoPostagem + ", peso=" + peso
                + ", destinatario=" + destinatario + "]";
    }
}
