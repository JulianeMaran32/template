package br.com.juhmaran.petshop.template.local;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptionLocal;
    private String detailsLocal;
    private boolean doneLocal;

    public Local(String descriptionLocal, String detailsLocal, boolean doneLocal) {
        this.descriptionLocal = descriptionLocal;
        this.detailsLocal = detailsLocal;
        this.doneLocal = doneLocal;
    }

}
